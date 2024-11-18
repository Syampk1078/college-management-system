package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Hod;

public interface AdminRepository extends JpaRepository<Hod, Integer> {

	Optional<Hod> findByEmail(String email);

}
