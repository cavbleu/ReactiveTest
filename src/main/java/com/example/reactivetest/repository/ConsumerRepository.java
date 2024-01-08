package com.example.reactivetest.repository;

import com.example.reactivetest.entity.Consumer;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author cavbleu
 * @project ReactiveTest
 * @create 2024-01-08 14:23
 */
@Repository
public interface ConsumerRepository extends R2dbcRepository<Consumer, String> {


    Flux<Consumer> findByUsername(String username);
    Flux<Consumer> findByAge(int age);

}
