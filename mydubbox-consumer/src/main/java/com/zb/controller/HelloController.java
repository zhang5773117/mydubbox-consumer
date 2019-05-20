package com.zb.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zb.service.HelloService;

@Controller
public class HelloController {

	@Autowired
	private HelloService helloService;

	@RequestMapping(value = "/show")
	@ResponseBody
	public String show(String name) {
		System.out.println("使用服务");
		return helloService.sayHello(name);
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public String test(){
		return "test docker";
	}


	@RequestMapping(value = "/hello2")
	@ResponseBody
	public String hello2(){
		return "hello2";
	}


}
