package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="abes_track")
public class Track {
	 @Id
	    @GeneratedValue
	    @Column(name = "track_id")
	    private Long id;

	    @Column(name = "track_title")
	    private String title;

	    @Column(name = "album_name")
	    private String albumName;

	    @Column(name = "release_dt")
	    private LocalDate releaseDate;

	
	    public Track() {}

	    public Track(String title, String albumName, LocalDate releaseDate) {
	        this.title = title;
	        this.albumName = albumName;
	        this.releaseDate = releaseDate;
	    }

	
	    public Long getId() {
	        return id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getAlbumName() {
	        return albumName;
	    }

	    public LocalDate getReleaseDate() {
	        return releaseDate;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public void setAlbumName(String albumName) {
	        this.albumName = albumName;
	    }

	    public void setReleaseDate(LocalDate releaseDate) {
	        this.releaseDate = releaseDate;
	    }
}
