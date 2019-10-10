package me.merhlim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class Sui extends Thread {
    BlockingQueue queue;
    JFrame window = new JFrame("Poker");

    public Sui(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            if(this.queue.take().equals("Sconn")){
                System.out.println("UI Blocking Queue Connection Established");

            }
            this.queue.put("Cconn");

            this.window.setSize(800,800);
            this.window.setLayout(new GridLayout(3,1));
            this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel title = new JLabel("Waiting for clients",JLabel.CENTER);
            title.setFont(new Font("Helvetica",Font.BOLD,30));

            int numberOfConnections = 0;

            JLabel connections = new JLabel(numberOfConnections+"/4",JLabel.CENTER);
            connections.setFont(new Font("Helvetica",Font.PLAIN,20));

            JLabel hNameDisplay = new JLabel("Getting hostname",JLabel.CENTER);
            hNameDisplay.setFont(new Font("Helvetica",Font.PLAIN,20));

            JButton startButton = new JButton("Start Game");

            this.window.getContentPane().add(title);
            this.window.getContentPane().add(connections);
            this.window.getContentPane().add(hNameDisplay);
            this.window.getContentPane().add(startButton);

            this.window.setVisible(true);

            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("Test");
                }
            });

            while (numberOfConnections < 3) {
                connections.setText(numberOfConnections+"/4");
                System.out.println("Hi");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }


    }
}
