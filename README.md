# 📈 Sistem Investasi Saham & Surat Berharga Negara (SBN) - CLI Java

Hallo, selamat datang pada program kami!. Program ini adalah aplikasi simulasi investasi **Saham** dan **Surat Berharga Negara (SBN)** berbasis Command Line Interface (CLI) menggunakan **Java murni** tanpa framework eksternal.

---

## 📚 Identitas Kami
- ANAK AGUNG GDE PUTRA PURNAMA (2405551172)
- Jihan Alya Qanita (2405551120)

---

## 🧠 Fitur Utama
Fitur utama dari program kami adalah memberi kemampuan pada user yang memiliki 2 versi yaitu admmin dan customer untuk membeli, menjual dan menambah (khusus admin) saham maupun SBN

### 👨‍💼 Role: Admin
- Login ke sistem (username: `GungPur`, password: `GungPur123`)
- Menambah produk saham
- Mengubah harga produk saham
- Menambah produk SBN
- Menghapus produk saham dan SBN

### 👤 Role: Customer
- Login ke sistem (username: `Jihan`, password: `Jihan123`)
- Membeli saham
- Menjual saham
- Membeli Surat Berharga Negara (SBN)
- Melihat simulasi kupon bulanan SBN
- Melihat portofolio investasi

# UML
![PBO FIKS drawio](https://github.com/user-attachments/assets/db5978d4-b497-45a5-a54a-1c2a76acd149)

# Proses Penggunaan 
Di bawah ini merupakan tampilan antarmuka dan alur kerja sistem Investasi Saham & Surat Berharga Negara (SBN), dilengkapi dengan screenshot hasil eksekusi program. 

## Login 
![Image](https://github.com/user-attachments/assets/9c1cf89c-1021-4b46-9717-23a6e2141f7e)
![Image](https://github.com/user-attachments/assets/f97c147d-52c2-45c8-8ff1-f554f4dc9fd9)
![image](https://github.com/user-attachments/assets/562d85c0-443d-4d3e-a20c-e546dd5bab9f)
Setelah user memilih melakukan login sebagai costumer atau pun admin, user akan diminta untuk menginputkan username dan password meereka. Dan lalu akan diarahkan ke menu selanjutnya.

## Menu Administrator 
![image](https://github.com/user-attachments/assets/dd5889b2-39b6-4149-be31-cb123123d2a8)
Setelah melakukan login sebagai admin, maka user akan diberi pilihan opsi pada menu admin seperti gambar di atas. Admin akan diminta untuk memilih opsi di atas dengan menginputkan angka

## Menu Costumer
![image](https://github.com/user-attachments/assets/ba0f6538-5a59-4e80-8348-6a59e857eeb4)
Setelah melakukan login sebagai costumer, maka user akan diberi pilihan opsi pada menu costumer seperti gambar di atas. Admin akan diminta untuk memilih opsi di atas dengan menginputkan angka sesuai dengan kebutuhan

## Menu Saham 
![image](https://github.com/user-attachments/assets/815b0d14-83d0-4393-b6dc-d0c8de24039f)

Ketika costumer memilih opsi saham, maka costumer akan di arahkan ke Menu Saham yang dimana costumer diberikan pilihan untuk melakukan pembelian saham atau menjual saham

# Pembelian Saham 
![image](https://github.com/user-attachments/assets/191e0bc4-c171-4336-9dcb-99ee01e32b6f)
![image](https://github.com/user-attachments/assets/01c598d4-a883-42c3-8ce6-17f8a0106fa0)

Costumer akan diberikan list saham aktif dengan informasi; Kode saham (contoh: BBRI), Nama emiten, Harga per lembar. Customer memilih saham dengan memasukkan nomor indeks (1, 2, atau 3). Yang dimana sebagai contoh jika customer memilih indeks 1, sistem akan memproses pembelian saham Bank BRI dengan harga Rp5000 per lembar. Lalu Costumer dapat memasukkan berapa banyak lembar saham yang ingin dibeli.

# Penjualan Saham 
![image](https://github.com/user-attachments/assets/63dee591-4294-4dcc-9e68-924dde9a1b6e)
![image](https://github.com/user-attachments/assets/a918bd93-cd8e-45fb-9eed-bb3bc0b50951)

Costumer dapat memilih opsi 2 untuk menjual saham milik mereka, Costumer dapat melihat saham apa saja yang sudah dimiliki dan dapat menginputkan saham yang mana dan seberapa banyak lembar saham yang akan dijual 


