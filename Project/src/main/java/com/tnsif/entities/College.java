package com.tnsif.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "colleges")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "college_id", nullable = false)
    private int id;

    @Column(name = "college_name", nullable = false)
    private String collegeName;

    @Column(name = "location", nullable = false)
    private String location;

    @OneToMany(mappedBy = "college")
    @JsonManagedReference // Handles recursive serialization
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "college_admin_id", nullable = false)
    @JsonBackReference
    private User collegeAdmin;

	public College() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public User getCollegeAdmin() {
		return collegeAdmin;
	}

	public void setCollegeAdmin(User collegeAdmin) {
		this.collegeAdmin = collegeAdmin;
	}

	public College(int id, String collegeName, String location, List<Student> students, User collegeAdmin) {
		super();
		this.id = id;
		this.collegeName = collegeName;
		this.location = location;
		this.students = students;
		this.collegeAdmin = collegeAdmin;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", collegeName=" + collegeName + ", location=" + location + ", students="
				+ students + ", collegeAdmin=" + collegeAdmin + "]";
	}

    // Constructors, Getters, Setters, and toString()
    
}
