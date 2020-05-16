package com.example.demo.dyh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {
	@RequestMapping("/getName")
	public String getName() {
		return "sfwe";
	}
}
