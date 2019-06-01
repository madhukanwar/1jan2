package com.example.RestTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		String url="http://localhost:8080/students/";

		RestTemplate rt =new RestTemplate();

		//System.out.println(rt.getForObject("https://api.github.com/users/ajendra91",String.class));

		//System.out.println(rt.getForObject("https://graph.facebook.com/ajendra",String.class));

		//System.out.println(rt.getForObject("http://localhost:8080/students", String.class));

		Dummy dummy =rt.getForObject(url+22, Dummy.class);
		System.out.println(dummy.toString());

	}

}
