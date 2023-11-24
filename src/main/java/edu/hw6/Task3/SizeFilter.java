package edu.hw6.Task3;

import java.nio.file.Files;

interface SizeFilter extends AbstractFilter {
    static AbstractFilter largerThan(int value) {
        return path -> Files.size(path) > value;
    }
}
