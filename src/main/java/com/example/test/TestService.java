package com.example.test;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
  
    @Autowired
    TestRepository testRepository;
    @Autowired
    TestDAO testDAO;
    
    public void method1() throws InterruptedException {
        
        List<Test> entities = testRepository.findAll();
        System.out.println("FINDALL");
        
        Thread.sleep(20000);
        
        int i = 0;
        for (Test entity : entities) {
            i++;
            entity.setValue("ValueRep" + Integer.toString(i));
        }
        
        testRepository.saveAll(entities);
        System.out.println("SAVE REP");
        
    }
    
    public void method2() throws InterruptedException {
        
        List<Test> entities = testRepository.findAll();
        System.out.println("FINDALL");
        
        Thread.sleep(20000);
        
        int i = 0;
        for (Test entity : entities) {
            i++;
            entity.setId("DAO" + Integer.toString(i));
            entity.setValue("ValueDAO" + Integer.toString(i));
        }
        
        testDAO.saveAllDAO(entities);
        System.out.println("SAVE DAO");
        
    }
    
    public void method3() throws InterruptedException {
        
        List<Test> entities = testRepository.findAll();
        System.out.println("FINDALL 1");
        
        Thread.sleep(20000);
        
        List<Test> entities2 = testRepository.findAll();
        System.out.println("FINDALL 2");
        
    }
    
    public void method4() throws InterruptedException {
        
        List<Test> entities = testRepository.findAll();
        
        int i = 0;
        for (Test entity : entities) {
            i++;
            entity.setValue("METHOD4ValueRep" + Integer.toString(i));
        }
        
        testRepository.saveAll(entities);
        System.out.println("SAVE REP METHOD4");
        
        Thread.sleep(20000);
        
        List<Test> entities2 = testRepository.findAll();
        System.out.println("FINDALL 2");
        
    }
    
}
