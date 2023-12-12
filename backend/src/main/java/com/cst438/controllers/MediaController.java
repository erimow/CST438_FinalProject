package com.cst438.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cst438.domain.Media;
import com.cst438.domain.MediaRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/media")
public class MediaController {
	
	@Autowired
	MediaRepository mediaRepository;
	
	@GetMapping
	public Iterable<Media> getAllMedia() {
		return mediaRepository.findAll();
	}
	
	@PostMapping
	public Media createMedia(@RequestBody Media media) {
		return mediaRepository.save(media);
	}
	
	@GetMapping("/{id}")
    public Media getMediaById(@PathVariable int id) {
		return mediaRepository.findById(id)
	              .orElseThrow(() -> new IllegalArgumentException("Invalid media id: " + id));
	}

	@PutMapping("/{id}")
    public Media updateMedia(@PathVariable int id, @RequestBody Media updatedMedia) {
	    return mediaRepository.findById(id)
	                .map(media -> {
	                    media.setTitle(updatedMedia.getTitle());
	                    media.setType(updatedMedia.getType());
	                    media.setGenre(updatedMedia.getGenre());
	                    media.setRating(updatedMedia.getRating());
	                    media.setReview(updatedMedia.getReview());
	                    media.setPicURL(updatedMedia.getPicURL());
	                    return mediaRepository.save(media);
	                })
	                .orElseThrow(() -> new IllegalArgumentException("Invalid media id: " + id));
	}

	@DeleteMapping("/{id}")
	public void deleteMedia(@PathVariable int id) {
	        mediaRepository.deleteById(id);
	}
	
	

}
