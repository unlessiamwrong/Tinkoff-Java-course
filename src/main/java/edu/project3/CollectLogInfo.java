package edu.project3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CollectLogInfo {

    static Map<String, Integer> httpMethodCount(List<String> logs) {
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

    static Map<String, Integer> endPointCount(List<String> logs) {
        Map<String, Integer> result = new HashMap<>();
        for (String log : logs) {
            Pattern pattern = Pattern.compile("\\s(\\/[\\w\\/]+)");
            Matcher matcher = pattern.matcher(log);

            if (matcher.find()) {
                String endPoint = matcher.group().substring(1);
                result.merge(endPoint, 1, Integer::sum);
            }
        }
        return result;
    }

    static Map<String, Integer> statusCodeCount(List<String> logs) {
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

    static Map<String, Integer> ipAddressCount(List<String> logs) {
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

    public static List<String> getTop3Values(Map<String, Integer> map) {
        return map.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue()
                .reversed())
            .limit(3)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}
