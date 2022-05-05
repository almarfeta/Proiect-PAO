package persistence;

import domain.Aliment;
import java.util.ArrayList;

public class AlimentRepository implements GenericRepository<Aliment> {
    ArrayList <Aliment> alimente = new ArrayList<Aliment>();

    @Override
    public void add(Aliment entity) {
        alimente.add(entity);
    }

    @Override
    public Aliment get(int index) {
        return alimente.get(index);
    }

    @Override
    public void update(int index, Aliment entity) {
        alimente.set(index, entity);
    }

    @Override
    public void delete(int index) {
        alimente.remove(index);
    }

    @Override
    public int getSize() {
        return alimente.size();
    }
}
