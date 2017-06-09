package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoyService {
	@Autowired
	private BoyRepository boyRepository;
	@Transactional
	public void insertTwo(){
		boy b1 = new boy();
		b1.setAge(15);
		b1.setName("蛤");
		boyRepository.save(b1);
		
		boy b2 = new boy();
		b2.setAge(17);
		b2.setName("呵呵呵呵呵呵呵呵呵呵");
		boyRepository.save(b2);
	}

}
