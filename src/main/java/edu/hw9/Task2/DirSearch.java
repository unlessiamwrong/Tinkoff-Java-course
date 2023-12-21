package edu.hw9.Task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DirSearch extends RecursiveTask<List<File>> {

    private final int maxLength = 1000;
    private final File directory;

    public DirSearch(File directory) {
        this.directory = directory;
    }

    @Override protected List<File> compute() {
        List<DirSearch> subTasks = new ArrayList<>();
        List<File> directories = new ArrayList<>();
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    DirSearch subTask = new DirSearch(file);
                    subTask.fork();
                    subTasks.add(subTask);
                }
            }
        }

        for (DirSearch subTask : subTasks) {
            directories.addAll(subTask.join());
        }

        if (files != null && files.length > maxLength) {
            directories.add(directory);
        }

        return directories;
    }
}
