package com.example.reactivetest.config;

import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcConnectionDetails;

/**
 * @author cavbleu
 * @project ReactiveTest
 * @create 2024-01-08 17:32
 */
public class R2dbcPostgresConnDetails implements R2dbcConnectionDetails {
    @Override
    public ConnectionFactoryOptions getConnectionFactoryOptions() {
        ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
                .option(ConnectionFactoryOptions.DRIVER, "postgresql")
                .option(ConnectionFactoryOptions.HOST, "localhost")
                .option(ConnectionFactoryOptions.PORT, 5432)
                .option(ConnectionFactoryOptions.USER, "postgres")
                .option(ConnectionFactoryOptions.PASSWORD, "1234")
                .option(ConnectionFactoryOptions.DATABASE, "postgres")
                .build();

        return options;
    }
}
