package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoyRepository extends JpaRepository<boy,Integer>{
	
	//通过年龄查询
	public List<boy> findByAge(Integer age);
	
	//通过姓名查询
	public List<boy> findByName(String name);

}
