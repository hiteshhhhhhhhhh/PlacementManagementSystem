package com.tnsif.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "certificate_id", nullable = false)
    private Integer id;

    @Column(name = "certification_year", nullable = false)
    private int year;

    @ManyToOne
    @JoinColumn(name = "college_id", nullable = false)
    private College college;

	public Certificate() {
		super();
	}

	public Certificate(Integer id, int year, College college) {
		super();
		this.id = id;
		this.year = year;
		this.college = college;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Certificate [id=" + id + ", year=" + year + ", college=" + college + "]";
	}
    

    // Constructors, Getters, Setters, and toString()
}
