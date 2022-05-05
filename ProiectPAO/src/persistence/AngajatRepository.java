package persistence;

import domain.Angajat;
import java.util.ArrayList;

public class AngajatRepository implements GenericRepository<Angajat>{
    private ArrayList<Angajat> angajati = new ArrayList<Angajat>();

    @Override
    public void add(Angajat entity) {
        angajati.add(entity);
    }

    @Override
    public Angajat get(int index) {
        return angajati.get(index);
    }

    @Override
    public void update(int index, Angajat entity) {
        angajati.set(index, entity);
    }

    @Override
    public void delete(int index) {
        angajati.remove(index);
    }

    @Override
    public int getSize() {
        return angajati.size();
    }
}
