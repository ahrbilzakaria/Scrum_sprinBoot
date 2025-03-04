package com.example.demo_sprinboot.userStory;

    import com.example.demo_sprinboot.task.Task;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class UserStoryService {

        private final UserStoryRepository userStoryRepository;

        @Autowired
        public UserStoryService(UserStoryRepository userStoryRepository) {
            this.userStoryRepository = userStoryRepository;
        }

        public List<UserStory> getAllUserStories() {
            return userStoryRepository.findAll();
        }

        public UserStory getUserStoryById(Long id) {
            return userStoryRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User story with id " + id + " not found"));
        }

        public UserStory createUserStory(UserStory userStory) {
            return userStoryRepository.save(userStory);
        }

        public UserStory updateUserStory(Long id, UserStory userStory) {
            Optional<UserStory> existingUserStory = userStoryRepository.findById(id);
            if (existingUserStory.isPresent()) {
                UserStory updatedUserStory = existingUserStory.get();
                updatedUserStory.setTitle(userStory.getTitle());
                updatedUserStory.setDescription(userStory.getDescription());
                updatedUserStory.setAsA(userStory.getAsA());
                updatedUserStory.setIWant(userStory.getIWant());
                updatedUserStory.setSoThat(userStory.getSoThat());
                updatedUserStory.setPriority(userStory.getPriority());
                updatedUserStory.setStatus(userStory.getStatus());
                updatedUserStory.setEpic(userStory.getEpic());
                updatedUserStory.setSprintBacklog(userStory.getSprintBacklog());
                updatedUserStory.setTasks(userStory.getTasks());
                updatedUserStory.setProductBacklog(userStory.getProductBacklog());
                return userStoryRepository.save(updatedUserStory);
            } else {
                throw new RuntimeException("User story with id " + id + " not found");
            }
        }

        public void deleteUserStoryById(Long id) {
            if (userStoryRepository.existsById(id)) {
                userStoryRepository.deleteById(id);
            } else {
                throw new RuntimeException("User story with id " + id + " not found");
            }
        }

        public UserStory addTaskToUserStory(Long userStoryId, Task task) {
            UserStory userStory = getUserStoryById(userStoryId);
            userStory.getTasks().add(task);
            task.setUserStory(userStory);
            return userStoryRepository.save(userStory);
        }

        public UserStory updateAsAAndIWantAndSoThat(Long id, String asA, String iWant, String soThat) {
            UserStory userStory = getUserStoryById(id);
            userStory.setAsA(asA);
            userStory.setIWant(iWant);
            userStory.setSoThat(soThat);
            return userStoryRepository.save(userStory);
        }

        public UserStory updatePriority(Long id, String priority) {
            UserStory userStory = getUserStoryById(id);
            userStory.setPriority(priority);
            return userStoryRepository.save(userStory);
        }

        public UserStory updateTitle(Long id, String title) {
            UserStory userStory = getUserStoryById(id);
            userStory.setTitle(title);
            return userStoryRepository.save(userStory);
        }

        public UserStory updateDescription(Long id, String description) {
            UserStory userStory = getUserStoryById(id);
            userStory.setDescription(description);
            return userStoryRepository.save(userStory);
        }
    }