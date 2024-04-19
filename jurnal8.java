import java.util.HashMap;
import java.util.Map;

public class jurnal8 {
    // Key: (NIM, kelas, nama) -> Value: nilai mahasiswa
    static Map<String, Double> dataMahasiswa = new HashMap<>();

    // Method untuk menambahkan mahasiswa 
    static void tambahMahasiswa(String nim, String kelas, String nama, double nilai) {
        String key = nim + "-" + kelas + "-" + nama;
        dataMahasiswa.put(key, nilai);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    // Method untuk menghapus mahasiswa 
    static void hapusMahasiswa(String nim, String kelas, String nama) {
        String key = nim + "-" + kelas + "-" + nama;
        if (dataMahasiswa.containsKey(key)) {
            dataMahasiswa.remove(key);
            System.out.println("Mahasiswa berhasil dihapus.");
        } else {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
    }

    // Method untuk menyimpan nilai mahasiswa
    static void simpanNilai(String nim, String kelas, String nama, double nilai) {
        String key = nim + "-" + kelas + "-" + nama;
        if (dataMahasiswa.containsKey(key)) {
            dataMahasiswa.put(key, nilai);
            System.out.println("Nilai mahasiswa berhasil disimpan.");
        } else {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
    }

    // Method untuk menampilkan seluruh nilai mahasiswa beserta rata-rata 
    static void tampilkanNilai() {
        if (dataMahasiswa.isEmpty()) {
            System.out.println("Data mahasiswa kosong.");
        } else {
            System.out.println("Nilai Mahasiswa:");
            for (Map.Entry<String, Double> entry : dataMahasiswa.entrySet()) {
                String[] keyParts = entry.getKey().split("-");
                String nim = keyParts[0];
                String kelas = keyParts[1];
                String nama = keyParts[2];
                double nilai = entry.getValue();
                System.out.println("NIM: " + nim + ", Kelas: " + kelas + ", Nama: " + nama + ", Nilai: " + nilai);
            }
            // Hitung rata-rata
            double totalNilai = 0;
            for (double nilai : dataMahasiswa.values()) {
                totalNilai += nilai;
            }
            double rataNilai = totalNilai / dataMahasiswa.size();
            System.out.println("Rata-rata Nilai: " + rataNilai);
        }
    }

    public static void main(String[] args) {
        // Contoh
        tambahMahasiswa("123456", "A", "Putri", 95.5);
        tambahMahasiswa("678910", "B", "Maharani", 80.0);
        tampilkanNilai();
        hapusMahasiswa("123456", "A", "Putri");
        simpanNilai("678910", "B", "Maharani", 80.0);
        tampilkanNilai();
    }
}