package com.tfr.thirstybird;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Created by Erik on 10/19/2017.
 */
public class GUI extends JFrame {

    private ThirstyBird thirstyBird;

    public GUI() {
        initUI();
    }

    private void initUI() {
        thirstyBird = new ThirstyBird();

        setTitle("Thirsty Bird");
        setLocationRelativeTo(null);
        setSize(300,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new GridLayout(1, 2));

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        ActionListener buttonActionListener = new ButtonActionListener();

        startButton.addActionListener(buttonActionListener);
        stopButton.addActionListener(buttonActionListener);

        this.add(startButton);
        this.add(stopButton);

        this.revalidate();
    }

    private class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if(source.getText().equals("Start")) {
                thirstyBird.start();
            } else {
                thirstyBird.stop();
            }
        }
    }
}
