package me.merhlim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenu {
    JFrame window = new JFrame("Poker");
    Game game = new Game();

    public void run() {
        this.setup();

    }

    public void setup() {
        this.window.setSize(800,800);
        this.window.setLayout(new GridLayout(3,1));
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Poker Game", JLabel.CENTER); // Create title text to be displayed
        title.setFont(new Font("Helvetica", Font.PLAIN, 50)); // Configure its font

        JButton joinGame = new JButton("Join Existing Game"); // Create two buttons to start the game in different ways
        joinGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                joinExistingGame();
            }
        });

        JButton hostGame = new JButton("Host A New Game");
        hostGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                hostNewGame();
            }
        });

        window.getContentPane().add(title); // Add the content to the panel
        window.getContentPane().add(joinGame);
        window.getContentPane().add(hostGame);

        window.setVisible(true); // Set the panel as visible



    }

    public void joinExistingGame() {
        this.window.dispose();
        this.game.runType = "join";
        this.game.initialise();

    }

    public void hostNewGame() {
        this.window.dispose();
        this.game.runType = "host";
        this.game.initialise();



    }
}
