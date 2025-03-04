package com.example.demo_sprinboot.productBacklog;

import com.example.demo_sprinboot.userStory.UserStory;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor @Accessors @Getter
@Entity
@Table(name = "product_backlogs")
public class ProductBacklog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;                  // title

    private String description;

    private String priority ;              // HIGHT, MEDIUM, LOW

    private String status ;                 // TO DO , IN PROGRESS , DONE

    private LocalDateTime createdAt ;       // date of creation

    private LocalDateTime updatedAt ;

    @OneToMany(mappedBy = "productBacklog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserStory> userStories;


    public ProductBacklog(String name) {
        this.name = name;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }


}


