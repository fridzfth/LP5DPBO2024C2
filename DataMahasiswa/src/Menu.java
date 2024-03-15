import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

public class Menu extends JFrame {
    public static void main(String[] args) {
        // Membuat instance dari kelas Menu
        Menu window = new Menu();

        // Mengatur ukuran window
        window.setSize(600, 600);

        // Menempatkan window di tengah layar
        window.setLocationRelativeTo(null);

        // Mengatur panel utama sebagai konten window
        window.setContentPane(window.mainPanel);

        // Mengatur warna latar belakang
        window.getContentPane().setBackground(new Color(118, 171, 174));

        // Menampilkan window
        window.setVisible(true);

        // Mengatur operasi default ketika window ditutup
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Indeks baris yang dipilih pada tabel
    private int selectedIndex = -1;

    // ArrayList untuk menyimpan data Mahasiswa
    private ArrayList<Mahasiswa> listMahasiswa;

    // Komponen GUI
    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox<String> jurusanCombobox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;
    private JLabel jurusanLabel;
    private JRadioButton lakiRadio;
    private JRadioButton perempuanRadio;
    private ButtonGroup jenkelButtonGroup;

    // Konstruktor
    public Menu() {
        // Inisialisasi ArrayList Mahasiswa
        listMahasiswa = new ArrayList<>();

        // Inisialisasi ButtonGroup untuk radio button jurusan
        jenkelButtonGroup = new ButtonGroup();

        lakiRadio.setBackground(new Color(118, 171, 174));
        perempuanRadio.setBackground(new Color(118, 171, 174));
        // Menambahkan radio button ke dalam ButtonGroup
        jenkelButtonGroup.add(lakiRadio);
        jenkelButtonGroup.add(perempuanRadio);


        // Mengisi data awal pada list Mahasiswa
        populateList();

        // Mengatur model tabel
        mahasiswaTable.setModel(setTable());

        // Mengatur font untuk judul
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        // Mengatur opsi pada combo box jurusan data
        String[] jurusanData = {"","Computer Science","Electrical Engineering","Mechanical Engineering","Civil Engineering","Chemical Engineering","Biomedical Engineering","Physics","Mathematics","Statistics","Biology","Chemistry","Environmental Science","Geology","Astronomy","Psychology","Sociology","Economics","Political Science","History","Philosophy","English Literature","Foreign Languages","Communication Studies","Art History","Music","Theater","Architecture","Urban Planning","Anthropology","Geography","Criminal Justice","Public Health","Nursing","Business Administration","Marketing","Finance","Accounting","Human Resource Management","Hospitality Management"};
        jurusanCombobox.setModel(new DefaultComboBoxModel<>(jurusanData));

        // Menyembunyikan tombol delete
        deleteButton.setVisible(false);

        // Event listener untuk tombol "Add/Update"
        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // periksa form agar tidak ada data kosong
                if (!nimField.getText().isEmpty() && !namaField.getText().isEmpty() &&
                        !jurusanCombobox.getSelectedItem().toString().isEmpty() &&
                        !getSelectedJenkel().isEmpty()) {
                    if (selectedIndex == -1) {
                        insertData();
                    } else {
                        updateData();
                    }
                } else { // kalau data kosong
                    JOptionPane.showMessageDialog(null, "Maaf data input tidak boleh ada yang kosong");
                }
            }
        });

        // Event listener untuk tombol "Delete"
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (selectedIndex >= 0) {
                    // Konfirmasi penghapusan
                    int option = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        deleteData();
                    }
                }
            }
        });

        // Event listener untuk tombol "Cancel"
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        // Event listener saat baris tabel diklik
        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedIndex = mahasiswaTable.getSelectedRow();
                // siman value textfield, radio dan  como box
                String selectedNim = mahasiswaTable.getModel().getValueAt(selectedIndex, 1).toString();
                String selectedNama = mahasiswaTable.getModel().getValueAt(selectedIndex, 2).toString();
                String selectedJenisKelamin = mahasiswaTable.getModel().getValueAt(selectedIndex, 3).toString();
                String selectedJurusan = mahasiswaTable.getModel().getValueAt(selectedIndex, 4).toString();

                // ubah isi textfield, radio dan  como box
                nimField.setText(selectedNim);
                namaField.setText(selectedNama);
                setSelectedJenkel(selectedJenisKelamin);
                jurusanCombobox.setSelectedItem(selectedJurusan);
                //ubah add button menjadi update
                addUpdateButton.setText("Update");
                deleteButton.setVisible(true);
            }
        });
    }

    // Method untuk mengatur radio button jenkel yang terpilih
    private void setSelectedJenkel(String selectedJurusan) {
        if (selectedJurusan.equals("Laki-laki")) {
            lakiRadio.setSelected(true);
        } else if (selectedJurusan.equals("Perempuan")) {
            perempuanRadio.setSelected(true);
        }
    }

    // Method untuk mendapatkan jenkel yang dipilih
    private String getSelectedJenkel() {
        if (lakiRadio.isSelected()) {
            return "Laki-laki";
        } else if (perempuanRadio.isSelected()) {
            return "Perempuan";
        } else {
            return "";
        }
    }

    // Method untuk mengatur model tabel
    public final DefaultTableModel setTable() {
        Object[] column = {"No", "NIM", "Nama", "Jenis Kelamin", "Jurusan"};
        DefaultTableModel temp = new DefaultTableModel(null, column);
        // isi tabel dengan listMahasiswa
        for (int i = 0; i < listMahasiswa.size(); i++) {
            Object[] row = new Object[5];
            row[0] = i + 1;
            row[1] = listMahasiswa.get(i).getNim();
            row[2] = listMahasiswa.get(i).getNama();
            row[3] = listMahasiswa.get(i).getJenisKelamin();
            row[4] = listMahasiswa.get(i).getJurusan();
            temp.addRow(row);
        }

        return temp;
    }

    // Method untuk menambah data
    public void insertData() {
        // ambil value dari textfield, radio dan  combox
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jurusan = jurusanCombobox.getSelectedItem().toString();
        String jenisKelamin = getSelectedJenkel();

        // add to listMahasiswa
        listMahasiswa.add(new Mahasiswa(nim, nama, jenisKelamin, jurusan));

        // update table
        mahasiswaTable.setModel(setTable());
        // bersihkan form
        clearForm();
        // feedback
        System.out.println("Insert Berhasil");
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }

    // Method untuk memperbarui data
    public void updateData() {
        // ambil data dari textfield, radio dan  combox
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jurusan = jurusanCombobox.getSelectedItem().toString();

        // ubah data di list
        listMahasiswa.get(selectedIndex).setNim(nim);
        listMahasiswa.get(selectedIndex).setNama(nama);
        listMahasiswa.get(selectedIndex).setJurusan(jurusan);
        listMahasiswa.get(selectedIndex).setJenisKelamin(getSelectedJenkel());
        // update tabel
        mahasiswaTable.setModel(setTable());
        // bersihkan form
        clearForm();
        //feedback
        System.out.println("Update Berhasil");
        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah!");
    }

    // Method untuk menghapus data
    public void deleteData() {
        // hapus data dr list
        listMahasiswa.remove(selectedIndex);
        //update table
        mahasiswaTable.setModel(setTable());
        //berishkan form
        clearForm();
        // feedback
        System.out.println("Delete Berhasil");
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }

    // Method untuk mengosongkan form
    public void clearForm() {
        // ksoongkan semua textfield, radio dan  combox
        namaField.setText("");
        nimField.setText("");
        jurusanCombobox.setSelectedItem("");
        // ubah button update jadi add
        addUpdateButton.setText("Add");
        //sembunyikan delete
        deleteButton.setVisible(false);
        // ubah selection index menjadi -1 (no selection)
        selectedIndex = -1;
        // clear pilihan yang di Rbutton
        jenkelButtonGroup.clearSelection();
    }

    // Method untuk mengisi list data Mahasiswa
    private void populateList() {
        listMahasiswa.add(new Mahasiswa("2203999", "Amelia Zalfa Julianti", "Perempuan", "Computer Science"));
        listMahasiswa.add(new Mahasiswa("2202292", "Muhammad Iqbal Fadhilah", "Laki-laki", "Business Administration"));
        listMahasiswa.add(new Mahasiswa("2202346", "Muhammad Rifky Afandi", "Laki-laki", "Computer Science"));
        listMahasiswa.add(new Mahasiswa("2210239", "Muhammad Hanif Abdillah", "Laki-laki", "Economics"));
        listMahasiswa.add(new Mahasiswa("2202046", "Nurainun", "Perempuan", "Computer Science"));
        listMahasiswa.add(new Mahasiswa("2205101", "Kelvin Julian Putra", "Laki-laki", "Business Administration"));
        listMahasiswa.add(new Mahasiswa("2200163", "Rifanny Lysara Annastasya", "Perempuan", "Computer Science"));
        listMahasiswa.add(new Mahasiswa("2202869", "Revana Faliha Salma", "Perempuan", "Economics"));
        listMahasiswa.add(new Mahasiswa("2209489", "Rakha Dhifiargo Hariadi", "Laki-laki", "Computer Science"));
        listMahasiswa.add(new Mahasiswa("2203142", "Roshan Syalwan Nurilham", "Laki-laki", "Business Administration"));
        listMahasiswa.add(new Mahasiswa("2200311", "Raden Rahman Ismail", "Laki-laki", "Economics"));
        listMahasiswa.add(new Mahasiswa("2200978", "Ratu Syahirah Khairunnisa", "Perempuan", "Computer Science"));
        listMahasiswa.add(new Mahasiswa("2204509", "Muhammad Fahreza Fauzan", "Laki-laki", "Business Administration"));
        listMahasiswa.add(new Mahasiswa("2205027", "Muhammad Rizki Revandi", "Laki-laki", "Computer Science"));
        listMahasiswa.add(new Mahasiswa("2203484", "Arya Aydin Margono", "Laki-laki", "Economics"));
        listMahasiswa.add(new Mahasiswa("2200481", "Marvel Ravindra Dioputra", "Laki-laki", "Computer Science"));
        listMahasiswa.add(new Mahasiswa("2209889", "Muhammad Fadlul Hafiizh", "Laki-laki", "Business Administration"));
        listMahasiswa.add(new Mahasiswa("2206697", "Rifa Sania", "Perempuan", "Computer Science"));
        listMahasiswa.add(new Mahasiswa("2207260", "Imam Chalish Rafidhul Haque", "Laki-laki", "Business Administration"));
        listMahasiswa.add(new Mahasiswa("2204343", "Meiva Labibah Putri", "Perempuan", "Economics"));
    }

}
