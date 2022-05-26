package persistence;

import domain.Angajat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AngajatRepository extends GenericRepository<Angajat> {
    public AngajatRepository() {
        super();
    }

    @Override
    public void add(Angajat entity) {
        String query = String.format("INSERT INTO angajati VALUES (%d, '%s', '%s', '%s', %f, '%s', %b);",
                entity.getPersoanaID(), entity.getNume(), entity.getTelefon(), entity.getParola(),
                entity.getSalariu(), entity.getFunctie(), entity.geteAdmin());
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Angajat> getAll() {
        ArrayList<Angajat> angajati = new ArrayList<>();
        String query = "SELECT * FROM angajati;";
        try {
            getStatement().execute(query);
            ResultSet resultSet = getStatement().getResultSet();
            while (resultSet.next()) {
                angajati.add(new Angajat(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getDouble(5),
                        resultSet.getString(6), resultSet.getBoolean(7)));
            }
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
        return angajati;
    }

    @Override
    public void update(int id, Angajat entity) {
        String query = String.format("UPDATE angajati SET nume = '%s', telefon = '%s', parola = '%s', salariu = %f, " +
                "functie = '%s', eAdmin = %b WHERE angajatiID = %d;", entity.getNume(), entity.getTelefon(), entity.getParola(),
                entity.getSalariu(), entity.getFunctie(), entity.geteAdmin(), id);
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = String.format("DELETE FROM angajati WHERE angajatiID = %d;", id);
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
        String query = "SELECT COUNT(*) FROM angajati;";
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
