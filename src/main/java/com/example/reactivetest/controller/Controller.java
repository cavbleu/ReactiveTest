package com.example.reactivetest.controller;

import com.example.reactivetest.entity.Consumer;
import com.example.reactivetest.repository.ConsumerRepository;
import com.example.reactivetest.service.ConsumerService;
import com.example.reactivetest.service.iConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.*;

/**
 * @author cavbleu
 * @project ReactiveTest
 * @create 2024-01-08 14:15
 */
@RestController
@RequestMapping(path = "api/v1/test",
                produces = "application/json")
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    private iConsumerService consumerService;
    private ConsumerRepository consRepo;

    @GetMapping("/viewAll")
    @ResponseStatus(OK)
    public Flux<Consumer> viewConsumer ()
    {
        return consumerService.findAll();
    }

    @GetMapping("/{age}")
    @ResponseStatus(OK)
    public Flux<Consumer> findByAge (@PathVariable("age") int age)
    {
        return consumerService.findByAge(age);
    }

//    @PostMapping("/saveCons")
    @RequestMapping(value = "/saveCons", method = RequestMethod.POST)
    @ResponseStatus(CREATED)
    public Mono<Consumer> createConsumer (@RequestBody Consumer consumer)
    {
        return consumerService.saveConsumer(consumer);
    }
}
