package persistence;

import domain.Restaurant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RestaurantRepository extends GenericRepository<Restaurant> {
    public RestaurantRepository() {
        super();
    }

    @Override
    public void add(Restaurant entity) {
        String query = String.format("INSERT INTO restaurante VALUES (%d, '%s', '%s', '%s');",
                entity.getRestaurantID(), entity.getStrada(), entity.getNumar(), entity.getOras());
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Restaurant> getAll() {
        ArrayList<Restaurant> restaurante = new ArrayList<>();
        String query = "SELECT * FROM restaurante;";
        try {
            getStatement().execute(query);
            ResultSet resultSet = getStatement().getResultSet();
            while (resultSet.next()) {
                restaurante.add(new Restaurant(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
        return restaurante;
    }

    @Override
    public void update(int id, Restaurant entity) {
        String query = String.format("UPDATE restaurante SET strada = '%s', numar = '%s', oras = '%s' " +
                "WHERE restauranteID = %d;", entity.getStrada(), entity.getNumar(), entity.getOras(), id);
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = String.format("DELETE FROM restaurante WHERE restauranteID = %d;", id);
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
    }

    @Override
    public int getSize() {
        int size = 0;
        String query = "SELECT COUNT(*) FROM restaurante;";
        try {
            getStatement().execute(query);
            ResultSet resultSet = getStatement().getResultSet();
            resultSet.next();
            size = resultSet.getInt(1);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
        return size;
    }
}
