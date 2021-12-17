package io;

import org.sqlite.SQLiteDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Accesses and provides trivia data from SQLite
 * Author: Jessie De Jesus
 */

public class Database {
    private static final String MC = "MULTIPLE_CHOICE";
    private static final String TF = "TRUE_FALSE";
    private static final List<Trivia> TRIVIA_LIST = new ArrayList<>();

    /**
     * Constructs a list of Trivia Questions
     * @return List of trivia question in random order
     */
    public static List<Trivia> getQuestionList() {
        if (TRIVIA_LIST.isEmpty()) {
            SQLiteDataSource dataSource = accessDatabase();
            getTriviaFromDatabase(dataSource);
        }
        Collections.shuffle(TRIVIA_LIST); //shuffles order of ArrayList
        return new ArrayList<>(TRIVIA_LIST);
    }

    /**
     * Retrieves the data source in SQLite database containing the trivia
     * @return SQLite datasource
     */
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


    /**
     * Retrieves all trivia questions from SQLite database and adds them to trivia list
     * @param theDatabase SQLite database source
     */
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

    /**
     *
     * @param theSet the result set of the true false query
     * @throws SQLException displayed if error occurs
     */
    private static void addTrueFalseToList(ResultSet theSet) throws SQLException {
        String queryQuestion = "question";
        String queryAnswer = "answer";

        while (theSet.next()) {
            String question = theSet.getString(queryQuestion);
            String answer = theSet.getString(queryAnswer);
            TRIVIA_LIST.add(TriviaFactory.createQuestion(question, answer,null,TF, null));

        }
    }

    /**
     * Adds multiple choice questions from SQLite database to trivia list
     * @param theSet the result set of the multiple choice query
     * @throws SQLException displayed if error occurs
     */
    private static void addMultipleChoiceToList(ResultSet theSet) throws SQLException {
        String queryQuestion = "question";
        String queryAnswer = "answer";
        String queryOptions = "options";
        String queryHint = "hint";

        while(theSet.next()){
            String question = theSet.getString(queryQuestion);
            String answer = theSet.getString(queryAnswer);
            String[] options = splitOptions(theSet.getString( queryOptions));
            String hint = theSet.getString(queryHint);
            TRIVIA_LIST.add(TriviaFactory.createQuestion(question, answer,options,MC, hint));
        }

    }

    /**
     * Removes comma's from multiple choice answers
     * @param theQueryOptions the query string of Answers
     * @return individual array of options
     */
    private static String[] splitOptions(String theQueryOptions) {
        String[] options = theQueryOptions.split(",");
        for (int i = 0; i < options.length; i++) {
            options[i] = options[i].trim();
        }
        return options;
    }


}
