package com.tnsif.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String type;

    private String password;

    @OneToMany(mappedBy = "collegeAdmin")
    @JsonIgnore // Avoids serialization issues
    private List<College> colleges;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", type=" + type + ", password=" + password + ", colleges="
				+ colleges + "]";
	}

	public User(Long id, String name, String type, String password, List<College> colleges) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.password = password;
		this.colleges = colleges;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<College> getColleges() {
		return colleges;
	}

	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}
    

    // Constructors, Getters, Setters, and toString()
}
