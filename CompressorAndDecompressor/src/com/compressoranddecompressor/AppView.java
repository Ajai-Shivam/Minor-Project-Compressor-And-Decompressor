package com.compressoranddecompressor;

import com.compressoranddecompressor.Model.Compressor;
import com.compressoranddecompressor.Model.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class AppView extends JFrame {
    private JPanel panel;
    private JLabel title;
    private JButton compressorButton;
    private JButton deCompressorButton;
    private JPanel Content;

    AppView() {
        this.setTitle("COMPRESSOR AND DECOMPRESSOR");
        this.setVisible(true);
        this.setContentPane(this.panel);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        compressorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser jFileChooser = new JFileChooser();
                int response = jFileChooser.showSaveDialog(null);
                if(response == JFileChooser.APPROVE_OPTION){
                    File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());
                    try {
                        Compressor.compressOperation(file);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null,e.toString());                }
                }
            }
        });
        deCompressorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser jFileChooser = new JFileChooser();
                int response = jFileChooser.showSaveDialog(null);
                if(response == JFileChooser.APPROVE_OPTION){
                    File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());
                    try {
                        Decompressor.decompressionOperation(file);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null,e.toString());
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        AppView ap = new AppView();
    }

}
