package com.gl.Collegefest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="students")
@Data
public class Student {
    // define fields

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="student_id")
    private int id;


    @Column(name="first_name")
    private String fname;


    @Column(name="last_name")
    private String lname;


    @Column(name="course")
    private String course;
    
    @Column(name="country")
    private String country;

    public Student()
    {

    }

    public Student(String fname,String lname, String course, String country) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.course = course;
        this.country = country;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


}

