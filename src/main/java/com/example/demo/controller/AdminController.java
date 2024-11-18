package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Hod;
import com.example.demo.pojo.SignUpHodApi;
import com.example.demo.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@PostMapping("/signup-hod")
	public ResponseEntity<?> addHod(@RequestPart("hod") String hodJson,
	                                @RequestPart("profileImage") MultipartFile profileImage) {
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        Hod hod = objectMapper.readValue(hodJson, Hod.class);

	        // Convert MultipartFile to byte array and set in Hod object
	        hod.setProfileImage(profileImage.getBytes());

	        // Save HOD using service logic
	        Hod newHod = service.addHod(hod);
	        return new ResponseEntity<>(newHod, HttpStatus.CREATED);
	    } catch (IOException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


    }


