package com.mjvschool.calculadorapoo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class User {

    private String name;
    private String profession;
    private int age;
    private String password = "MJVSchool2024";

    public User() {
    }

    public User(String name, String profession, int age) {
        this.name = name;
        this.profession = profession;
        this.age = age;
    }

}
