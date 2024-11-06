package it.bitcamp.quiz.database;

import it.bitcamp.quiz.database.PlayerDAO;
import it.bitcamp.quiz.database.QuestionDAO;
import it.bitcamp.quiz.database.Player;
import it.bitcamp.quiz.database.Question;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PlayerDAO playerDAO = new PlayerDAO();
        QuestionDAO questionDAO = new QuestionDAO();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Quiz Multiplayer - Menu ---");
            System.out.println("1. Aggiungi nuovo giocatore");
            System.out.println("2. Visualizza giocatore per ID");
            System.out.println("3. Aggiorna punteggio giocatore");
            System.out.println("4. Elimina giocatore");
            System.out.println("5. Visualizza tutti i giocatori");
            System.out.println("6. Aggiungi nuova domanda");
            System.out.println("7. Visualizza domanda per ID");
            System.out.println("8. Aggiorna domanda");
            System.out.println("9. Elimina domanda");
            System.out.println("10. Visualizza tutte le domande");
            System.out.println("0. Esci");
            System.out.print("Seleziona un'opzione: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consuma il newline

            switch (choice) {
            case 1:
                System.out.print("Nome del giocatore: ");
                String name = scanner.nextLine();
                playerDAO.addPlayer(name);
                break;
            case 2:
                System.out.print("ID del giocatore: ");
                int id = scanner.nextInt();
                Player player = playerDAO.getPlayerById(id);
                System.out.println(player != null ? player : "Giocatore non trovato.");
                break;
            case 3:
                System.out.print("ID del giocatore: ");
                int idToUpdate = scanner.nextInt();
                System.out.print("Nuovo punteggio: ");
                int newScore = scanner.nextInt();
                playerDAO.updatePlayerScore(idToUpdate, newScore);
                break;
            case 4:
                System.out.print("ID del giocatore da eliminare: ");
                int idToDelete = scanner.nextInt();
                playerDAO.deletePlayer(idToDelete);
                break;
            case 5:
                List<Player> players = playerDAO.getAllPlayers();
                players.forEach(System.out::println);
                break;
            case 6:
                System.out.print("Testo della domanda: ");
                String questionText = scanner.nextLine();
                System.out.print("Opzione A: ");
                String optionA = scanner.nextLine();
                System.out.print("Opzione B: ");
                String optionB = scanner.nextLine();
                System.out.print("Opzione C: ");
                String optionC = scanner.nextLine();
                System.out.print("Opzione D: ");
                String optionD = scanner.nextLine();
                System.out.print("Risposta corretta (A/B/C/D): ");
                String correctOption = scanner.nextLine();
                questionDAO.addQuestion(questionText, optionA, optionB, optionC, optionD, correctOption);
                break;
            case 7:
                System.out.print("ID della domanda: ");
                int questionId = scanner.nextInt();
                Question question = questionDAO.getQuestionById(questionId);
                System.out.println(question != null ? question : "Domanda non trovata.");
                break;
            case 8:
                System.out.print("ID della domanda da aggiornare: ");
                int questionIdToUpdate = scanner.nextInt();
                scanner.nextLine(); // Consuma il newline
                System.out.print("Nuovo testo della domanda: ");
                String updatedQuestionText = scanner.nextLine();
                System.out.print("Nuova opzione A: ");
                String updatedOptionA = scanner.nextLine();
                System.out.print("Nuova opzione B: ");
                String updatedOptionB = scanner.nextLine();
                System.out.print("Nuova opzione C: ");
                String updatedOptionC = scanner.nextLine();
                System.out.print("Nuova opzione D: ");
                String updatedOptionD = scanner.nextLine();
                System.out.print("Nuova risposta corretta (A/B/C/D): ");
                String updatedCorrectOption = scanner.nextLine();
                questionDAO.updateQuestion(questionIdToUpdate, updatedQuestionText, updatedOptionA, updatedOptionB, updatedOptionC, updatedOptionD, updatedCorrectOption);
                break;
            case 9:
                System.out.print("ID della domanda da eliminare: ");
                int questionIdToDelete = scanner.nextInt();
                questionDAO.deleteQuestion(questionIdToDelete);
                break;
            case 10:
                List<Question> questions = questionDAO.getAllQuestions();
                questions.forEach(System.out::println);
                break;
            case 0:
                System.out.println("Uscita...");
                break;
            default:
                System.out.println("Opzione non valida. Riprova.");
        }
        } while (choice != 0);

        scanner.close();
    }
}
