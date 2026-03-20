package com.example.springboot.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entities.Track;
import com.example.springboot.repo.TrackRepository;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    @Autowired
    private TrackRepository trackRepository;

    @PostMapping
    public ResponseEntity<String> addTrack(@RequestBody Track track) {
        trackRepository.save(track);
        return ResponseEntity.ok("Track added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Track>> getTracks() {
        return ResponseEntity.ok(trackRepository.findAll());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Track>> getTracksByTitle(@PathVariable String title) {
        return ResponseEntity.ok(trackRepository.findByTitle(title));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTrack(@PathVariable Long id) {
        Optional<Track> track = trackRepository.findById(id);

        if (track.isPresent()) {
            return ResponseEntity.ok(track.get());
        } else {
            return ResponseEntity.status(404).body("Track not found");
        }
    }
}