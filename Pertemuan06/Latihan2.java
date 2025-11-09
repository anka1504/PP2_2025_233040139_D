package Pertemuan06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Latihan2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JLabel labelC = new JLabel("Celcius:");
        JTextField inputC = new JTextField(10);
        JButton btnKonversi = new JButton("Konversi");
        JLabel labelF = new JLabel("Fahrenheit:");
        JLabel hasil = new JLabel("");

        frame.add(labelC);
        frame.add(inputC);
        frame.add(btnKonversi);
        frame.add(labelF);
        frame.add(hasil);

        // Event handling
        btnKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celcius = Double.parseDouble(inputC.getText());
                    double fahrenheit = (celcius * 9 / 5) + 32;
                    hasil.setText(String.format("%.2f °F", fahrenheit));
                } catch (NumberFormatException ex) {
                    hasil.setText("Input tidak valid!");
                }
            }
        });

        frame.setVisible(true);
    }
}
