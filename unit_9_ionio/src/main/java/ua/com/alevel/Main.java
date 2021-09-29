package ua.com.alevel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        String data = fileManager.read();
        Map<String, Integer> map = findWordCount(data);
        fileManager.writeResult(map, findPolindromCount(map), sentenceCount(data));
    }

    private static Map<String, Integer> findWordCount(String data) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = data.split("\\W+");

        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        // sort map
        return map.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    private static int findPolindromCount(Map<String,Integer> map) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            boolean isPolindrom = true;
            for (int i = 0; i < entry.getKey().length() / 2; i++) {
                if (entry.getKey().charAt(i) != entry.getKey().charAt(entry.getKey().length() - 1 - i)) {
                    isPolindrom = false;
                    break;
                }
            }
            if (isPolindrom) {
                count += entry.getValue();
            }
        }
        return count;
    }

    private static int sentenceCount(String data) {
        return data.split("[!?.]+").length - 1;
    }
}
