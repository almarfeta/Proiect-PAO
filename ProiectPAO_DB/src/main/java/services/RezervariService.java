package services;

import domain.Client;
import domain.Restaurant;
import domain.Rezervare;
import persistence.RezervareRepository;
import java.util.ArrayList;

public class RezervariService {
    private RezervareRepository rezervareRepository = new RezervareRepository();

    public void adaugaRezervare(String data, String ora, Restaurant restaurant, Client client) {
        Rezervare rezervare = new Rezervare(data, ora, restaurant, client);
        rezervareRepository.add(rezervare);
    }
    public ArrayList<Rezervare> afiseazaRezervari() {
        return rezervareRepository.getAll();
    }
    public ArrayList<Rezervare> afiseazaRezervariDupaClient(int id) {
        ArrayList<Rezervare> result = new ArrayList<>();
        ArrayList<Rezervare> rezervari = rezervareRepository.getAll();
        for (Rezervare rezervare : rezervari) {
            if (rezervare.getClient().getPersoanaID() == id) {
                result.add(rezervare);
            }
        }
        return result;
    }
    public void modificaRezervare(int id, String data, String ora, Restaurant restaurant, Client client) {
        Rezervare rezervare = new Rezervare(id, data, ora, restaurant, client);
        rezervareRepository.update(id, rezervare);
    }
    public void stergeRezervare(int id) {
        rezervareRepository.delete(id);
        Rezervare.setNrRezervari(Rezervare.getNrRezervari() - 1);
    }
    public int getSize() {
        return rezervareRepository.getSize();
    }
    public int getID() {
        ArrayList<Rezervare> rezervari = rezervareRepository.getAll();
        int id_max = 0;
        for (Rezervare rezervare : rezervari) {
            if (rezervare.getRezervareID() > id_max) {
                id_max = rezervare.getRezervareID();
            }
        }
        return id_max;
    }
}
