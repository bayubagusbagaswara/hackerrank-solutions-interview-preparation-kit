package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommonChildTest {

    public static int commonChild(String s1, String s2) {
        return LCSM4(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
    }

    public static int LCSM4(char[] X, char[] Y, int m, int n) {
        int[] memo = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = memo[j];
                if (X[i - 1] == Y[j - 1]) {
                    memo[j] = prev + 1;
                } else {
                    memo[j] = Math.max(memo[j], memo[j-1]);
                }
                prev = temp;
            }
        }
        return memo[n];
    }

}
