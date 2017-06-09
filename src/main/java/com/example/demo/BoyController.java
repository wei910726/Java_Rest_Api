package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoyController {
	
	@Autowired
	private BoyRepository boyRepository;
	
	@Autowired
	private BoyService BoyService;
	
//    get接口，获取男生列表
	@GetMapping(value="/boys")
	public List<boy> boylist(){
		return boyRepository.findAll();
	}
//	post接口，新增一位男生
	@PostMapping(value="/boys")
	public boy boyAdd(@RequestParam("age") Integer age,
    @RequestParam("name") String name){
		boy boy = new boy();
		boy.setAge(age);
		boy.setName(name);
	    return boyRepository.save(boy);
	}
	
//  get接口，通过id查询男生
	@GetMapping(value="/boys/{id}")
	public boy boySearch(@PathVariable("id") Integer id){
		return boyRepository.findOne(id);
	}
	
//  put接口，通过id更新男生信息
	@PutMapping(value="/boys/{id}")
	public boy boyUpdate(@PathVariable("id") Integer id,@RequestParam("age") Integer age,
		    @RequestParam("name") String name){
		boy boy = new boy();
		boy.setId(id);
		boy.setAge(age);
		boy.setName(name);
		return boyRepository.save(boy);
	}
	
//  delete接口，通过id删除一位男生
	@DeleteMapping(value="/boys/{id}")
	public void boyDelete(@PathVariable("id") Integer id){
		boyRepository.delete(id);
	}
//  post接口，同时插入两个男生	
	@PostMapping(value="/boys/two")
	public void twoAdd(){
	   BoyService.insertTwo();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
