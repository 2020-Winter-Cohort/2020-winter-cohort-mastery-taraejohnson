package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;

public interface HashtagStorage {
    Iterable<Hashtag> retrieveAllHashtags();

    void save(Hashtag hashtagToSave);

    Hashtag retrieveSingleHashtag(long id);

    Hashtag addHashtag(Long id, Hashtag hashtag);

    void addHashtag(Hashtag hashtagToAdd);
}
