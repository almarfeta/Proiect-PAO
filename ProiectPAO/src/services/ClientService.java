package services;

import domain.Client;
import persistence.ClientRepository;
import java.util.ArrayList;

public class ClientService {
    private ClientRepository clientRepository = new ClientRepository();

    public void adaugaClient(String nume, String telefon, String parola) {
        Client client = new Client(nume, telefon, parola);
        clientRepository.add(client);
    }
    public ArrayList<Client> afiseazaClienti() {
        ArrayList<Client> result = new ArrayList<Client>();
        for (int i = 0; i < clientRepository.getSize(); i++) {
            result.add(clientRepository.get(i));
        }
        return result;
    }
    public void modificaClient(int id, String nume, String telefon, String parola) {
        Client client = new Client(nume, telefon, parola);
        for (int i = 0; i < clientRepository.getSize(); i++) {
            if (clientRepository.get(i).getPersoanaID() == id) {
                clientRepository.update(i, client);
                break;
            }
        }
    }
    public void modificaNota(int id, double nota) {
        for (int i = 0; i < clientRepository.getSize(); i++) {
            if (clientRepository.get(i).getPersoanaID() == id) {
                clientRepository.get(i).setNota(nota);
                break;
            }
        }
    }
    public void stergeClient(int id) {
        for (int i = 0; i < clientRepository.getSize(); i++) {
            if (clientRepository.get(i).getPersoanaID() == id) {
                clientRepository.delete(i);
                break;
            }
        }
    }
    public String loginClient(String nume, String parola) {
        for (int i = 0; i < clientRepository.getSize(); i++) {
            if (clientRepository.get(i).getNume().equals(nume) && clientRepository.get(i).getParola().equals(parola)) {
                return "client";
            }
        }
        return "nelogat";
    }
}
