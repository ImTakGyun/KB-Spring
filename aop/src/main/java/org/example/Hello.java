package org.example;

import org.springframework.stereotype.Component;

@Component
public class Hello {

    @PrintExecutionTIme
    public String getHello() {
        try{
            Thread.sleep((int)(Math.random() * 1000));
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        return "Hello Spring Boot";
    }
}
