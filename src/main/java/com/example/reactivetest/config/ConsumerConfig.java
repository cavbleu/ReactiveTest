package com.example.reactivetest.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

/**
 * @author cavbleu
 * @project ReactiveTest
 * @create 2024-01-08 17:12
 */
@Configuration
public class ConsumerConfig {

    @Bean
    @Primary
    public R2dbcConnectionDetails getR2dbcPostgresConnectionDetails() {
        return new R2dbcPostgresConnDetails();
    }

    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        initializer.setDatabaseCleaner(new ResourceDatabasePopulator(new ClassPathResource("clean.sql")));

        return initializer;
    }
}
