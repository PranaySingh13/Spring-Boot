package com.gk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication = @Component + @ComponentScan + @EnableAutoConfiguration
 */
@SpringBootApplication
public class Test {

	public static void main(String[] args) {

		SpringApplication.run(Test.class, args);
		System.out.println("*Testing Spring Application*");
	}

}
