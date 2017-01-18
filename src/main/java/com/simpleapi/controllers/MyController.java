package com.simpleapi.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpleapi.model.Student;
import com.simpleapi.model.StudentDTO;
import com.simpleapi.model.StudentDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simpleapi.model.Fee;
import com.simpleapi.model.StudentFeeDao;

@Controller
public class MyController {
	
	@Autowired
	private StudentFeeDao studentFeeDao;
	
	@Autowired
	private StudentDao studentDao;
	
	
	@RequestMapping(value="/")
	public String fetchData(Model model) throws JsonProcessingException {
		List<StudentDTO> dtos =new ArrayList<>();
		List<Student> st = studentDao.getAll();
		for(Student student: st){
			StudentDTO dto =new StudentDTO();
			dto.setRollNo(student.getRollNo());
			dto.setName(student.getName());
			Map<String,Long> map =new HashMap<>();
			for(Fee fee: student.getFeemap()){
				
			map.put(fee.getMonth(), fee.getAmount());
			}

			dto.setFeemap(map);

			dtos.add(dto);
		}
		System.out.println(st);
		
		
		
//		studentDao.save(new Student(1,"A"));
//		studentDao.save(new Student(2, "B"));
		
//		studentFeeDao.save(new Fee(1, 1000, "JAN", 1));
//		studentFeeDao.save(new Fee(2, 1000, "FEB", 1));
//		studentFeeDao.save(new Fee(3, 1000, "JAN", 2));
//		studentFeeDao.save(new Fee(4, 1000, "FEB", 2));
		model.addAttribute("JSON", new ObjectMapper().writeValueAsString(dtos));
		return "index";
//		return  new ResponseEntity<List<StudentDTO>>(dtos, HttpStatus.OK);
		
	}
}
