//package com.example.animals_shop.controller;
//
//import com.example.animals_shop.model.Image;
//import com.example.animals_shop.model.Post;
//import com.example.animals_shop.repository.CategoryRepository;
//import com.example.animals_shop.repository.PostRepository;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Controller
//@RequestMapping(value = "/post")
//public class PostController {
//
//    @Autowired
//    private PostRepository postRepository;
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @GetMapping("/add")
//    public String addPostView(ModelMap modelMap) {
//        modelMap.addAttribute("categories", categoryRepository.findAll());
//        return "addPost";
//    }
//
//    @PostMapping("/add")
//    public String addPost(@ModelAttribute Post post) {
//       // String name = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
//       // File file = new File("C:\\Users\\User\\IdeaProjects\\animals_shop\\images\\post_files\\" + name);
//        //multipartFile.transferTo(file);
//        //post.setImageUrl(name);
//        postRepository.save(post);
//        return "redirect:/";
//    }
//    @PostMapping("/uploadFile")
//    public Image uploadFile(@RequestParam("file") MultipartFile file) {
//        Image image = DBFileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(image.getPost().getId())
//                .toUriString();
//
//        return new Image(image.getPath(), fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//    @PostMapping("/uploadMultipleFiles")
//    public List <Image> uploadMultipleFiles(@RequestParam("image") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(image -> uploadFile(image))
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("/byCategory")
//    public String byCategory(@RequestParam("categoryId") int categoryId, ModelMap modelMap) {
//       // modelMap.addAttribute("posts", postRepository.findPostByCategory(categoryId));
//        return "postsByCategory";
//    }
//
//    @GetMapping("/getImage")
//    public void getImageAsByteArray(HttpServletResponse response, @RequestParam("imageUrl") String imageUrl) throws IOException {
//        InputStream in = new FileInputStream("C:\\Users\\User\\IdeaProjects\\animals_shop\\images\\post_files\\" + imageUrl);
//        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//        IOUtils.copy(in, response.getOutputStream());
//    }
//}
