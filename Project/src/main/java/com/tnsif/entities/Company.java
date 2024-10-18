package com.tnsif.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id", nullable = false)
    private Integer id;

    @Column(name = "company_name", nullable = false)
    private String name;

    @Column(name = "salary", nullable = false)
    private Float salary;

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    private Set<Student> placedStudents = new HashSet<>();

	public Company(Integer id, String name, Float salary, Set<Student> placedStudents) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.placedStudents = placedStudents;
	}

	public Company() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Set<Student> getPlacedStudents() {
		return placedStudents;
	}

	public void setPlacedStudents(Set<Student> placedStudents) {
		this.placedStudents = placedStudents;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", salary=" + salary + ", placedStudents=" + placedStudents
				+ "]";
	}

    // Constructors, Getters, Setters, and toString()
    
	
}
