package com.Techforge.SheildSpring.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Techforge.SheildSpring.Exception.OriginException;

@RestController
public class UserController {
	
	@GetMapping("/getdata")
	public ResponseEntity<String> getdatat(){
		System.out.println("reached api");
		return new ResponseEntity<String>("Succesfulll", HttpStatus.OK);
	}

}
