package com.excelupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExcelUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelUploadApplication.class, args);
	}

}
