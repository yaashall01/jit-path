package com.jobintech.jitpath;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.jobintech.jitpath.controller", "com.jobintech.jitpath.service", "com.jobintech.jitpath.mapper", "com.jobintech.jitpath.exception"})
@EntityScan("com.jobintech.jitpath.model")
@EnableJpaRepositories("com.jobintech.jitpath.repository")
public class JitpathApplication {



	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();

		SpringApplication.run(JitpathApplication.class, args);
	}




}
