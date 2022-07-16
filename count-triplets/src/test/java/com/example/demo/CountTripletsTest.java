package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class CountTripletsTest {

    public static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> leftMap = new HashMap<>();
        Map<Long, Long> rightMap = new HashMap<>();

        for (Long item : arr) {
            rightMap.put(item, rightMap.getOrDefault(item, 0L) + 1);
        }

        long count = 0;

        for (int i = 0; i < arr.size(); i++) {
            long midTerm = arr.get(i);
            long c1 = 0;
            long c3 = 0;

            rightMap.put(midTerm, rightMap.getOrDefault(midTerm, 0L) - 1);

            if (leftMap.containsKey(midTerm / r) && midTerm % r == 0) {
                c1 = leftMap.get(midTerm / r);
            }

            if (rightMap.containsKey(midTerm * r)) {
                c3 = rightMap.get(midTerm * r);
            }

            count += c1 * c3;

            leftMap.put(midTerm, leftMap.getOrDefault(midTerm, 0L) + 1);
        }
        return count;
    }
}
