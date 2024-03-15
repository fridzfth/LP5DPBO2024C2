# README - LP5DPBO2024C2
Saya Mohammad Faridz Fathin mengerjakan LP4 dalam mata kuliah DPBO untuk keberkahanNya maka saya tidak akan melakukan kecurangan seperti yang telah dispesifikasikan
## Desain Program

Program ini merupakan sebuah aplikasi sederhana untuk manajemen data mahasiswa. Program ini ditulis dalam bahasa pemrograman Java dan menggunakan library Swing untuk membangun antarmuka pengguna grafis (GUI). 

### Kelas Mahasiswa

Kelas `Mahasiswa` digunakan untuk merepresentasikan data mahasiswa. Kelas ini memiliki atribut sebagai berikut:
- `nim` (String): Nomor Induk Mahasiswa
- `nama` (String): Nama mahasiswa
- `jenisKelamin` (String): Jenis kelamin mahasiswa
- `jurusan` (String): Jurusan mahasiswa

Kelas `Mahasiswa` memiliki konstruktor untuk menginisialisasi objek mahasiswa, serta getter dan setter untuk mengakses dan mengubah nilai atribut.

### Kelas Menu

Kelas `Menu` merupakan kelas utama yang digunakan untuk menampilkan antarmuka pengguna dan mengatur logika program. 

Antarmuka pengguna (GUI) pada kelas `Menu` terdiri dari:
- Text field untuk input NIM dan nama mahasiswa
- Combo box untuk memilih jurusan
- Radio button untuk memilih jenis kelamin
- Tombol untuk menambah, mengupdate, dan menghapus data mahasiswa
- Tabel untuk menampilkan data mahasiswa

Kelas `Menu` memiliki method-method sebagai berikut:
- `setTable()`: Mengatur model tabel untuk menampilkan data mahasiswa.
- `insertData()`: Menambahkan data mahasiswa baru ke dalam list dan memperbarui tampilan tabel.
- `updateData()`: Memperbarui data mahasiswa yang dipilih dan memperbarui tampilan tabel.
- `deleteData()`: Menghapus data mahasiswa yang dipilih dari list dan memperbarui tampilan tabel.
- `clearForm()`: Mengosongkan input form dan mengatur kembali kondisi GUI.
- `populateList()`: Mengisi list data mahasiswa dengan data awal.

## Alur Program

1. Program dimulai dengan membuat instance dari kelas `Menu`.
2. Program mengatur tampilan window dengan mengatur ukuran, posisi, konten, dan warna latar belakang.
3. Program memanggil method `populateList()` untuk mengisi list data mahasiswa dengan data awal.
4. Program mengatur model tabel dengan memanggil method `setTable()`.
5. Program menambahkan event listener untuk tombol "Add/Update", "Delete", dan "Cancel", serta untuk baris tabel yang diklik.
6. Pengguna dapat menambahkan data mahasiswa baru dengan mengisi input form dan mengklik tombol "Add/Update".
7. Pengguna dapat mengupdate atau menghapus data mahasiswa yang dipilih dengan mengklik baris tabel terlebih dahulu, mengubah data di input form, lalu mengklik tombol "Add/Update" atau "Delete".
8. Pengguna tidak dapat mengupdate atau menambah data dengan nilai null atau kosong.
9. Pengguna dapat membatalkan operasi yang sedang dilakukan dengan mengklik tombol "Cancel".

## Dokumentasi

### Tampilan Antarmuka Pengguna
Program akan menampilkan jendela dengan tabel untuk menampilkan data mahasiswa, serta input form untuk menambah, mengupdate, dan menghapus data.

[![SR](https://github.com/fridzfth/LP5DPBO2024C2/blob/1a317c6d44eb241c5e6d15e69966cc4ea18d037f/Screenshot%20Screenrecord/Screenshot%202024-03-15%20060401.png)](https://github.com/fridzfth/LP5DPBO2024C2/blob/46b0fcc88f39d68d73178865ad4a95875f28386f/Screenshot%20Screenrecord/2024-03-15%2006-39-36.mkv)
