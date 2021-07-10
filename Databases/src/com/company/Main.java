package com.company;

import java.nio.file.Paths;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
//            DATABASE CONNECTION SETUP
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + Paths.get("").toAbsolutePath().toString() + "/test.db");
//            conn.setAutoCommit(false); // just to manually commit changes and make sure the db behaves as intended

            Statement statement = conn.createStatement();
            statement.execute("create table IF NOT EXISTS " + // if not exists will not create the table if it already exists
                    "contacts(_id INTEGER PRIMARY KEY,name TEXT, phone INTEGER, email TEXT)");


            statement.execute("insert into contacts (name, phone, email)" +
                    "values('Jiren', 6485689, 'jiren@u11.com')");
            statement.execute("insert into contacts (name, phone, email)" +
                    "values('Broly', 644889, 'broly@u7.com')");
            statement.execute("insert into contacts (name, phone, email)" +
                    "values('Beerus', 594985, 'beerus@GOD.com')");
            statement.execute("insert into contacts (name, phone, email)" +
                    "values('Granolah', 5298296, 'last_celerian@u7.com')");


//            statement.execute("update contacts set phone=777777 where name=='beerus'");
//
//            statement.execute("delete from contacts where name='Broly'");

//            statement.execute("select * from contacts"); // these statements actually return results of the query unlike other queries like update, delete, etc
//            ResultSet results = statement.getResultSet(); // this statement should be executed only once per query; the query should be one which returns the query data and not other results like those obtained during delete and update statements

            ResultSet results = statement.executeQuery("select * from contacts");
            while (results.next()) {
                System.out.println(results.getString("name") + "|" +
                        results.getString("phone") + "|" +
                        results.getString("email")
                );
            }
            results.close(); // close the results so that the association to the statement is closed


            //            conn.commit(); // do this by making sure the auto-commit is set to false
            statement.close(); // this is required as well because when the connection to the db closes, the statement object throws a missing db exception
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
