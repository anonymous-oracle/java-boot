package com.company;

import java.nio.file.Paths;
import java.sql.*;

public class Main {

    public static final String DB_NAME = "test.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + Paths.get("").toAbsolutePath().toString() + "/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            System.out.println("**************TABLE CREATION*****************");
            statement.execute("drop table if exists " + TABLE_CONTACTS);

            statement.execute("create table if not exists " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME + " text, " +
                    COLUMN_PHONE + " integer, " +
                    COLUMN_EMAIL + " text" + ")"
            );

            System.out.println("**************TABLE INSERTION*****************");


            insertContact(statement, "Jiren", 6485689, "jiren@u11.com");

            insertContact(statement, "Broly", 644889, "broly@u7.com");

            insertContact(statement, "Granolah", 5298296, "last_celerian@u7.com");
            insertContact(statement, "Beerus", 777777777, "hakaishin@u7.com");


            System.out.println("**************TABLE UPDATION*****************");

            statement.execute("update " + TABLE_CONTACTS + " set " +
                    COLUMN_PHONE + "=77777" +
                    " where " + COLUMN_NAME + "='Granolah'"
            );

            System.out.println("**************TABLE ROW DELETION*****************");

            statement.execute("delete from " + TABLE_CONTACTS +
                    " where " + COLUMN_NAME + "='Broly'");


            ResultSet results = statement.executeQuery("select * from " + TABLE_CONTACTS);
            while (results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " | " +
                        results.getString(COLUMN_PHONE) + " | " +
                        results.getString(COLUMN_EMAIL)
                );
            }
            results.close(); // close the results so that the association to the statement is closed


            statement.close(); // this is required as well because when the connection to the db closes, the statement object throws a missing db exception
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("insert into " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL + ")" +
                "values('" + name + "', " + phone + ", '" + email + "')"
        );
    }
}
