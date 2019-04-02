package com.example.animals_shop.repository;

import com.example.animals_shop.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
    //List<Category> findPostByCategory(int categoryId);
}
