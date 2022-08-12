package com.example.demo.example;

import java.util.List;
import java.util.stream.Collectors;

public class Example2 {

    public static List<String> findNamesOfPeopleOlderThan25(List<Person> people) {
        return people.stream()
                .filter(p -> p.getAge() > 25)
                .map(Person::getName)
                .collect(Collectors.toList());
    }
}
