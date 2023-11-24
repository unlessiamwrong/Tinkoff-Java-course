package edu.hw6;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {

    public static class HackerNews {

        private static final Pattern PATTERN = Pattern.compile(".title.{3}([^\"]*).");
        private static final HttpClient CLIENT = HttpClient.newBuilder().build();

        public static List<Long> hackerNewsTopStories() throws IOException, URISyntaxException, InterruptedException {
            List<Long> result = new ArrayList<>();
            HttpRequest request =
                HttpRequest.newBuilder(new URI("https://hacker-news.firebaseio.com/v0/topstories.json")).build();
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            String[] rawData = response.body().substring(1, response.body().length() - 1).split(",");
            for (String id : rawData) {
                result.add(Long.parseLong(id));
            }
            return result;
        }

        public static String news(long id) throws IOException, URISyntaxException, InterruptedException {
            HttpRequest request =
                HttpRequest.newBuilder(new URI("https://hacker-news.firebaseio.com/v0/item/" + id + ".json")).build();
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            String rawData = response.body();
            Matcher matcher = PATTERN.matcher(rawData);
            if (matcher.find()) {
                return matcher.group();
            }
            return null;
        }
    }
}
