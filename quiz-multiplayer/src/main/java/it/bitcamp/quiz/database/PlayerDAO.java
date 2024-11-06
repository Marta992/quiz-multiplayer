package it.bitcamp.quiz.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {

    // Metodo per aggiungere un nuovo giocatore
    public void addPlayer(String name) {
        String query = "INSERT INTO players (name, total_score) VALUES (?, 0)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            System.out.println("Giocatore aggiunto con successo!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo per ottenere un giocatore in base al suo ID
    public Player getPlayerById(int id) {
        String query = "SELECT * FROM players WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Player(rs.getInt("id"), rs.getString("name"), rs.getInt("total_score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metodo per aggiornare il punteggio di un giocatore
    public void updatePlayerScore(int playerId, int newScore) {
        String query = "UPDATE players SET total_score = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, newScore);
            stmt.setInt(2, playerId);
            stmt.executeUpdate();
            System.out.println("Punteggio aggiornato con successo!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo per eliminare un giocatore
    public void deletePlayer(int id) {
        String query = "DELETE FROM players WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Giocatore eliminato con successo!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo per ottenere tutti i giocatori
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM players";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                players.add(new Player(rs.getInt("id"), rs.getString("name"), rs.getInt("total_score")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }
}
