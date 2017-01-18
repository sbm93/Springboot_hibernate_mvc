package com.simpleapi.model;

import java.util.HashMap;
import java.util.Map;

public class StudentDTO {

	private long rollNo;
	private String name;
	private Map<String,Long> feemap = new HashMap<>();
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
	public Map<String, Long> getFeemap() {
		return feemap;
	}
	public void setFeemap(Map<String, Long> feemap) {
		this.feemap = feemap;
	}
	
	
	
	
}
