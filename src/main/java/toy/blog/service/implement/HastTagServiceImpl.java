package toy.blog.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.entity.HashTag;
import toy.blog.repository.HashTagRepository;
import toy.blog.service.HashTagService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HastTagServiceImpl implements HashTagService {

    private final HashTagRepository hashTagRepository;

    @Override
    public Long save(HashTag hashTag) {
        hashTagRepository.save(hashTag);
        return hashTag.getId();
    }
}
