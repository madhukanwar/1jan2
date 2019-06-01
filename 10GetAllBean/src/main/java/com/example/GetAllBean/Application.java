package com.example.GetAllBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		//SpringApplication.run(Application.class, args);

		ConfigurableApplicationContext configurableApplicationContext=SpringApplication.run(Application.class, args);
		String [] myAllBean= configurableApplicationContext.getBeanDefinitionNames();
		Arrays.sort(myAllBean);
		for(String s:myAllBean){
			System.out.println(s);
		}

	}

}
