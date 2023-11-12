package edu.hw6.Task3;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;

interface GlobFilter extends AbstractFilter {

    static AbstractFilter globMatches(String glob) {
        PathMatcher matcher =
            FileSystems.getDefault().getPathMatcher("glob:" + glob);
        return path -> matcher.matches(path.getFileName());
    }

}
