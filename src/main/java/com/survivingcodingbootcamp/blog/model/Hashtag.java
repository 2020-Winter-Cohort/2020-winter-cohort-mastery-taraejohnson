package com.survivingcodingbootcamp.blog.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue
    private long id;
    private String tagName;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> posts;

    public Hashtag(Collection<Post> posts) {
        this.posts = posts;
    }

    public Hashtag(String tagName, Collection<Post> posts) {
        this.tagName = tagName;
        this.posts = posts;
    }

    public Hashtag(String tagName) {
        this.tagName = tagName;
    }

    public Hashtag() {

    }

    public long getId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hashtag hashtag = (Hashtag) o;

        if (id != hashtag.id) return false;
        return tagName != null ? tagName.equals(hashtag.tagName) : hashtag.tagName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        return result;
    }
}
