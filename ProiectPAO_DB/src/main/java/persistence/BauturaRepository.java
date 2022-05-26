package persistence;

import domain.Bautura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BauturaRepository extends GenericRepository<Bautura> {
    public BauturaRepository() {
        super();
    }

    @Override
    public void add(Bautura entity) {
        ArrayList<String> ing = entity.getIngrediente();
        String ingrediente;
        if (ing.size() > 0) {
            ingrediente = ing.get(0);
            for (int i = 1; i < ing.size(); i++) {
                ingrediente = ingrediente + "," + ing.get(i);
            }
        }
        else {
            ingrediente = "";
        }
        String query = String.format("INSERT INTO bauturi VALUES (%d, '%s', %f, '%s', %b);",
                entity.getProdusID(), entity.getDenumire(), entity.getPret(), ingrediente, entity.getAreAlcool());
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Bautura> getAll() {
        ArrayList<Bautura> bauturi = new ArrayList<>();
        String query = "SELECT * FROM bauturi;";
        try {
            getStatement().execute(query);
            ResultSet resultSet = getStatement().getResultSet();
            while (resultSet.next()) {
                String[] ing = resultSet.getString(4).split(",");
                ArrayList<String> ingrediente = new ArrayList<>(List.of(ing));

                bauturi.add(new Bautura(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getDouble(3), ingrediente, resultSet.getBoolean(5)));
            }
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
        return bauturi;
    }

    @Override
    public void update(int id, Bautura entity) {
        ArrayList<String> ing = entity.getIngrediente();
        String ingrediente;
        if (ing.size() > 0) {
            ingrediente = ing.get(0);
            for (int i = 1; i < ing.size(); i++) {
                ingrediente = ingrediente + ", " + ing.get(i);
            }
        }
        else {
            ingrediente = "";
        }
        String query = String.format("UPDATE bauturi SET denumire = '%s', pret = %f, ingrediente = '%s', areAlcool = %b " +
                "WHERE bauturiID = %d;", entity.getDenumire(), entity.getPret(), ingrediente, entity.getAreAlcool(), id);
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            System.out.println("Nu s-a putut executa query-ul");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = String.format("DELETE FROM bauturi WHERE bauturiID = %d;", id);
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
        String query = "SELECT COUNT(*) FROM bauturi;";
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
