package persistence;

import domain.Client;
import java.util.ArrayList;

public class ClientRepository implements GenericRepository<Client> {
    private ArrayList<Client> clienti = new ArrayList<Client>();

    @Override
    public void add(Client entity) {
        clienti.add(entity);
    }

    @Override
    public Client get(int index) {
        return clienti.get(index);
    }

    @Override
    public void update(int index, Client entity) {
        clienti.set(index, entity);
    }

    @Override
    public void delete(int index) {
        clienti.remove(index);
    }

    @Override
    public int getSize() {
        return clienti.size();
    }
}
