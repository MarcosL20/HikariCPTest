package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @Autowired
    private TestService testService;
    
    @GetMapping("/method1")
    public void method1() throws InterruptedException {
        testService.method1();
        System.out.println("METHOD 1 FINISHED");
    }
    
    @GetMapping("/method2")
    public void method2() throws InterruptedException {
        testService.method2();
        System.out.println("METHOD 2 FINISHED");
    }
    
    @GetMapping("/method3")
    public void method3() throws InterruptedException {
        testService.method3();
        System.out.println("METHOD 3 FINISHED");
    }
    
    @GetMapping("/method4")
    public void method4() throws InterruptedException {
        testService.method4();
        System.out.println("METHOD 4 FINISHED");
    }
   
}
