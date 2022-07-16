package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@SpringBootTest
public class TripleSumTest {

    // 1. Kita diberi 3 buah array. Misalnya arrayA, arrayB, arrayC
    // 2. Masing-masing array tersebut memiliki ukuran masing-masing
    // 3. Dimana masing-masing isi array tersebut ada sebuah nilai untuk kriteria
    // 4. Nilai nya adalah p, q, r.
    // Nilai p berada di arrayA
    // Nilai q berada di arrayB
    // Nilai r berada di arrayC
    // 5. Kriteria nya adalah:
    // p tidak boleh lebih besar dari nilai q
    // r juga tidak boleh lebih besar dari nilai q
    // Outputnya adalah array yang isinya nilai p,q,r. Jadi [p, q, r]

    // Sample input 0
    // 3 2 3, ini adalah ukuran array nya, arrayA[3], arrayB[2], arrayC[3]
    // 1 3 5, ini adalah isi dari arrayA
    // 2 3, ini adalah isi dari arrayB
    // 1 2 3, ini adalah isi dari arrayC

    // Sample output 0
    // 8, artinya ada 8 kombinasi angka dengan isinya adalah p,q,r (yang memenuhi kriteria)
    // (1,2,1), (1,2,2), (1,3,1), (1,3,2), (1,3,3), (3,3,1), (3,3,2), (3,3,3)

    // Fungsi untuk menghitung jumlah kombinasi dari 3 array
    public static long triplets(int[] a, int[] b, int[] c) {
        long distinctTriplet = 0;

        // remove nilai duplikat pada masing-masing array
        int[] distinctA = removeDuplicates(a);
        int[] distinctB = removeDuplicates(b);
        int[] distinctC = removeDuplicates(c);

        // urutkan isi dalam arraynya
        Arrays.sort(distinctA);
        Arrays.sort(distinctB);
        Arrays.sort(distinctC);

        // ambil tiap nilai dari arrayB, karena nilai arrayB sebagai acuan kriteria
        for (int q : distinctB) {
            long c1 = getValidIndex(distinctA, q) + 1;
            long c3 = getValidIndex(distinctC, q) + 1;
            distinctTriplet = distinctTriplet + c1 * c3;
        }
        return distinctTriplet;
    }

    // Fungsi untuk menghilangkan nilai array yang kembar
    public static int[] removeDuplicates(int[] a) {
        Set<Integer> set = new HashSet<>();

        // ambil tiap nilai array a, lalu masukkan nilai nya ke set
        for (int item : a) {
            set.add(item);
        }

        int len = set.size();

        // bikin array baru untuk menyimpan data yang sudah tidak ada nilai duplicate
        // panjang array result sesuai dengan panjang set
        int[] result = new int[len];
        int i = 0;
        // ambil tiap nilai dari set, lalu masukkan kedalam array result
        for (int item : set) {
            result[i++] = item;
        }
        return result;
    }

    // Fungsi untuk mengecek nilai pada arrayA dan arrayC apakah memenuhi kriteria dengan nilai q di arrayB
    public static int getValidIndex(int[] distinctA, int key) {
        int low = 0; // index paling bawah
        int high = distinctA.length - 1; // index paling tinggi
        int count = -1;

        // cek tiap index
        while (low <= high) {
            // mid = 0 + (2 - 0) / 2 = 1
            // kita cari nilai tengah nya
            int mid = low + (high - low) / 2;

            if (distinctA[mid] <= key) {
                count = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return count;
    }


    @Test
    void tripleSum() {
        Scanner sc = new Scanner(System.in);
        int lena = sc.nextInt();
        int lenb = sc.nextInt();
        int lenc = sc.nextInt();

        int[] a = new int[lena];
        int[] b = new int[lenb];
        int[] c = new int[lenc];
    }
}
