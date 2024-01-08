package com.example.reactivetest;

import com.example.reactivetest.entity.Consumer;
import com.example.reactivetest.repository.ConsumerRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@EnableWebFlux
@SpringBootApplication
public class ReactiveTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveTestApplication.class, args);
    }

}
