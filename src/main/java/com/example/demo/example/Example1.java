package com.example.demo.example;

import java.util.List;
import java.util.stream.Collectors;

public class Example1 {

    public static List<Person> findPeopleOlderThan30(List<Person> people) {
        return people.stream()
                .filter(p -> p.getAge() > 30)
                .collect(Collectors.toList());
    }
}