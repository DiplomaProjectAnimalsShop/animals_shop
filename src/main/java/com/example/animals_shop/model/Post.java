package com.example.animals_shop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column(name = "short_text")
    private String shortText;
    @Column
    private String content;
    @Column(name = "created_date")
    private Date createdDate;
    @Column
    private Double price;
    @Column
    private String location;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private PostType postType;
}
