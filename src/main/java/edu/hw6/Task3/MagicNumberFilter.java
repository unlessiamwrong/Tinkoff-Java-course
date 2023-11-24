package edu.hw6.Task3;

import java.nio.file.Files;

interface MagicNumberFilter extends AbstractFilter {

    static AbstractFilter magicNumber(byte[] bytes) {
        return path -> {
            byte[] magicBytes = Files.readAllBytes(path);
            if (bytes.length > magicBytes.length) {
                return false;
            }
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] != magicBytes[i]) {
                    return false;
                }
            }
            return true;
        };
    }
}

