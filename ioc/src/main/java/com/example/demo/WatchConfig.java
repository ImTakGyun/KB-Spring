package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class WatchConfig {

    @Bean
    public Watch getRedmiWatch() {
        return new Watch() {
            @Override
            public String getDate(){
                return "Time from Redmi -> " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }

            @Override
            public String getTime(){
                return "Time from Redmi -> " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            }

            @Override
            public String getDateTime(){
                return "Time from Redmi -> " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm:ss"));
            }
        };
    }
}
