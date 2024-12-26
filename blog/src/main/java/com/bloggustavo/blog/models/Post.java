package com.bloggustavo.blog.models;

import com.bloggustavo.blog.dtos.PostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Users author;

    @Column(nullable = false,unique = true)
    private String title;

    @ManyToMany
    @JoinColumn(name = "category_id")
    private List<Categories> categories;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false,name = "date")
    private LocalDateTime dateOfCreation;

    public Post(PostDTO postDTO) {
        this.author = postDTO.author();
        this.title = postDTO.title();
        this.categories = postDTO.category();
        this.description = postDTO.description();
        this.dateOfCreation = postDTO.dateOfCreation();
    }
}
