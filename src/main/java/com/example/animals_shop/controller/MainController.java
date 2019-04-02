package com.example.animals_shop.controller;

import com.example.animals_shop.model.Post;
import com.example.animals_shop.model.User;
import com.example.animals_shop.repository.CategoryRepository;
import com.example.animals_shop.repository.PostRepository;
import com.example.animals_shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/")
    public String main(ModelMap modelMap) {
        List <User> all = userRepository.findAll();
        List <Post> allPosts = postRepository.findAll();
        modelMap.addAttribute("users", all);
        modelMap.addAttribute("posts", allPosts);
        modelMap.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }
}
