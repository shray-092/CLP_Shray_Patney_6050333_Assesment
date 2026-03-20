package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Track;
import com.example.demo.repository.Trackrepository;

@RestController
public class TrackController {

    @Autowired
    private Trackrepository repo;

    @PostMapping("/add")
    public ResponseEntity<String> addTrack(@RequestBody Track track) {
        repo.save(track);
        return ResponseEntity.ok("Track added successfully");
    }

    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> getTracks() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/tracks/title/{title}")
    public ResponseEntity<List<Track>> getTracksByTitle(@PathVariable String title) {
        return ResponseEntity.ok(repo.findByTitle(title));
    }

    @GetMapping("/track/{id}")
    public ResponseEntity<Object> getTrack(@PathVariable Long id) {
        Track track = repo.findById(id).orElse(null);
        if (track != null) {
            return ResponseEntity.ok(track);
        } else {
            return ResponseEntity.ok("Track not found");
        }
    }
}