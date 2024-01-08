package com.example.reactivetest;

import com.example.reactivetest.entity.Consumer;
import com.example.reactivetest.repository.ConsumerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * @author cavbleu
 * @project ReactiveTest
 * @create 2024-01-08 17:09
 */
@Component
public class CommandLineStartupR implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ReactiveTestApplication.class);

    @Override
    public void run(String...args) throws Exception{
        logger.info("Start app!");
    }

    @Bean
    public CommandLineRunner reactiveDatabaseExample(ConsumerRepository consumerRepository) {
        return args -> {
            List<Consumer> consumers = Arrays.asList(
                    new Consumer("User1", "F1", "L1", 14),
                    new Consumer("User2", "F2", "L2", 15),
                    new Consumer("User3", "F3", "L3", 17),
                    new Consumer("User4", "F4", "L4", 20),
                    new Consumer("User5", "F5", "L5", 22),
                    new Consumer("User6", "F6", "L6", 27)
            );

            consumerRepository.saveAll(consumers).blockLast(Duration.ofSeconds(5));

            consumerRepository.findByAge(20).doOnNext(consumer -> {
                        logger.info(consumer.toString());
                    })
                    .blockLast(Duration.ofSeconds(10));

            Mono<List<Consumer>> consListMono = consumerRepository.findAll().collectList();
            List<Consumer> consumerList = consListMono.block(Duration.ofSeconds(15));

            for (Consumer c : consumerList) {
                logger.info(c.toString());
            }
        };
    }
}
