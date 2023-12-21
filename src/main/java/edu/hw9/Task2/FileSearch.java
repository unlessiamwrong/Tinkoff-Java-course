package edu.hw9.Task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FileSearch extends RecursiveTask<List<File>> {
    private final File directory;
    private final long size;
    private final String extension;

    public FileSearch(File directory, long size, String extension) {
        this.directory = directory;
        this.size = size;
        this.extension = extension;
    }

    @Override protected List<File> compute() {
        List<FileSearch> subTasks = new ArrayList<>();
        List<File> matchingFiles = new ArrayList<>();
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    FileSearch subTask = new FileSearch(file, size, extension);
                    subTask.fork();
                    subTasks.add(subTask);
                } else {
                    if (file.length() >= size && file.getName().endsWith(extension)) {
                        matchingFiles.add(file);
                    }
                }
            }
        }

        for (FileSearch subTask : subTasks) {
            matchingFiles.addAll(subTask.join());
        }

        return matchingFiles;
    }
}
