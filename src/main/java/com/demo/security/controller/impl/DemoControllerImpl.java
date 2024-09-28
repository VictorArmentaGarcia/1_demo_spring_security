package com.demo.security.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.security.controller.DemoController;

@RestController
public class DemoControllerImpl implements DemoController {

	@Override
	@GetMapping("/home")
	public String showHome() {
		// TODO Auto-generated method stub
		return "hello world";
	}

}
