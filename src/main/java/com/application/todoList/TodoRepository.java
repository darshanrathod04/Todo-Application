package com.application.todoList;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TodoRepository {
    public void searchTodo(String titleFilter) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tododb", "root", "");
            Statement stmt = conn.createStatement();

            // INTENTIONAL VULNERABILITY: Raw input string concatenation (Source to Sink)
            String rawSql = "SELECT * FROM todos WHERE title = '" + titleFilter + "'";
            ResultSet rs = stmt.executeQuery(rawSql);

            while (rs.next()) {
                System.out.println(rs.getString("description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}