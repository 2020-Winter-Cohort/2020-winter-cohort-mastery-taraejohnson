package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostStorage postStorage;
    private HashtagStorage hashStore;

    public PostController(PostStorage postStorage, HashtagStorage hashStore) {
        this.postStorage = postStorage;
        this.hashStore = hashStore;
    }

    @GetMapping("/{id}")
    public String displaySinglePost(@PathVariable Long id, Model model) {
        model.addAttribute("postToShow", postStorage.retrievePostById(id));
        model.addAttribute("hashtags", hashStore.retrieveAllHashtags());
        return "single-post-template";
    }
}
