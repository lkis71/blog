package toy.blog.service;

import toy.blog.entity.Post;

import java.util.List;

/**
 * 포스팅 서비스
 */
public interface PostService {

    /**
     * 포스팅
     *
     * @param insert
     * @return the long
     */
    public Long insert(Post post);

    /**
     * 게시글 조회
     *
     * @param id
     * @return the post
     */
    public Post findOne(Long id);

    /**
     * 게시글 목록 조회
     *
     * @return the list
     */
    public List<Post> fineAll();

    /**
     * 게시글 수정
     *
     * @param id
     * @param title
     * @param content
     * @return the post
     */
    public Post updatePost(Long id, String title, String content);

    /**
     * 게시글 삭제
     *
     * @param id
     */
    public void deletePost(Long id);
}
