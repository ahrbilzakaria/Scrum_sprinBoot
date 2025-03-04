package com.example.demo_sprinboot.epic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/epics")
public class EpicController {

    @Autowired
    private EpicService epicService;

    @PostMapping
    public ResponseEntity<EpicDTO> createEpic(@RequestBody EpicDTO epicDTO) {
        EpicDTO createdEpic = epicService.createEpic(epicDTO);
        return ResponseEntity.status(201).body(createdEpic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EpicDTO> updateEpic(@PathVariable Long id, @RequestBody EpicDTO epicDTO) {
        EpicDTO updatedEpic = epicService.updateEpic(id, epicDTO);
        return ResponseEntity.ok().body(updatedEpic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpic(@PathVariable Long id) {
        epicService.deleteEpic(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpicDTO> getEpicById(@PathVariable Long id) {
        EpicDTO epicDTO = epicService.getEpicById(id);
        return ResponseEntity.ok().body(epicDTO);
    }

    @GetMapping
    public ResponseEntity<List<EpicDTO>> getAllEpics() {
        List<EpicDTO> epics = epicService.getAllEpics();
        return ResponseEntity.ok().body(epics);
    }

    @PutMapping("/{epicId}/productBacklog/{productBacklogId}")
    public ResponseEntity<Void> setProductBacklog(@PathVariable Long epicId, @PathVariable Long productBacklogId) {
        epicService.setProductBacklog(epicId, productBacklogId);
        return ResponseEntity.noContent().build();
    }
}