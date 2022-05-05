package persistence;

import domain.Bautura;
import java.util.ArrayList;

public class BauturaRepository implements GenericRepository<Bautura>{
    ArrayList<Bautura> bauturi = new ArrayList<Bautura>();

    @Override
    public void add(Bautura entity) {
        bauturi.add(entity);
    }

    @Override
    public Bautura get(int index) {
        return bauturi.get(index);
    }

    @Override
    public void update(int index, Bautura entity) {
        bauturi.set(index, entity);
    }

    @Override
    public void delete(int index) {
        bauturi.remove(index);
    }

    @Override
    public int getSize() {
        return bauturi.size();
    }
}
