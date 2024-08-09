package com.example.hw4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
    private Integer age;
    private Boolean enabled;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Article> articleList;
}
