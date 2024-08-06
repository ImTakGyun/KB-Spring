package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class IocApplication {

	public static void main(String[] args) {

		//ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
		SpringApplication.run(IocApplication.class, args);
	}

}
