package domain;

public class Rezervare {
    private static int NrRezervari = 0;

    private int RezervareID;
    private String Data;
    private String Ora;
    private Restaurant Restaurant;
    private Client Client;

    public Rezervare() {
        RezervareID = ++NrRezervari;
        Data = "Lipsa data";
        Ora = "Lipsa ora";
    }
    public Rezervare(String data, String ora, Restaurant restaurant, Client client) {
        RezervareID = ++NrRezervari;
        Data = data;
        Ora = ora;
        Restaurant = restaurant;
        Client = client;
    }
    public Rezervare(Rezervare r) {
        RezervareID = ++NrRezervari;
        Data = r.Data;
        Ora = r.Ora;
        Restaurant = r.Restaurant;
        Client = r.Client;
    }

    @Override
    public String toString() {
        return "RezervareID: " + RezervareID +
                "\nData: " + Data +
                "\nOra: " + Ora +
                "\nRestaurant: " + Restaurant +
                "\nClient: " + Client +
                "\n";
    }

    public int getRezervareID() {
        return RezervareID;
    }
    public void setRezervareID(int rezervareID) {
        RezervareID = rezervareID;
    }
    public String getData() {
        return Data;
    }
    public void setData(String data) {
        Data = data;
    }
    public String getOra() {
        return Ora;
    }
    public void setOra(String ora) {
        Ora = ora;
    }
    public Restaurant getRestaurant() {
        return Restaurant;
    }
    public void setRestaurant(Restaurant restaurant) {
        Restaurant = restaurant;
    }
    public Client getClient() {
        return Client;
    }
    public void setClient(Client client) {
        Client = client;
    }
}

