package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Post;

public interface PostStorage {
    Iterable<Post> retrieveAllPosts();

    Post retrievePostById(Long id);

    void save(Post postToAdd);

}