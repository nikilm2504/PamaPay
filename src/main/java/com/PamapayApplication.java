package com.pamapay;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.pamapay.config.JwtProperties;
@SpringBootApplication
@ConfigurationPropertiesScan
public class PamapayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PamapayApplication.class, args);
	}

}
