package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "hods")
public class Hod {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private int departmentId;
	    private String name;
	    private String email;
	    private String phone;
	    private String password;
	    @Lob
	    private byte[] profileImage;

	  
}
