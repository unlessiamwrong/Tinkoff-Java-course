package edu.hw10.Task1;

public class PersonClass {
    @NotNull protected String name;

    @Min(1) @Max(15) protected int age;

    public PersonClass(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
