package com.example.demo_sprinboot.acceptanceCriteria;

import com.example.demo_sprinboot.userStory.UserStory;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acceptance_criteria")
@Data
@NoArgsConstructor
public class AcceptanceCriteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_story_id")
    private UserStory userStory;

    private String description;
}