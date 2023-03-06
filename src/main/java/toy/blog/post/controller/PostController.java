package toy.blog.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toy.blog.post.dto.request.SavePostRequest;
import toy.blog.post.dto.response.SavePostResponse;
import toy.blog.post.entity.Member;
import toy.blog.post.entity.Post;
import toy.blog.post.service.PostService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public SavePostResponse savePost(@RequestBody @Valid SavePostRequest postRequest) {

        Member member = Member.createMember("testId", "1234");
        Post post = new Post.Builder(member, postRequest.getTitle())
                .setContent(postRequest.getContent()).build();

        Long postId = postService.save(post);

        return new SavePostResponse(postId);
    }
}
