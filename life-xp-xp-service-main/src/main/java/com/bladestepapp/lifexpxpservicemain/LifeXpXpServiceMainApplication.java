package com.bladestepapp.lifexpxpservicemain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = {"com.bladestepapp.lifexpxpservicemain","com.bladestepapp.lifexpxpserrviceapi",
        "com.bladestepapp.lifexpxpserviceapplication","com.bladestepapp.lifexpxpserviceinfrastructure"})
@EnableCassandraRepositories(basePackages = "com.bladestepapp.lifexpxpserviceinfrastructure.repositories")
@EntityScan(basePackages = "com.bladestepapp.lifexpxpserviceinfrastructure.entities")
@EnableFeignClients(basePackages = "com.bladestepapp.api")
public class LifeXpXpServiceMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeXpXpServiceMainApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Loaded beans:");
            Arrays.stream(ctx.getBeanDefinitionNames()).sorted().forEach(System.out::println);
        };
    }
}

