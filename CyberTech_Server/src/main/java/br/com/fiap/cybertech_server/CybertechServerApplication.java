package br.com.fiap.cybertech_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CybertechServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CybertechServerApplication.class, args);
	}

}
