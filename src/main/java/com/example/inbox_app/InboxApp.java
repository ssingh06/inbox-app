package com.example.inbox_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@SpringBootApplication
@RestController
public class InboxApp {

	public static void main(String[] args) {
		SpringApplication.run(InboxApp.class, args);
	}

	/**
	 * This method is needed to return the path to the zip file contining the Java bundle needed
	 * to connect to the hosted Astra DB instance.
	 * @param properties "astra.db" properties injected from {@link DataStaxAstraProperties}
	 * @return patch to Java connect bundle for Astra DB.
	 */
	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties properties) {
		final Path bundle = properties.getSecureConnectBundle().toPath();
		return cqlSessionBuilder -> cqlSessionBuilder.withCloudSecureConnectBundle(bundle);
	}

}
