package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DoctorStrangeaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorStrangeaApiApplication.class, args);
	}
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.app"))
				.build()
				.apiInfo(ApiDetails());
	}
	public ApiInfo ApiDetails() {
		return new ApiInfoBuilder()
				.title("Doctor Strange API")
				.contact(new Contact("Ángel Pérez","no-url","aperezd22@miumg.edu.gt"))
				.description("Documentación Doctor Strange API")
				.build();
	}
}