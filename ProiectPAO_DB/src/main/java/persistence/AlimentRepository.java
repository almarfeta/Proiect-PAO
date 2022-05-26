package persistence;

import domain.Aliment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlimentRepository extends GenericRepository<Aliment> {
    public AlimentRepository() {
        super();
    }

    @Override
    public void add(Aliment entity) {
        String query = String.format("INSERT INTO alimente VALUES (%d, '%s', %f, '%s', '%s');",
                entity.getProdusID(), entity.getDenumire(), entity.getPret(), entity.getDescriere(), entity.getCategorie());
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Aliment> getAll() {
        ArrayList<Aliment> alimente = new ArrayList<>();
        String query = "SELECT * FROM alimente;";
        try {
            getStatement().execute(query);
            ResultSet resultSet = getStatement().getResultSet();
            while (resultSet.next()) {
                alimente.add(new Aliment(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getDouble(3), resultSet.getString(4), resultSet.getString(5)));
            }
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
        return alimente;
    }

    @Override
    public void update(int id, Aliment entity) {
        String query = String.format("UPDATE alimente SET denumire = '%s', pret = %f, descriere = '%s', categorie = '%s' " +
                "WHERE alimenteID = %d;", entity.getDenumire(), entity.getPret(), entity.getDescriere(), entity.getCategorie(), id);
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = String.format("DELETE FROM alimente WHERE alimenteID = %d;", id);
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
        String query = "SELECT COUNT(*) FROM alimente;";
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
