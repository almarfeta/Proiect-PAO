package services;

import domain.Client;
import domain.Persoana;
import persistence.ClientRepository;
import java.util.ArrayList;

public class ClientService {
    private ClientRepository clientRepository = new ClientRepository();

    public void adaugaClient(String nume, String telefon, String parola) {
        Client client = new Client(nume, telefon, parola);
        clientRepository.add(client);
    }
    public ArrayList<Client> afiseazaClienti() {
        return clientRepository.getAll();
    }
    public void modificaClient(int id, String nume, String telefon, String parola) {
        Client client = new Client(id, nume, telefon, parola, 0);
        clientRepository.update(id, client);
    }
    public void modificaNota(int id, double nota) {
        ArrayList<Client> clienti = clientRepository.getAll();
        for (Client client : clienti) {
            if (client.getPersoanaID() == id) {
                Client client_nou = new Client(id, client.getNume(), client.getTelefon(), client.getParola(), nota);
                clientRepository.update(id, client_nou);
                break;
            }
        }
    }
    public void stergeClient(int id) {
        clientRepository.delete(id);
        Persoana.setNrPersoane(Persoana.getNrPersoane() - 1);
    }
    public String[] loginClient(String nume, String parola) {
        ArrayList<Client> clienti = clientRepository.getAll();
        for (Client client : clienti) {
            if (client.getNume().equals(nume) && client.getParola().equals(parola)) {
                return new String[]{"client", String.valueOf(client.getPersoanaID())};
            }
        }
        return new String[]{"nelogat"};
    }
    public int getSize() {
        return clientRepository.getSize();
    }
    public int getID() {
        ArrayList<Client> clienti = clientRepository.getAll();
        int id_max = 0;
        for (Client client : clienti) {
            if (client.getPersoanaID() > id_max) {
                id_max = client.getPersoanaID();
            }
        }
        return id_max;
    }
}
