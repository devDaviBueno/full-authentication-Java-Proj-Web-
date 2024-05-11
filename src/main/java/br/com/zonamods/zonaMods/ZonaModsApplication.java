package br.com.zonamods.zonaMods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "br.com.zonamods.zonaMods")
@SpringBootApplication()
public class ZonaModsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZonaModsApplication.class, args);
	}
}
