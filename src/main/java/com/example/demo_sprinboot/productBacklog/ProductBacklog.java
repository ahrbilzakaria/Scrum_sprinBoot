package com.example.demo_sprinboot.productBacklog;


import com.example.demo_sprinboot.userStory.UserStory;
import jakarta.persistence.*;


import java.util.List;


@Entity
@Table
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserStory> getUserStories() {
        return userStories;
    }

    public void setUserStories(List<UserStory> userStories) {
        this.userStories = userStories;
    }

    @Override
    public String toString() {
        return "ProductBacklog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userStories=" + userStories +
                '}';
    }
}
