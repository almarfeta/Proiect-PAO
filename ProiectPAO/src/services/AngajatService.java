package services;

import domain.Angajat;
import persistence.AngajatRepository;
import java.util.ArrayList;

public class AngajatService {
    private AngajatRepository angajatRepository = new AngajatRepository();

    public void adaugaAngajat(String nume, String telefon, String parola, double salariu, String functie, boolean eAdmin) {
        Angajat angajat = new Angajat(nume, telefon, parola, salariu, functie, eAdmin);
        angajatRepository.add(angajat);
    }
    public ArrayList<Angajat> afiseazaAngajati() {
        ArrayList<Angajat> result = new ArrayList<Angajat>();
        for (int i = 0; i < angajatRepository.getSize(); i++) {
            result.add(angajatRepository.get(i));
        }
        return result;
    }
    public void modificaAngajat(int id, String nume, String telefon, String parola, double salariu, String functie, boolean eAdmin) {
        Angajat angajat = new Angajat(nume, telefon, parola, salariu, functie, eAdmin);
        for (int i = 0; i < angajatRepository.getSize(); i++) {
            if (angajatRepository.get(i).getPersoanaID() == id) {
                angajatRepository.update(i, angajat);
                break;
            }
        }
    }
    public void stergeAngajat(int id) {
        for (int i = 0; i < angajatRepository.getSize(); i++) {
            if (angajatRepository.get(i).getPersoanaID() == id) {
                angajatRepository.delete(i);
                break;
            }
        }
    }
    public String loginAngajat(String nume, String parola) {
        for (int i = 0; i < angajatRepository.getSize(); i++) {
            if (angajatRepository.get(i).getNume().equals(nume) && angajatRepository.get(i).getParola().equals(parola)) {
                if (angajatRepository.get(i).geteAdmin()) {
                    return "admin";
                } else {
                    return "angajat";
                }
            }
        }
        return "nelogat";
    }
}
