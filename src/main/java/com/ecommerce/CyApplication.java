package com.ecommerce;

import com.ecommerce.helper.storage.StorageProperties;
import com.ecommerce.helper.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(StorageProperties.class)
@SpringBootApplication
public class CyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CyApplication.class, args);


	}


	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			//storageService.deleteAll();
			storageService.init();
		};
	}

}
