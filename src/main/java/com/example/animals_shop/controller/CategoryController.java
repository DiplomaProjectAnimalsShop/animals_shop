package com.example.animals_shop.controller;

import com.example.animals_shop.model.Category;
import com.example.animals_shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/add")
    public String addCategoryView(){
        return ("addCategory");
    }

    @PostMapping("/add")
    public  String addCategory(@ModelAttribute Category category){
        categoryRepository.save(category);
        return "redirect:/";
    }
}
