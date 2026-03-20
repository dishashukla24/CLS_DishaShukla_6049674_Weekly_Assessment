package com.example.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.springboot.entities.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {    
	public List<Track> findByTitle(String title);
  
   
    
}