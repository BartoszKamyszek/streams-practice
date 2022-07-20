package com.example.demo.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleTest {

    @Test
    public void EXAMPLE1_shouldReturnPeopleOlderThan30() {
        //given
        var people = createPersonList();
        //when
        var actual = Example1.findPeopleOlderThan30(people);
        //then
        assertThat(actual).containsExactly(createPerson("Grzegorz", 35, Gender.OTHER));
    }

    @Test
    public void EXAMPLE2_shouldReturnNames() {
        //given
        var people = createPersonList();
        //when
        var actual = Example2.findNamesOfPeopleOlderThan25(people);
        //then
        assertThat(actual).containsExactly("Bartek", "Grzegorz");
    }

    @Test
    public void EXAMPLE3_shouldReturnYoungestPerson() {
        //given
        var people = createPersonList();
        //when
        var actual = Example3.findYoungestPerson(people);
        //then
        assertThat(actual).isEqualTo(createPerson("Ania", 20, Gender.FEMALE));
    }

    @Test
    public void EXAMPLE3_shouldReturnYoungestPersonName() {
        //given
        var people = createPersonList();
        //when
        var actual = Example3.findYoungestPersonName(people);
        //then
        assertThat(actual).isEqualTo("Ania");
    }

    @Test
    public void EXAMPLE4_shouldReturnTwoYoungestPeople() {
        //given
        var people = createPersonList();
        //when
        var actual = Example4.findTwoYoungestPeopleInList(people);
        //then
        assertThat(actual).containsExactly(createPerson("Ania", 20, Gender.FEMALE), createPerson("Bartek", 26, Gender.MALE));
    }

    @Test
    public void EXAMPLE5_shouldReturnPeopleBelow30ByGender() {
        //given
        var people = createPersonList();
        //when
        var actual = Example5.findPeopleBelow30ByGender(people);
        //then
        assertThat(actual).containsEntry(Gender.FEMALE, List.of(createPerson("Ania", 20, Gender.FEMALE)));
        assertThat(actual).containsEntry(Gender.MALE, List.of(createPerson("Bartek", 26, Gender.MALE)));
    }

    @Test
    public void EXAMPLE6_shouldReturnTrueIfContainsPersonUnder25() {
        //given
        var people = createPersonList();
        //when
        var actual = Example6.containsPersonUnder25(people);
        //then
        assertThat(actual).isTrue();
    }

    @Test
    public void EXAMPLE7_shouldReturn5NearestWorkingDays() {
        //given
        //when
        var actual = Example7.findWorkingDays(5L);
        //then
        assertThat(actual).containsExactly(LocalDate.of(2022, 7, 20),
                LocalDate.of(2022, 7, 21),
                LocalDate.of(2022, 7, 25),
                LocalDate.of(2022, 7, 26),
                LocalDate.of(2022, 7, 27));
    }

    @Test
    public void EXAMPLE8_shouldAddTwoYoungestPeopleFromSecondListToFirstList() {
        //given
        var firstList = createPersonList();
        var secondList = createPersonList();
        //when
        var actual = Example8.addTwoYoungestPeopleFromSecondListToFirstList(firstList, secondList);
        //then
        assertThat(actual).containsExactly(
                createPerson("Ania", 20, Gender.FEMALE),
                createPerson("Bartek", 26, Gender.MALE),
                createPerson("Grzegorz", 35, Gender.OTHER),
                createPerson("Ania", 20, Gender.FEMALE),
                createPerson("Bartek", 26, Gender.MALE));
    }

    private List<Person> createPersonList() {
        return List.of(
                createPerson("Ania", 20, Gender.FEMALE),
                createPerson("Bartek", 26, Gender.MALE),
                createPerson("Grzegorz", 35, Gender.OTHER));
    }

    private Person createPerson(String name, int age, Gender gender) {
        return Person.builder()
                .name(name)
                .age(age)
                .gender(gender)
                .build();
    }
}
