package persistence;

import domain.Rezervare;
import java.util.ArrayList;

public class RezervareRepository implements GenericRepository<Rezervare> {
    ArrayList<Rezervare> rezervari = new ArrayList<Rezervare>();

    @Override
    public void add(Rezervare entity) {
        rezervari.add(entity);
    }

    @Override
    public Rezervare get(int index) {
        return rezervari.get(index);
    }

    @Override
    public void update(int index, Rezervare entity) {
        rezervari.set(index, entity);
    }

    @Override
    public void delete(int index) {
        rezervari.remove(index);
    }

    @Override
    public int getSize() {
        return rezervari.size();
    }
}
