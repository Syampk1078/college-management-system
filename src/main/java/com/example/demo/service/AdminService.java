package com.example.demo.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Hod;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository repo;
	
	public Hod addHod(Hod hod) throws IOException {
		// TODO Auto-generated method stub
		Optional<Hod> hd = repo.findByEmail(hod.getEmail());
		if(hd.isEmpty()) {
	        //hod.setProfileImage(profileImage.getBytes());
			return repo.save(hod);
		}
		
		return null;
	}

}
