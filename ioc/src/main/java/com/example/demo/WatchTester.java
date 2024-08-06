package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WatchTester {

    //@Qualifier("AppleWatch")
    //@Autowired(required = false) //의존성 주입이 안되어도 오류를 도출하지 않도록 설정
    @Autowired
    private List<Watch> watch;

//    public WatchTester(Watch watch){
//        this.watch = watch;
//    }

//    public void setWatch(Watch watch){
//        this.watch = watch;
//    }

//    public Watch getWatch(){
//        return this.watch;
//    }

    @PostConstruct // 의존성 주입이 완료된 이후에 사용이 가능하도록 하는 어노테이션
    public void run() {

        for(Watch watch : watch) {
            System.out.println("getDate() : " + watch.getDate());
            System.out.println("getTime() : " + watch.getTime());
            System.out.println("getDateTime() : " + watch.getDateTime());
        }
    }

    public String toString(){
        return "WatchTester{" + "watch=" + watch + '}';
    }
}
