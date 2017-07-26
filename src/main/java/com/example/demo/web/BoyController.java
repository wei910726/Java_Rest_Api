package com.example.demo.web;

import java.util.List;

import com.example.demo.domain.BoyRepository;
import com.example.demo.domain.boy;
import com.example.demo.error.MyException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class BoyController {
	
	@Autowired
	private BoyRepository boyRepository;
	
	@Autowired
	private com.example.demo.domain.BoyService BoyService;

	@ApiOperation(value="获取男生列表")
	@GetMapping(value="/boys")
	public List<boy> boylist(){
		return boyRepository.findAll();
	}

    @ApiOperation(value="新增一位男生")
	@ApiImplicitParams(
			{@ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String"),
			 @ApiImplicitParam(name="age",value="年龄",required = true,dataType = "int")}
	)
	@PostMapping(value="/boys")
	public boy boyAdd(@RequestParam("age") Integer age,
    @RequestParam("name") String name){
		boy boy = new boy();
		boy.setAge(age);
		boy.setName(name);
	    return boyRepository.save(boy);
	}

	@ApiOperation(value="根据ID查找男生")
	@ApiImplicitParam()
	@GetMapping(value="/boys/{id}")
	public boy boySearch(@PathVariable("id") Integer id){
		return boyRepository.findOne(id);
	}

	@ApiOperation(value="根据ID更新男生信息")
	@ApiImplicitParams(
			{@ApiImplicitParam(name="id",value = "学号",required = true,dataType = "int"),
			 @ApiImplicitParam(name="name",value = "姓名",required = true,dataType = "String"),
			 @ApiImplicitParam(name="age",value = "年龄",required = true,dataType = "int")
			}
	)
	@PutMapping(value="/boys/{id}")
	public boy boyUpdate(@PathVariable("id") Integer id,@RequestParam("age") Integer age,
		    @RequestParam("name") String name){
		boy boy = new boy();
		boy.setId(id);
		boy.setAge(age);
		boy.setName(name);
		return boyRepository.save(boy);
	}

	@ApiOperation(value="根据ID删除男生")
	@ApiImplicitParam(name="id",value="学号",required=true,dataType="int")
	@DeleteMapping(value="/boys/{id}")
	public void boyDelete(@PathVariable("id") Integer id){
		boyRepository.delete(id);
	}

	@PostMapping(value="/boys/two")
	public void twoAdd(){
	   BoyService.insertTwo();
	}

	@GetMapping(value="/json")
	public String json() throws MyException {
		throw new MyException("出现错误");
	}
  }

