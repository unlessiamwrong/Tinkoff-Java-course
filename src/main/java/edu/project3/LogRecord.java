package edu.project3;

import java.nio.file.Path;
import java.time.LocalDate;

public record LogRecord(String glob, Path path, LocalDate date) {

}
