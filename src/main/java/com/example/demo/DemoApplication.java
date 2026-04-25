package com.example.demo;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(TaskRepository repository) {
		return args -> {
			//Create a new Task
			Task task = new Task();
			task.setTitle("Finish Spring Boot setup");
			task.setCompleted(false);

			//Save it to the database
			repository.save(task);

			//Print confirmation
			System.out.println("Task saved: " + task.getTitle());
		};
	}

}
