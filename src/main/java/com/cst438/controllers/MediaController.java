package com.cst438.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
//	private final MediaRepository mediaRepository;
	
//	@Autowired
//	public MediaController(MediaRepository mediaRepository){
//		this.mediaRepository = mediaRepository;
//	}
	
	@GetMapping
	public Iterable<Media> getAllMedia() {
		return mediaRepository.findAll();
	}
	
	@PostMapping
	public Media createMedia(@RequestBody Media media) {
		return mediaRepository.save(media);
	}
	
	

}
