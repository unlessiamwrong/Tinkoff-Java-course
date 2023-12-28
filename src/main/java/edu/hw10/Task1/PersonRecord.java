package edu.hw10.Task1;

public record PersonRecord(@NotNull String name, @Min(1) @Max(15) int age) {
}
