package com.tnsif.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", nullable = false)
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;

    @Column(name = "roll_number", nullable = false)
    private Long roll;

    @Column(name = "qualification", nullable = false)
    private String qualification;

    @Column(name = "course", nullable = false)
    private String course;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "hall_ticket_no", nullable = false)
    private Long hallTicketNo;

    @ManyToOne
    @JoinColumn(name = "college_id", nullable = false)
    @JsonBackReference // Avoids circular reference with College
    private College college;

    @ManyToOne
    @JoinColumn(name = "certificate_id")
    private Certificate certificate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonManagedReference // For proper serialization
    private Company company;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", roll=" + roll + ", qualification=" + qualification
				+ ", course=" + course + ", year=" + year + ", hallTicketNo=" + hallTicketNo + ", college=" + college
				+ ", certificate=" + certificate + ", company=" + company + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRoll() {
		return roll;
	}

	public void setRoll(Long roll) {
		this.roll = roll;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Long getHallTicketNo() {
		return hallTicketNo;
	}

	public void setHallTicketNo(Long hallTicketNo) {
		this.hallTicketNo = hallTicketNo;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Student() {
		super();
	}

	public Student(int id, String name, Long roll, String qualification, String course, int year, Long hallTicketNo,
			College college, Certificate certificate, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.roll = roll;
		this.qualification = qualification;
		this.course = course;
		this.year = year;
		this.hallTicketNo = hallTicketNo;
		this.college = college;
		this.certificate = certificate;
		this.company = company;
	}

    // Constructors, Getters, Setters, and toString()
    
}
