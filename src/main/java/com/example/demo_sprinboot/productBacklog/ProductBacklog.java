package com.example.demo_sprinboot.productBacklog;

import com.example.demo_sprinboot.userStory.UserStory;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "product_backlogs")
public class ProductBacklog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "productBacklog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserStory> userStories;

    public ProductBacklog() {
    }

    public ProductBacklog(String name) {
        this.name = name;
    }
}