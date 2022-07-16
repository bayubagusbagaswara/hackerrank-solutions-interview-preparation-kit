package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArraysLeftRotationTest {

    public static int[] rotationLeft(int[] a, int d) {

        // hitung panjang array
        int n = a.length;

        // buat array baru untuk menyimpan hasil rotasi nya
        int[] rotationArray = new int[n];

        // ulang sampai panjang array yang lama
        // misal panjang array lama adalah 5, maka index hanya sampai 4
        for (int oldIndex = 0; oldIndex < n; oldIndex++) {

            // index baru didapatkan dari index lama + panjang array lama - d lalu dimodulus dengan panjang array lama
            // misal panjang array lama adalah 5, misal d nya 4
            // (0 + 5 - 4) % 5 = 1 % 5 = 4
            // jadi jika index lama bernilai 0, maka index baru nya akan bernilai 4
            int newIndex = (oldIndex + n - d) % n;

            // masukkan nilai dari array lama ke array baru
            rotationArray[newIndex] = a[oldIndex];
        }
        return rotationArray;
    }
}
