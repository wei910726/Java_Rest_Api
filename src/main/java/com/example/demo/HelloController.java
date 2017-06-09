package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {	
/*  @Value("${boy.height}")
	private Integer height;
    @Value("${boy.weight}")
    private Integer weight;*/
	
	@Autowired
	private BoyProperty BoyProperty;
    
    @RequestMapping(value="/hello",method=RequestMethod.GET)
	public String sayHello(){
		return "Hello world"; 
	}
    @RequestMapping(value="/height",method=RequestMethod.GET)
    public String BoyHeight(){
    	return "height: " + BoyProperty.getHeight();
    }
    @GetMapping(value="/welcome/{name}")
    public String getName(@PathVariable("name") String name){
    	return "name: " + name;
    }
    @GetMapping(value="/hi")
    public String getId(@RequestParam(value="id",required = false,defaultValue = "0") Integer id){
    	return "id: " + id;
    }
    
}
