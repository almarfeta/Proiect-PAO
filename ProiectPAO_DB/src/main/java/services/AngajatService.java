package services;

import domain.Angajat;
import domain.Persoana;
import persistence.AngajatRepository;
import java.util.ArrayList;

public class AngajatService {
    private AngajatRepository angajatRepository = new AngajatRepository();

    public void adaugaAngajat(String nume, String telefon, String parola, double salariu, String functie, boolean eAdmin) {
        Angajat angajat = new Angajat(nume, telefon, parola, salariu, functie, eAdmin);
        angajatRepository.add(angajat);
    }
    public ArrayList<Angajat> afiseazaAngajati() {
        return angajatRepository.getAll();
    }
    public void modificaAngajat(int id, String nume, String telefon, String parola, double salariu, String functie, boolean eAdmin) {
        Angajat angajat = new Angajat(id, nume, telefon, parola, salariu, functie, eAdmin);
        angajatRepository.update(id, angajat);
    }
    public void stergeAngajat(int id) {
        angajatRepository.delete(id);
        Persoana.setNrPersoane(Persoana.getNrPersoane() - 1);
    }
    public String[] loginAngajat(String nume, String parola) {
        ArrayList<Angajat> angajati = angajatRepository.getAll();
        for (Angajat angajat : angajati) {
            if (angajat.getNume().equals(nume) && angajat.getParola().equals(parola)) {
                if (angajat.geteAdmin()) {
                    return new String[]{"admin", String.valueOf(angajat.getPersoanaID())};
                }
                else {
                    return new String[]{"angajat", String.valueOf(angajat.getPersoanaID())};
                }
            }
        }
        return new String[]{"nelogat"};
    }
    public int getSize() {
        return angajatRepository.getSize();
    }
    public int getID() {
        ArrayList<Angajat> angajati = angajatRepository.getAll();
        int id_max = 0;
        for (Angajat angajat : angajati) {
            if (angajat.getPersoanaID() > id_max) {
                id_max = angajat.getPersoanaID();
            }
        }
        return id_max;
    }
}
