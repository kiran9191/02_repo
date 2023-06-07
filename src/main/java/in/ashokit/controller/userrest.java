package in.ashokit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.User;
@RestController
public class userrest {
	
	public Map<Integer, User> datamap = new HashMap<>();	
	@PostMapping("/rest")
   public ResponseEntity<String> fromcontroller(@RequestBody User user)
   {
	  
	   
	   datamap.put(user.getId(), user);
	   return new ResponseEntity<String>(user.getName() , HttpStatus.CREATED);
   }
	
	
	
	
	
	   @GetMapping("/rest")
	   public ResponseEntity<String> tocontroller(@RequestParam("id") Integer ID)
	   {
		  
		   System.out.println(datamap.get(ID));		   
		   return new ResponseEntity<String>("data fetched", HttpStatus.CREATED);
	   }
		@GetMapping("/rest/{id}/data")
	   public User tocontroller1(@PathVariable("id") Integer ID)
	   
	   {
		  
		  User user =datamap.get(ID);	
		  System.out.println(user);
		   return user;
	   }
		


	
	
	
	
	
	
}
