package com.survivingcodingbootcamp.blog.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    @ManyToOne
    private Topic topic;
    @Lob
    private String content;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    protected Post() {

    }

    public Post(String title, String author, Topic topic, String content, Hashtag... hashtags) {
        this.title = title;
        this.author = author;
        this.topic = topic;
        this.content = content;
        this.hashtags = List.of(hashtags);
    }

    public Post(Collection<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public Post(String title, String author, Topic retrieveSingleTopic, String content, String tagName) {
    }

    public Post(String title, Topic topic, String content) {
        this.title = title;
        this.topic = topic;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Topic getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public void addHashtag(Hashtag userHashtag) {
        hashtags.add(userHashtag);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", topic=" + topic +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != null ? !id.equals(post.id) : post.id != null) return false;
        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (author != null ? !author.equals(post.author) : post.author != null) return false;
        if (topic != null ? !topic.equals(post.topic) : post.topic != null) return false;
        return content != null ? content.equals(post.content) : post.content == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
