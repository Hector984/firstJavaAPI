package com.api.restfullapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Page")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDateTime dateCreation; // Se traduce en date_creation

    @OneToOne
    @JoinColumn(name="id_User", unique = true)
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_page")
    private List<PostEntity> posts = new ArrayList<>();

    public void addPost(PostEntity post) {
        posts.add(post);
    }

    public void deletePost(PostEntity post) {
        posts.remove(post);
    }
}