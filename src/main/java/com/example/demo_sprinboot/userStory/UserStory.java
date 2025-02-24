package com.example.demo_sprinboot.userStory;

import com.example.demo_sprinboot.productBacklog.ProductBacklog;
import jakarta.persistence.*;

@Entity
@Table
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "product_backlog_id")
    private ProductBacklog productBacklog;


    public UserStory() {
    }


    public UserStory(String title) {
        this.title = title;
    }


    public UserStory(int id, String title, ProductBacklog productBacklog) {
        this.id = id;
        this.title = title;
        this.productBacklog = productBacklog;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductBacklog getProductBacklog() {
        return productBacklog;
    }

    public void setProductBacklog(ProductBacklog productBacklog) {
        this.productBacklog = productBacklog;
    }

    @Override
    public String toString() {
        return "UserStory{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", productBacklog=" + productBacklog +
                '}';
    }
}