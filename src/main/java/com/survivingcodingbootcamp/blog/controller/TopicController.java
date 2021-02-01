package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/topics")
public class TopicController {

    private TopicStorage topicStorage;
    private PostStorage postStorage;
    private HashtagStorage hashtagStorage;

    public TopicController(TopicStorage topicStorage, PostStorage postStorage, HashtagStorage hashtagStorage) {
        this.topicStorage = topicStorage;
        this.postStorage = postStorage;
        this.hashtagStorage = hashtagStorage;
    }

    @RequestMapping("/{id}")
    public String displaySingleTopic(@PathVariable long id, Model model) {
        model.addAttribute("topic", topicStorage.retrieveSingleTopic(id));
        return "single-topic-template";
    }

    @RequestMapping(value = "/topicPost/add", method = RequestMethod.POST)
    public String submit(@RequestParam String title, @RequestParam String author,
                         @RequestParam Long id, @RequestParam String content, @RequestParam String tagName) {
        Hashtag hashtagToAddToNewPost = new Hashtag(tagName);
        Post userPost = new Post(title, author, topicStorage.retrieveSingleTopic(id), content, hashtagToAddToNewPost);
        hashtagStorage.save(hashtagToAddToNewPost);
        postStorage.save(userPost);
        return "redirect:/topics/" + id;
    }
}