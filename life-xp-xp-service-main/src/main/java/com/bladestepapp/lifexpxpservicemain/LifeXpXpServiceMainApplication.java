package com.bladestepapp.lifexpxpservicemain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication(scanBasePackages = {"com.bladestepapp.lifexpxpservicemain","com.bladestepapp.lifexpxpserrviceapi",
        "com.bladestepapp.lifexpxpserviceapplication","com.bladestepapp.lifexpxpserviceinfrastructure"})
@EnableCassandraRepositories(basePackages = "com.bladestepapp.lifexpxpserviceinfrastructure.persistence")
@EntityScan(basePackages = "com.bladestepapp.lifexpxpserviceinfrastructure.entities")
@EnableFeignClients(basePackages = "com.bladestepapp.lifexpxpserviceinfrastructure")
public class LifeXpXpServiceMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeXpXpServiceMainApplication.class, args);
    }
}

