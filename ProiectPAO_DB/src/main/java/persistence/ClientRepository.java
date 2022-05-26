package persistence;

import domain.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientRepository extends GenericRepository<Client> {
    public ClientRepository() {
        super();
    }

    @Override
    public void add(Client entity) {
        String query = String.format("INSERT INTO clienti VALUES (%d, '%s', '%s', '%s', %f);",
                entity.getPersoanaID(), entity.getNume(), entity.getTelefon(), entity.getParola(), entity.getNota());
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Client> getAll() {
        ArrayList<Client> clienti = new ArrayList<>();
        String query = "SELECT * FROM clienti;";
        try {
            getStatement().execute(query);
            ResultSet resultSet = getStatement().getResultSet();
            while (resultSet.next()) {
                clienti.add(new Client(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getDouble(5)));
            }
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
        return clienti;
    }

    @Override
    public void update(int id, Client entity) {
        String query = String.format("UPDATE clienti SET nume = '%s', telefon = '%s', parola = '%s', nota = %f " +
                "WHERE clientiID = %d;", entity.getNume(), entity.getTelefon(), entity.getParola(), entity.getNota(), id);
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = String.format("DELETE FROM clienti WHERE clientiID = %d;", id);
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
        String query = "SELECT COUNT(*) FROM clienti;";
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
