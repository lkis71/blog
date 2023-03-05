package toy.blog.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.entity.PostHashTag;
import toy.blog.repository.PostHashTagRepository;
import toy.blog.service.PostHashTagService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class PostHashTagServiceImpl implements PostHashTagService {

    private final PostHashTagRepository postHashTagRepository;

    @Override
    public Long save(PostHashTag postHashTag) {
        postHashTagRepository.save(postHashTag);
        return postHashTag.getId();
    }
}
