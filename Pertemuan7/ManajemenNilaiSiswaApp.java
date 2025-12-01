package Pertemuan7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ManajemenNilaiSiswaApp extends JFrame {

    private JTextField txtNama, txtNilai;
    private JTable tableData;
    private JComboBox<String> cmbMatkul;
    private DefaultTableModel tableModel;

    public ManajemenNilaiSiswaApp() {
        setTitle("Manajemen Nilai Siswa");
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabPane = new JTabbedPane();

        // ================= TAB INPUT DATA ====================
        JPanel panelInput = new JPanel(new GridLayout(5, 2, 5, 5));

        panelInput.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Mata Kuliah:"));
        cmbMatkul = new JComboBox<>(new String[] {
                "Bahasa Indonesia", "Internet Of Things", "Intelegensi Buatan", "Perancangan Sistem"
        });
        panelInput.add(cmbMatkul);

        panelInput.add(new JLabel("Nilai:"));
        txtNilai = new JTextField();
        panelInput.add(txtNilai);

        JButton btnSimpan = new JButton("Simpan");
        JButton btnReset = new JButton("Reset");

        panelInput.add(btnSimpan);
        panelInput.add(btnReset);

        // ================= TAB DAFTAR NILAI ====================
        JPanel panelDaftar = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel(new String[]{
                "Nama", "Matkul", "Nilai", "Grade"
        }, 0);
        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);
        panelDaftar.add(scrollPane, BorderLayout.CENTER);

        JPanel panelTombol = new JPanel();
        JButton btnHapus = new JButton("Hapus Data Yang Terpilih");
        panelTombol.add(btnHapus);
        panelDaftar.add(panelTombol, BorderLayout.SOUTH);

        // ================= EVENT BUTTON ========================

        // Tombol Simpan
        btnSimpan.addActionListener(e -> {
            String nama = txtNama.getText();
            String nilaiStr = txtNilai.getText();
            String matkul = cmbMatkul.getSelectedItem().toString();

            // Validasi nama minimal 3 karakter
            if (nama.length() < 3) {
                JOptionPane.showMessageDialog(this,
                        "Nama minimal 3 karakter!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int nilai = Integer.parseInt(nilaiStr);
                String grade = getGrade(nilai);
                String keterangan = getKeterangan(grade);

                tableModel.addRow(new Object[]{nama, matkul, nilai, grade, keterangan});
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nilai harus angka!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Tombol Reset input
        btnReset.addActionListener(e -> {
            txtNama.setText("");
            txtNilai.setText("");
            cmbMatkul.setSelectedIndex(0);
        });

        // Hapus baris
        btnHapus.addActionListener(e -> {
            int indeks = tableData.getSelectedRow();
            if (indeks != -1) {
                tableModel.removeRow(indeks);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Pilih baris yang akan dihapus!",
                        "Peringatan",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        tabPane.addTab("Input Data", panelInput);
        tabPane.addTab("Daftar Nilai", panelDaftar);
        add(tabPane);

        setVisible(true);
    }

    // ================= SWITCH CASE GRADE ====================
    public String getGrade(int nilai) {
        switch (nilai / 10) {
            case 10:
            case 9: return "A";
            case 8:  return "B";
            case 7:  return "C";
            case 6:  return "D";
            default: return "E";
        }
    }

    // ================= KETERANGAN GRADE ====================
    public String getKeterangan(String grade) {
        switch (grade) {
            case "A": return "Sangat Baik";
            case "B": return "Baik";
            case "C": return "Cukup";
            case "D": return "Kurang";
            default:  return "Sangat Kurang";
        }
    }

    public static void main(String[] args) {
        new ManajemenNilaiSiswaApp();
    }
}
