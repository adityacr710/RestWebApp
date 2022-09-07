package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@RestController
public class StudentControl {
	
	@Autowired
	StudentRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	/*
	@RequestMapping("addStud")
	public String Add(Student s)
	{
		repo.save(s);
		return "home.jsp";
	}*/
	/*@RequestMapping("getStud")
	public ModelAndView Get(@RequestParam int sid)
	{
		ModelAndView mv = new ModelAndView("showStud.jsp");
		Student s = repo.findById(sid).orElse(new Student()) ;
		mv.addObject(s);
		return mv;
		
	}*/
	@GetMapping(path="/students",produces= {"application/json"})
	public List<Student> Get()
	{
		return repo.findAll();
	}

	@GetMapping("/students/{sid}")
	public  Optional<Student> Get(@PathVariable("sid") int sid)
	{
		return repo.findById(sid);
	}

	@PostMapping(path="addStud",consumes= {"application/json"})
	
	public Student Add(@RequestBody Student s)
	{
		repo.save(s);
		return s;
	}
	@DeleteMapping("/students/{sid}")
	public String Del(@PathVariable int sid)
	{
		Student s3 = repo.getOne(sid);
		repo.delete(s3);
		
		
		return "deleted";
	}
	
	@PutMapping(path="/students",consumes= {"application/json"})
	
	public Student Update(@RequestBody Student s)
	{
		repo.save(s);
		return s;
	}

	
}
