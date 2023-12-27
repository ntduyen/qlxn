package com.qlxn.standardtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StandardtestApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(StandardtestApplication.class, args);
	}

}
