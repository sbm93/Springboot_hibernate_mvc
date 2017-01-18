package com.simpleapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "fee")
public class Fee {
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="amount")
	private long amount;
	
	@Column(name="month")
	private String month;
	
    /*@Column(name="roll_no")
	private long rollNo;*/


    @ManyToOne
    @JoinColumn(name = "roll_no")
	private Student student;
	
	public Fee() { }

	public Fee(long id, long amount, String month) {
		super();
		this.id = id;
		this.amount = amount;
		this.month = month;
	}
	
	
	public Fee(long id, long amount, String month, Student student) {
		super();
		this.id = id;
		this.amount = amount;
		this.month = month;
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "StudentFee [id=" + id + ", amount=" + amount + ", month=" + month + "]";
	}
	
	
}
