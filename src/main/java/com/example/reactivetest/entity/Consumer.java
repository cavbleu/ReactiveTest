package com.example.reactivetest.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * @author cavbleu
 * @project ReactiveTest
 * @create 2024-01-08 14:17
 */

@Data
//@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
//@RequiredArgsConstructor
public class Consumer {
    @Id
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public Consumer()
    {}

    public Consumer(String username, String firstname, String lastname, int age) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}
