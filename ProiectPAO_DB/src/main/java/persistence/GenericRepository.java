package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class GenericRepository<T> {
    private Connection connection;
    private Statement statement;

    public GenericRepository() {
        String url = "jdbc:mysql://localhost:3306/restaurante-pao";
        String user = "root";
        String pass = "SQL-root57";

        try {
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza conexiunea cu baza de date");
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public abstract void add(T entity);

    public abstract ArrayList<T> getAll();

    public abstract void update(int id, T entity);

    public abstract void delete(int id);

    public abstract int getSize();

}
