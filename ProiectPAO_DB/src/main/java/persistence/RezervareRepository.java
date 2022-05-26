package persistence;

import domain.Client;
import domain.Restaurant;
import domain.Rezervare;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RezervareRepository extends GenericRepository<Rezervare> {
    public RezervareRepository() {
        super();
    }

    @Override
    public void add(Rezervare entity) {
        String query = String.format("INSERT INTO rezervari VALUES (%d, '%s', '%s', %d, %d);",
                entity.getRezervareID(), entity.getData(), entity.getOra(),
                entity.getRestaurant().getRestaurantID(), entity.getClient().getPersoanaID());
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Rezervare> getAll() {
        ArrayList<Restaurant> restaurante = new ArrayList<>();
        String query1 = "SELECT * FROM restaurante;";
        try {
            getStatement().execute(query1);
            ResultSet resultSet1 = getStatement().getResultSet();
            while (resultSet1.next()) {
                restaurante.add(new Restaurant(resultSet1.getInt(1), resultSet1.getString(2),
                        resultSet1.getString(3), resultSet1.getString(4)));
            }
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
        ArrayList<Client> clienti = new ArrayList<>();
        String query2 = "SELECT * FROM clienti;";
        try {
            getStatement().execute(query2);
            ResultSet resultSet2 = getStatement().getResultSet();
            while (resultSet2.next()) {
                clienti.add(new Client(resultSet2.getInt(1), resultSet2.getString(2),
                        resultSet2.getString(3), resultSet2.getString(4), resultSet2.getDouble(5)));
            }
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }

        ArrayList<Rezervare> rezervari = new ArrayList<>();
        String query = "SELECT * FROM rezervari;";
        try {
            getStatement().execute(query);
            ResultSet resultSet = getStatement().getResultSet();
            while (resultSet.next()) {
                int restaurantID = resultSet.getInt(4);
                int clientID = resultSet.getInt(5);
                Restaurant restaurant = null;
                Client client = null;
                for (Restaurant r : restaurante) {
                    if (r.getRestaurantID() == restaurantID) {
                        restaurant = r;
                    }
                }
                for (Client c : clienti) {
                    if (c.getPersoanaID() == clientID) {
                        client = c;
                    }
                }
                if (restaurant != null && client != null)
                    rezervari.add(new Rezervare(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), restaurant, client));
            }
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
        return rezervari;
    }

    @Override
    public void update(int id, Rezervare entity) {
        String query = String.format("UPDATE rezervari SET data = '%s', ora = '%s', restaurantID = %d, clientID = %d " +
                "WHERE rezervariID = %d;", entity.getData(), entity.getOra(),
                entity.getRestaurant().getRestaurantID(), entity.getClient().getPersoanaID(), id);
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = String.format("DELETE FROM rezervari WHERE rezervariID = %d;", id);
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
        String query = "SELECT COUNT(*) FROM rezervari;";
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
