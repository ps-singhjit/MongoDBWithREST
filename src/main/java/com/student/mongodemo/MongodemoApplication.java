package com.student.mongodemo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class MongodemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
		return args -> {
			Address address = new Address(
					"Canada",
					"Ontario",
					"M5Y T3P");
			String email = "email@gmail.com";
			Student student = new Student(
					"Paramjit",
					"Singh",
					email,
					Gender.MALE,
					address,
					List.of("Computer Science", "Programming", "Java"),
					BigDecimal.TEN);
			// LocalDateTime.now());
			// usingMongoTemplateAndQuery(repository, mongoTemplate, email, student);
			repository.findByEmail(email)
					.ifPresentOrElse(s -> {
						System.out.println(student.toString() + " :: is already present");
					}, () -> {
						System.out.println("Inserting student :: " + student.toString());
						repository.insert(student);
					});
		};
	}

	private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email,
			Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List<Student> students = mongoTemplate.find(query, Student.class);

		if (students.size() > 0) {
			throw new IllegalStateException("Found many students with same email :: " +
					email);
		}
		if (students.isEmpty()) {
			System.out.println("Inserting student :: " + student.toString());
			repository.insert(student);
		} else {
			System.out.println(student.toString() + " :: is already present");
		}
	}

}
