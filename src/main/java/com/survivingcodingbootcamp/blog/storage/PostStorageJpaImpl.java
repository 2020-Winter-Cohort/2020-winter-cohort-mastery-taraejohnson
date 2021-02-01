package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.storage.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class PostStorageJpaImpl implements PostStorage {

    private PostRepository postRepo;
    private HashtagRepository hashtagRepo;

    public PostStorageJpaImpl(PostRepository postRepo, HashtagRepository hashtagRepo) {
        this.postRepo = postRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public Iterable<Post> retrieveAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post retrievePostById(Long id) {
        return postRepo.findById(id).get();
    }

    @Override
    public void save(Post postToAdd) {
        postRepo.save(postToAdd);
    }

    public Hashtag addHashtag(Long id, Hashtag hashtag) {
        return hashtagRepo.save(hashtag);
    }
}
