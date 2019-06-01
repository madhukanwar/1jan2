package com.example.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application implements CommandLineRunner {

	//@Autowired
	//public AppController appController;

	/*public AppController appController;
	public Application(AppController appController){
		this.appController=appController;
	}*/

	public AppController appController=new AppController();


	public static void main(String[] args) {

		//SpringApplication.run(Application.class, args);

		/*ApplicationContext applicationContext =SpringApplication.run(Application.class,args);
		AppController appController=(AppController)applicationContext.getBean(AppController.class);
		appController.index();*/

		ConfigurableApplicationContext configurableApplicationContext =SpringApplication.run(Application.class,args);
		AppController appController2=(AppController)configurableApplicationContext.getBean(AppController.class);
		appController2.index();

	}

	@Override
	public void run(String... args) throws Exception {
		//appController.index();
	}

	@Bean
	public CommandLineRunner cmd(){
		return args -> {
			//appController.index();
		};
	}
}
