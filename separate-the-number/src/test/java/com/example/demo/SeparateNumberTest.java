package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeparateNumberTest {

    public static void separateNumbers(String s) {
        String subString = "";
        boolean isValid = false;

        // perulangan hanya dilakukan sebagian
        for (int i = 1; i <= s.length() / 2; i++) {
            // substring(beginIndex, endIndex)
            subString = s.substring(0, i);
            // ubah menjadi long
            long num = Long.parseLong(subString);
            StringBuilder validString = new StringBuilder(subString);
            while (validString.length() < s.length()) {
                validString.append(++num);
            }

            if (s.equals(validString.toString())) {
                isValid = true;
                break;
            }
        }
        System.out.println(isValid ? "YES " + subString : "NO");
    }
}
