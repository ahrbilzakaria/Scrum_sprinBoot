package com.example.demo_sprinboot.epic;
import java.util.List;

    public interface EpicService {

        public EpicDTO createEpic(EpicDTO epicDTO);

        public EpicDTO updateEpic(Long id, EpicDTO epicDTO);

        public void deleteEpic(Long id);

        public EpicDTO getEpicById(Long id);

        public List<EpicDTO> getAllEpics();

        void setProductBacklog(Long epicId, Long productBacklogId);
    }

