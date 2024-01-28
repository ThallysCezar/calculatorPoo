package com.mjvschool.calculadorapoo;

import com.mjvschool.calculadorapoo.models.User;
import com.mjvschool.calculadorapoo.utils.Initialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculadorapooApplication implements CommandLineRunner {

	@Autowired
	private User user;

	@Autowired
	private Initialization initialization;
	

	public static void main(String[] args) {
		SpringApplication.run(CalculadorapooApplication.class, args);

	}

	@Override
	public void run(String... args) {
		initialization.getUserInformation(user);
		initialization.startProgram();
	}

}
