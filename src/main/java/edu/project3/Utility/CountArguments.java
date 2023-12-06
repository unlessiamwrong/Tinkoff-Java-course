package edu.project3.Utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CountArguments {

    private static final int TOP_THREE = 3;

    private final List<String> logs;

    public CountArguments(List<String> logs) {
        this.logs = logs;
    }

    public Map<String, Integer> httpMethodCount() {
        Map<String, Integer> result = new HashMap<>();
        for (String log : logs) {
            Pattern pattern = Pattern.compile("\"[A-Z]{3,}");
            Matcher matcher = pattern.matcher(log);
            if (matcher.find()) {
                String httpRequest = matcher.group().substring(1);
                result.merge(httpRequest, 1, Integer::sum);
            }
        }
        return result;
    }

    public Map<String, Integer> endPointCount() {
        Map<String, Integer> result = new HashMap<>();
        for (String log : logs) {
            Pattern pattern = Pattern.compile("\\s(/[\\w/]+)");
            Matcher matcher = pattern.matcher(log);

            if (matcher.find()) {
                String endPoint = matcher.group().substring(1);
                result.merge(endPoint, 1, Integer::sum);
            }
        }
        return result;
    }

    public Map<String, Integer> statusCodeCount() {
        Map<String, Integer> result = new HashMap<>();
        for (String log : logs) {
            Pattern pattern = Pattern.compile("\\s\\d[123450]{2}\\s");
            Matcher matcher = pattern.matcher(log);

            if (matcher.find()) {
                String endPoint = matcher.group().trim();
                result.merge(endPoint, 1, Integer::sum);
            }
        }
        return result;
    }

    public Map<String, Integer> ipAddressCount() {
        Map<String, Integer> result = new HashMap<>();
        for (String log : logs) {
            Pattern pattern = Pattern.compile("^\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}");
            Matcher matcher = pattern.matcher(log);

            if (matcher.find()) {
                String endPoint = matcher.group();
                result.merge(endPoint, 1, Integer::sum);
            }
        }
        return result;
    }

    public List<String> getTopThreeValues(Map<String, Integer> map) {
        return map.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue()
                .reversed())
            .limit(TOP_THREE)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}
