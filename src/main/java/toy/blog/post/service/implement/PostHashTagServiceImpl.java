package toy.blog.post.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.post.entity.PostHashTag;
import toy.blog.post.repository.PostHashTagRepository;
import toy.blog.post.service.PostHashTagService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostHashTagServiceImpl implements PostHashTagService {

    private final PostHashTagRepository postHashTagRepository;

    @Override
    @Transactional
    public Long save(PostHashTag postHashTag) {
        postHashTagRepository.save(postHashTag);
        return postHashTag.getId();
    }
}
