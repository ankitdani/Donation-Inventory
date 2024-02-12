package com.example.inventory.v3;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@PWA(name = "Project Base for Vaadin with Spring", shortName = "Project Base")
@SpringBootApplication(scanBasePackages = "com.example.inventory.v3")
@EntityScan(basePackages = "com.example.inventory.v3")
@EnableJpaRepositories(basePackages = "com.example.inventory.v3")
public class InventoryV3Application implements AppShellConfigurator {

	public static void main(String[] args) {
		SpringApplication.run(InventoryV3Application.class, args);
	}
}
