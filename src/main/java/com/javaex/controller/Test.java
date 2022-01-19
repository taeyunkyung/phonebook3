package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/board")
public class Test {

	// 필드
	// 생성자
	// 메소드 g/s

	// 메소드 일반
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String TestPrint() {
		System.out.println("TestPrint1");

		return "Test";
	}

	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String TestPrint2(@RequestParam(value = "name") String name,
			@RequestParam(value = "age", required = false, defaultValue = "-1") int age) {
		System.out.println("TestPrint2");

		System.out.println(name);
		System.out.println(age);

		return "Test";
	}

	@RequestMapping(value = "/writeForm/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String TestPrint3(@PathVariable("no") int no) {
		System.out.println("TestPrint3");

		System.out.println(no + "번 글 가져오기");

		return "Test";
	}
}
