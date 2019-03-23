package service;

import java.util.HashMap;
import java.util.Map;

public class Exchanger {
    private static Map<Integer, Long> cache = new HashMap<>();

    private static long exchange(Integer num) {
        if (num < 12) {
            return num;
        }
        if (cache.containsKey(num)) {
            return cache.get(num);
        }

        long maxValue = exchange(num / 2) + exchange(num / 3) + exchange(num / 4);
        cache.put(num, maxValue);
        return maxValue;
    }

    public static long findMaxValue(Integer num) {
        if (num < 0 || num > 1000000000) {
            throw new RuntimeException("Either number is lesser than 0 or greater than 1000000000");
        }
        return exchange(num);
    }

}
