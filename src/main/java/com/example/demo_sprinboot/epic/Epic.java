package com.example.demo_sprinboot.epic;

import com.example.demo_sprinboot.productBacklog.ProductBacklog;
import com.example.demo_sprinboot.userStory.UserStory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Entity
@Data
@AllArgsConstructor @Accessors @Getter
@NoArgsConstructor

public class Epic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JsonBackReference
    private ProductBacklog productBacklog;

    @OneToMany(mappedBy = "epic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<UserStory> userStories;

}
