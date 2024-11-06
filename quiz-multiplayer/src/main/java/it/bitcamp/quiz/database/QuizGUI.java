package it.bitcamp.quiz.database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGUI extends JFrame {

    private PlayerDAO playerDAO;
    private QuestionDAO questionDAO;

    public QuizGUI() {
        // Imposta la finestra principale
        setTitle("Quiz Multiplayer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        playerDAO = new PlayerDAO();
        questionDAO = new QuestionDAO();

        // Aggiungi componenti GUI
        JButton addPlayerButton = new JButton("Aggiungi Giocatore");
        JButton viewPlayersButton = new JButton("Visualizza Giocatori");

        add(addPlayerButton);
        add(viewPlayersButton);

        // Azioni dei pulsanti
        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = JOptionPane.showInputDialog("Nome del giocatore:");
                if (playerName != null && !playerName.trim().isEmpty()) {
                    playerDAO.addPlayer(playerName);
                    JOptionPane.showMessageDialog(null, "Giocatore aggiunto!");
                }
            }
        });

        viewPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String players = "";
                for (Player player : playerDAO.getAllPlayers()) {
                    players += player + "\n";
                }
                JOptionPane.showMessageDialog(null, players.isEmpty() ? "Nessun giocatore trovato" : players);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizGUI().setVisible(true);
            }
        });
    }
}

