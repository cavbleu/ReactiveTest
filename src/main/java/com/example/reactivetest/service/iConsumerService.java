package com.example.reactivetest.service;

import com.example.reactivetest.entity.Consumer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author cavbleu
 * @project ReactiveTest
 * @create 2024-01-08 17:53
 */
public interface iConsumerService {

    public Flux<Consumer> findAll();

    public Mono<Consumer> saveConsumer (Consumer consumer);

    public Flux<Consumer> findByAge (int age);
}
