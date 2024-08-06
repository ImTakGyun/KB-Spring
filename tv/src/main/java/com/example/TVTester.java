package com.example;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TVTester {

    //@Qualifier("SamsungTV")
    @Autowired
    private List<TV> tv;

    @PostConstruct
    public void run(){

        for(TV tv : tv) {
            System.out.println(tv.powerOn());
            System.out.println(tv);
            System.out.println(tv.volumeUp());
            System.out.println(tv.toString());
            System.out.println(tv.volumeDown());
            System.out.println(tv);
            System.out.println(tv.powerOff());
            System.out.println(tv.toString());
        }
    }
}
