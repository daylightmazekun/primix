package com.rollmix.mio.gui;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Mio {

    public Mio() {
        initialize();
    }

    private void initialize() {
        JButton mioButton = new RoundButton();
        mioButton.setBackground(Color.green);

        JFrame mioJFrame = new JFrame();
        mioJFream.getContentPane().setBackground(Color.GRAY);
        mioJFream.getContentPane().add(button);

    }

    public static void main(String[] args) {
        System.out.print("He");

    }
}
