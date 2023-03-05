package toy.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import toy.blog.entity.HashTag;
import toy.blog.entity.PostHashTag;

import java.util.List;
import java.util.Optional;

public interface HashTagRepository {

    public void save(HashTag hashTag);

    public HashTag findOne(Long id);

    public HashTag findByName(String name);

}
