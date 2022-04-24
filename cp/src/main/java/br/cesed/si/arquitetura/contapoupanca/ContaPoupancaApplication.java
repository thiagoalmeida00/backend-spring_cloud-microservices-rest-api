package br.cesed.si.arquitetura.contapoupanca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
public class ContaPoupancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContaPoupancaApplication.class, args);
	}

}
