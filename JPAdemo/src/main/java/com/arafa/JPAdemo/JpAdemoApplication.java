package com.arafa.JPAdemo;

import com.arafa.JPAdemo.model.Student;
import com.arafa.JPAdemo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpAdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpAdemoApplication.class, args);
	}



/*
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args -> {
			Student maria = new Student("Maria","Lala","maria@gmail.com",20);
			studentRepository.save(maria);
		};
	}
*/

}
