package edu.hw10.Task1;

public class PersonExtender extends PersonClass {

    @NotNull protected String name;

    @Min(1) @Max(15) protected int age;

    public PersonExtender(String name, int age) {
        super(name, age);
    }
}
