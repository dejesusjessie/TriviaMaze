package io;


import org.sqlite.SQLiteDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database {
    private static final String MC = "MULTIPLE_CHOICE";
    private static final String TF = "TRUE_FALSE";
    private static final List<Trivia> TRIVIA_LIST = new ArrayList<>();

    public static List<Trivia> getQuestionList() {
        if (TRIVIA_LIST.isEmpty()) {
            SQLiteDataSource dataSource = accessDatabase();
            getTriviaFromDatabase(dataSource);
        }
        Collections.shuffle(TRIVIA_LIST); //shuffles order of ArrayList
        return TRIVIA_LIST;
    }

    //access SQLite database
    private static SQLiteDataSource accessDatabase() {
        SQLiteDataSource database = null;
        try {
            database = new SQLiteDataSource();
            database.setUrl("jdbc:sqlite:trivia.db");
            //System.out.println("Database connection successful");
        } catch (final Exception ex) {
            System.out.println("Error: unable to connect to specific database");
            System.exit(1);
        }
        return database;
    }

    private static void getTriviaFromDatabase(SQLiteDataSource theDatabase) {
        ResultSet rs;
        try (Connection conn = theDatabase.getConnection();
             Statement stmt = conn.createStatement())  {

            String query = "SELECT * FROM ";
            rs = stmt.executeQuery(query + MC);
            addMultipleChoiceToList(rs);
            rs = stmt.executeQuery(query + TF);
            addTrueFalseToList(rs);

        } catch (SQLException ex) {
            System.out.println("Error: unable to retrieve contents from specific table");
            System.exit(1);
        }
    }

    private static void addTrueFalseToList(ResultSet theSet) throws SQLException {
        String queryQuestion = "question";
        String queryAnswer = "answer";

        while (theSet.next()) {
            String question = theSet.getString(queryQuestion);
            String answer = theSet.getString(queryAnswer);
            TRIVIA_LIST.add(Trivia.createQuestion(question, answer,null,TF));

        }
    }

    private static void addMultipleChoiceToList(ResultSet theSet) throws SQLException {
        String queryQuestion = "question";
        String queryAnswer = "answer";
        String queryOptions = "options";

        while(theSet.next()){
            String question = theSet.getString(queryQuestion);
            String answer = theSet.getString(queryAnswer);
            String[] options = splitOptions(theSet.getString( queryOptions));
            TRIVIA_LIST.add(Trivia.createQuestion(question, answer,options,MC));
        }

    }

    private static String[] splitOptions(String theQueryOptions) {
        String[] options = theQueryOptions.split(",");
        for (int i = 0; i < options.length; i++) {
            options[i] = options[i].trim();
        }
        return options;
    }


}
