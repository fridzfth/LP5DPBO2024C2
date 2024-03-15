/**
 * Kelas Mahasiswa merepresentasikan data seorang mahasiswa.
 */
public class Mahasiswa {
    private String nim; // Nomor Induk Mahasiswa
    private String nama; // Nama Mahasiswa
    private String jenisKelamin; // Jenis Kelamin Mahasiswa
    private String jurusan; // Jurusan Mahasiswa

    /**
     * Konstruktor untuk membuat objek Mahasiswa baru.
     *
     * @param nim           Nomor Induk Mahasiswa
     * @param nama          Nama Mahasiswa
     * @param jenisKelamin  Jenis Kelamin Mahasiswa
     * @param jurusan       Jurusan Mahasiswa
     */
    public Mahasiswa(String nim, String nama, String jenisKelamin, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.jurusan = jurusan;
    }

    /**
     * Method untuk mendapatkan jurusan mahasiswa.
     *
     * @return Jurusan Mahasiswa
     */
    public String getJurusan() {
        return jurusan;
    }

    /**
     * Method untuk mengatur jurusan mahasiswa.
     *
     * @param jurusan Jurusan Mahasiswa yang akan diatur
     */
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    /**
     * Method untuk mengatur NIM mahasiswa.
     *
     * @param nim NIM Mahasiswa yang akan diatur
     */
    public void setNim(String nim) {
        this.nim = nim;
    }

    /**
     * Method untuk mengatur nama mahasiswa.
     *
     * @param nama Nama Mahasiswa yang akan diatur
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * Method untuk mengatur jenis kelamin mahasiswa.
     *
     * @param jenisKelamin Jenis Kelamin Mahasiswa yang akan diatur
     */
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    /**
     * Method untuk mendapatkan NIM mahasiswa.
     *
     * @return NIM Mahasiswa
     */
    public String getNim() {
        return this.nim;
    }

    /**
     * Method untuk mendapatkan nama mahasiswa.
     *
     * @return Nama Mahasiswa
     */
    public String getNama() {
        return this.nama;
    }

    /**
     * Method untuk mendapatkan jenis kelamin mahasiswa.
     *
     * @return Jenis Kelamin Mahasiswa
     */
    public String getJenisKelamin() {
        return this.jenisKelamin;
    }
}
