package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class IceCreamParlorTest {

    // approach1 - using hashmap
    public static int[] icecreamParlorA1(int m, int[] arr) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int y = m - x;
            Integer j = map.get(y);
            if (j != null) {
                result[0] = j + 1;
                result[1] = i + 1;
                break;
            }
            map.put(x, i);
        }
        return result;
    }

    // approach2 - using array
    static int[] icecreamParlorA2(int m, int[] arr) {
        int[] result = new int[2];
        int n = arr.length;
        int[] frequency = new int[10001];

        Arrays.fill(frequency, -1);

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int y = m - x;

            if (y >= 0) {
                int j = frequency[y];
                if (j != -1) {
                    result[0] = j + 1;
                    result[1] = i + 1;
                    break;
                }
            }
            frequency[x] = i;
        }
        return result;
    }

    // approach3 = editorial approach
    public static int[] icecreamParlorA3(int m, int[] arr) {
        int[] result = new int[2];
        int n = arr.length;
        int[] frequency = new int[10001];
        int firstFlavourIndex = 0;
        int secondFlavourIndexStartsFrom = 0;
        int secondFlavourCost = 0;

        for (int i = 0; i < n; i++) {
            int priceIndex = arr[i];
            frequency[priceIndex]++;
        }

        for (int i = 0; i < n; i++) {
            int firstFlavourCost = arr[i];
            frequency[firstFlavourCost]--;

            secondFlavourCost = m - firstFlavourCost;

            if (secondFlavourCost > 0 && frequency[secondFlavourCost] > 0) {
                firstFlavourIndex = i;
                secondFlavourIndexStartsFrom = firstFlavourIndex + 1;
                result[0] = firstFlavourIndex + 1;
                break;
            }
        }
        return result;
    }
}
