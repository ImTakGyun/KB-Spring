package com.example.demo;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component("GalaxyWatch")
public class GalaxyWatch implements Watch{

    @Override
    public String getDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일"));
    }

    @Override
    public String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getDateTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm:ss"));
    }
}
