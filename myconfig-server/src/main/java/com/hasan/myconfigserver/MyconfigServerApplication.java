package com.hasan.myconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@AutoConfiguration
public class MyconfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyconfigServerApplication.class, args);
	}

}
