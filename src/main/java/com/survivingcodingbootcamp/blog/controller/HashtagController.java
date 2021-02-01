package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import com.survivingcodingbootcamp.blog.storage.HashtagStorageJpalmpl;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.storage.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HashtagController {

    private HashtagStorage hashtagStorage;
    private PostStorage postStorage;
    private HashtagRepository hashtagRepo;
    private PostRepository postRepo;

    public HashtagController(HashtagStorageJpalmpl inHashtagStore, PostStorage inPostStore, HashtagRepository inHashtagRepo, PostRepository inPostRepo) {
        this.hashtagStorage = inHashtagStore;
        this.postStorage = inPostStore;
        this.hashtagRepo = inHashtagRepo;
        this.postRepo = inPostRepo;
    }

    @RequestMapping({"/all-hashtags"})
    public String displayHashtags(Model model) {
        model.addAttribute("hashtag", hashtagStorage.retrieveAllHashtags());
        model.addAttribute("post", postStorage.retrieveAllPosts());
        return "all-hashtags-template";
    }

    @RequestMapping("/hashtag/{id}")
    public String displaySingleHashtag(Model model, @PathVariable Long id) {
        model.addAttribute("hashtag", hashtagStorage.retrieveSingleHashtag(id));
        model.addAttribute("hashtags", hashtagStorage.retrieveAllHashtags());
        model.addAttribute("posts", postStorage.retrieveAllPosts());
        return "single-hashtag-template";
    }

    @RequestMapping({"/hashtag/posts/{id}"})
    public String displayReviewsInHashtag(Model model, @PathVariable Long id) {
        model.addAttribute("post", postStorage.retrievePostById(id));
        model.addAttribute("allHashtags", hashtagStorage.retrieveAllHashtags());
        model.addAttribute("postsInHash", postStorage.retrieveAllPosts());
        return "redirect:/posts/" + id;
    }

    @RequestMapping(value = "hashtags/add", method = RequestMethod.POST)
    public String addHashtag(@RequestParam String tagName, @RequestParam Long id) {
        Post postToAdd = postStorage.retrievePostById(id);
        Hashtag hashtagToSave = new Hashtag(tagName);
        hashtagStorage.save(hashtagToSave);
        postToAdd.addHashtag(hashtagToSave);
        postStorage.save(postToAdd);
        return "redirect:/posts/" + id;
    }
}
