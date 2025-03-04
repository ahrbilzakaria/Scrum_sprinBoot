package com.example.demo_sprinboot.epic;

import com.example.demo_sprinboot.productBacklog.ProductBacklog;
import com.example.demo_sprinboot.userStory.UserStory;
import com.example.demo_sprinboot.userStory.UserStoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EpicDTO {
    private Long id;
    private String name;
    private String description;
    private Long productBacklogId;
    private List<UserStoryDTO> userStoryList;
}
