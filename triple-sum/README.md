# Triple SUM

# Contoh Soal

- Sample Input

```bash

6 3 5
3 5 7 7 1 1
7 5 9
7 9 11 11 13
```

- Kriteria nya `p <= q` dan `q >= r`

# Langkah-langkah

1. Hapus data yang kembar
```bash
arrayA = {3, 5, 7, 1}
arrayB = {7, 5, 9} 
arrayC = {7, 9, 11, 13}
```
2. Masukkan tiap nilai pada index pertama tiap array nya, dan bandingkan sesuai kriteria

- Hasil yang dibentuk dari acuan arrayA <= arrayB >= arrayC
```bash
p <= q >= r

3, 5, 7, 1 <= 7 >= 7

{3, 7, 7}, {5, 7, 7}, {7, 7, 7}, {1, 7, 7}

Ada 4 array baru yang terbentuk
```

```bash

3, 5, 1 <= 5 >= x (karena di arrayC semua nilainya lebih dari 5, dan menyalahi kriteria)
tidak ada array yang dibentuk, karena semua arrayC tidak ada
```

```bash
3, 5, 7, 1 <= 9 >= 7, 9

{3, 9, 7}, {3, 9, 9}
{5, 9, 7}, {5, 9, 9}
{7, 9, 7}, {7, 9, 9}
{1, 9, 7}, {1, 9, 9}

Ada 8 array baru yang terbentuk
```

3. Jumlah total array baru

Jadi ada 4 + 8 = 12 array baru

4. Jika lebih diperhatikan lagi, ini bisa menggunakan sebuah rumus

```bash
O(lengthB * (lengthA + lengthC))
```
