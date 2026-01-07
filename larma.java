package com.example.studentgui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Larma extends JFrame {
    private JTextField txtNama, txtNPM, txtUmur, txtNoHP, txtAlamat;
    private JRadioButton rbLaki, rbPerempuan;
    private ButtonGroup bgJenisKelamin;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnSimpan;

    public Larma() {
        setTitle("Input Data Mahasiswa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.LIGHT_GRAY);

        // Panel Form
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.LIGHT_GRAY);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Nama
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        txtNama = new JTextField(20);
        formPanel.add(txtNama, gbc);

        // NPM
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        formPanel.add(new JLabel("NPM:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        txtNPM = new JTextField(20);
        formPanel.add(txtNPM, gbc);

        // Jenis Kelamin
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        formPanel.add(new JLabel("Jenis Kelamin:"), gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.setBackground(Color.LIGHT_GRAY);
        rbLaki = new JRadioButton("Laki-laki", true);
        rbLaki.setBackground(Color.LIGHT_GRAY);
        rbPerempuan = new JRadioButton("Perempuan");
        rbPerempuan.setBackground(Color.LIGHT_GRAY);
        bgJenisKelamin = new ButtonGroup();
        bgJenisKelamin.add(rbLaki);
        bgJenisKelamin.add(rbPerempuan);
        genderPanel.add(rbLaki);
        genderPanel.add(rbPerempuan);
        formPanel.add(genderPanel, gbc);

        // Umur
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0;
        formPanel.add(new JLabel("Umur:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        txtUmur = new JTextField(20);
        formPanel.add(txtUmur, gbc);

        // No. HP
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0;
        formPanel.add(new JLabel("No. HP:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        txtNoHP = new JTextField(20);
        formPanel.add(txtNoHP, gbc);

        // Alamat
        gbc.gridx = 0; gbc.gridy = 5; gbc.weightx = 0;
        formPanel.add(new JLabel("Alamat:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        txtAlamat = new JTextField(20);
        formPanel.add(txtAlamat, gbc);

        // Tombol Simpan
        gbc.gridx = 1; gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        btnSimpan = new JButton("Simpan");
        btnSimpan.addActionListener(e -> simpanData());
        formPanel.add(btnSimpan, gbc);

        // Panel Tabel
        String[] kolom = {"Nama", "NPM", "Jenis Kelamin", "Umur", "No HP", "Alamat"};
        tableModel = new DefaultTableModel(kolom, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void simpanData() {
        String nama = txtNama.getText().trim();
        String npm = txtNPM.getText().trim();
        String jenisKelamin = rbLaki.isSelected() ? "Laki-laki" : "Perempuan";
        String umur = txtUmur.getText().trim();
        String noHP = txtNoHP.getText().trim();
        String alamat = txtAlamat.getText().trim();

        if (nama.isEmpty() || npm.isEmpty() || umur.isEmpty() || noHP.isEmpty() || alamat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{nama, npm, jenisKelamin, umur, noHP, alamat});

        // Clear form
        txtNama.setText("");
        txtNPM.setText("");
        rbLaki.setSelected(true);
        txtUmur.setText("");
        txtNoHP.setText("");
        txtAlamat.setText("");
        txtNama.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Larma form = new Larma();
            form.setVisible(true);
        });
    }
}