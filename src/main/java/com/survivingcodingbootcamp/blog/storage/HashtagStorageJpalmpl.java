package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HashtagStorageJpalmpl implements HashtagStorage {

    @Resource
    private HashtagRepository hashtagRepo;

    public HashtagStorageJpalmpl(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public Iterable<Hashtag> retrieveAllHashtags() {
        return hashtagRepo.findAll();
    }

    @Override
    public void save(Hashtag hashtagToSave) {
        hashtagRepo.save(hashtagToSave);
    }

    @Override
    public Hashtag retrieveSingleHashtag(long id) {
        return hashtagRepo.findById(id).get();
    }

    @Override
    public Hashtag addHashtag(Long id, Hashtag hashtag) {
        return hashtagRepo.save(hashtag);
    }

    @Override
    public void addHashtag(Hashtag hashtagToAdd) {

    }

}
