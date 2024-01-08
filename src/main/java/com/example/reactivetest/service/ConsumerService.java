package com.example.reactivetest.service;

import com.example.reactivetest.entity.Consumer;
import com.example.reactivetest.repository.ConsumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cavbleu
 * @project ReactiveTest
 * @create 2024-01-08 14:28
 */
@Service
@RequiredArgsConstructor
public class ConsumerService implements iConsumerService{

    @Autowired
    ConsumerRepository consRepo;

    @Override
    public Flux<Consumer> findAll()
    {
        return consRepo.findAll();
    }

    @Override
    public Mono<Consumer> saveConsumer (Consumer consumer)
    {
        return Mono.just(consumer).flatMap(consRepo :: save);
    }

    @Override
    public Flux<Consumer> findByAge (int age)
    {
        return consRepo.findByAge(age);
    }
}
