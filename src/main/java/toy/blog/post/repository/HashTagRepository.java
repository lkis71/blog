package toy.blog.post.repository;

import toy.blog.post.entity.HashTag;

public interface HashTagRepository {

    public void save(HashTag hashTag);

    public HashTag findOne(Long id);

    public HashTag findByName(String name);

}
