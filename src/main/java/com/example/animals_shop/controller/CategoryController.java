package com.example.animals_shop.controller;

import com.example.animals_shop.model.Category;
import com.example.animals_shop.repository.CategoryRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/add")
    public String addCategoryView(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryRepository.findAll());
        return ("categoryAdd");
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category, @RequestParam("categoryImage") MultipartFile multipartFile) throws IOException {
        String name = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        File file = new File("C:\\Users\\User\\IdeaProjects\\animals_shop\\images\\category_images\\" + name);
        multipartFile.transferTo(file);
        category.setCatImage(name);
//        category.setParentCat(categoryRepository.getCategoryById(category.getId()));
        categoryRepository.save(category);
        return "redirect:/";
    }

    @GetMapping("/getImage")
    public void getImageAsByteArray(HttpServletResponse response, @RequestParam("catImage") String imageUrl) throws IOException {
        InputStream in = new FileInputStream("C:\\Users\\User\\IdeaProjects\\animals_shop\\images\\category_images\\" + imageUrl);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }
}
