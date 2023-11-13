package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw6.Task3.MagicNumberFilter.magicNumber;
import static edu.hw6.Task3.SizeFilter.largerThan;

@SuppressWarnings("MagicNumber")
public class Executor {

    public static final AbstractFilter REGULAR_FILE = Files::isRegularFile;
    public static final AbstractFilter READABLE = Files::isReadable;
    public static final AbstractFilter WRITEABLE = Files::isWritable;
    static Path path = Path.of("C:\\Users\\Вячеслав\\Tinkoff-Java-Course\\Tinkoff-Java-Course");
    static DirectoryStream.Filter<Path> filter = REGULAR_FILE
        .and(largerThan(11))
        .and(magicNumber(new byte[] {(byte) 0x89}));

    private Executor() {

    }

    public static DirectoryStream<Path> execute() {
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path, filter)) {
            return entries;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

