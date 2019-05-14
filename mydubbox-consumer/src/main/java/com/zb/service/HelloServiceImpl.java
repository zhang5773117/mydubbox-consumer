package com.zb.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Reference(version = "1.0.0")
    private HelloService helloService;

    @HystrixCommand(fallbackMethod = "errorMethod")
    public String sayHello(String name) {
        return helloService.sayHello(name);
    }

    public String errorMethod(String name) {
        return "方法异常了";
    }
}
