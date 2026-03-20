package com.example.demo.repository;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Track;

public interface Trackrepository extends JpaRepository<Track, Long> {

    
    List<Track> findByTitle(String title);


	
}