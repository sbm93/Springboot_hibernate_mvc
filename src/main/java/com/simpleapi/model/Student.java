package com.simpleapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="roll_no")
	private long rollNo;
	
	@Column(name="name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
	private List<Fee> feemap;
	
	public Student() { }
	
	public Student(long rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}
	
	public Student(long rollNo, String name, List<Fee> feemap) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.feemap = feemap;
	}

	public List<Fee> getFeemap() {
		return feemap;
	}

	public void setFeemap(List<Fee> feemap) {
		this.feemap = feemap;
	}

	public long getRollNo() {
		return rollNo;
	}

	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", feemap=" + feemap + "]";
	}
	
}
