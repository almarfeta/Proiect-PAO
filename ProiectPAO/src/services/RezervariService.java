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
        ArrayList<Rezervare> result = new ArrayList<Rezervare>();
        for (int i = 0; i < rezervareRepository.getSize(); i++) {
            result.add(rezervareRepository.get(i));
        }
        return result;
    }
    public ArrayList<Rezervare> afiseazaRezervariDupaClient(int id) {
        ArrayList<Rezervare> result = new ArrayList<Rezervare>();
        for (int i = 0; i < rezervareRepository.getSize(); i++) {
            if (rezervareRepository.get(i).getClient().getPersoanaID() == id) {
                result.add(rezervareRepository.get(i));
            }
        }
        return result;
    }
    public void modificaRezervare(int id, String data, String ora, Restaurant restaurant, Client client) {
        Rezervare rezervare = new Rezervare(data, ora, restaurant, client);
        for (int i = 0; i < rezervareRepository.getSize(); i++) {
            if (rezervareRepository.get(i).getRezervareID() == id) {
                rezervareRepository.update(i, rezervare);
                break;
            }
        }
    }
    public void stergeRezervare(int id) {
        for (int i = 0; i < rezervareRepository.getSize(); i++) {
            if (rezervareRepository.get(i).getRezervareID() == id) {
                rezervareRepository.delete(i);
                break;
            }
        }
    }
}
