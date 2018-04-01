package com.cin.sushi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("backdoor")
public class Backdoor {
	
	@GetMapping(path="/ping")
	public String test() {
		return "Qing is great.";
	}
	
	@GetMapping(path="/version")
	public String getVersion() {
		return "1.0";
	}

}
