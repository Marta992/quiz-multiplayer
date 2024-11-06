package it.bitcamp.quiz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/quiz_multiplayer";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";

    // Metodo per ottenere la connessione
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Metodo per chiudere la connessione
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // operazioni crud Inserire (Create, Read, Update, Delete)
   // nuovi giocatori nella tabella players,Caricare domande dalla tabella questions, Salvare e aggiornare punteggi nella tabella scores
}