package org.world.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@EnableJpaRepositories(basePackages = "org.world.repository")
@EntityScan(basePackages = "org.world.model")
@ImportResource("classpath:spring-config.xml")
@SpringBootApplication
@Import(CustomizedRestMvcConfiguration.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
@Configuration
class CustomizedRestMvcConfiguration extends RepositoryRestMvcConfiguration {

 @Override
 public RepositoryRestConfiguration config() {
   RepositoryRestConfiguration config = super.config();
   config.setBaseUri("/api/rest");
   return config;
 }
}