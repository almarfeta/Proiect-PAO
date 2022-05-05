package view;

import domain.*;
import services.*;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private Scanner input;
    private AngajatService angajatService;
    private ClientService clientService;
    private ProduseService produseService;
    private RestauranteService restauranteService;
    private RezervariService rezervariService;
    private IOsingleton ioSingleton;

    public View() {
        input = new Scanner(System.in);
        angajatService = new AngajatService();
        clientService = new ClientService();
        produseService = new ProduseService();
        restauranteService = new RestauranteService();
        rezervariService = new RezervariService();
        ioSingleton = IOsingleton.getInstance();
    }

    private void afiseazaFunctii(String rol) {
        System.out.println("Apasati cifra corespunzatoare comenzii:\n");
        if (rol.equals("nelogat")) {
            System.out.println(
                    "1) Register client\n" +
                    "2) Login client\n" +
                    "3) Login angajat\n" +
                    "4) Afiseaza produse\n" +
                    "5) Afiseaza restaurante\n" +
                    "6) Inchide aplicatia\n" +
                    "Pentru mai multe comenzi logheaza-te\n" +
                    "-----------------------------------------"
            );
        }
        else if (rol.equals("client")) {
            System.out.println("Comenzi CLIENT:\n" +
                    "1) Afiseaza produse\n" +
                    "2) Afiseaza restaurante\n" +
                    "3) Afiseaza rezervarile tale\n" +
                    "4) Adauga rezervare\n" +
                    "5) Modifica date despre rezervarile tale\n" +
                    "6) Sterge contul\n" +
                    "7) Sterge rezervare\n" +
                    "8) Inchide aplicatia\n" +
                    "------------------------------------------"
            );
        }
        else if (rol.equals("angajat")) {
            System.out.println("Comenzi ANGAJAT:\n" +
                    "1) Afiseaza produse\n" +
                            "2) Afiseaza clienti\n" +
                            "3) Afiseaza restaurante\n" +
                            "4) Afiseaza rezervari\n" +
                            "5) Adauga client\n" +
                            "6) Adauga produse\n" +
                            "7) Adauga rezervare\n" +
                            "8) Modifica produse\n" +
                            "9) Modifica rezervari\n" +
                            "10) Modifica nota client\n" +
                            "11) Sterge produs\n" +
                            "12) Sterge rezervare\n" +
                            "13) Inchide aplicatia\n" +
                            "------------------------------------------"
            );
        }
        else {//if (rol.equals("admin"))
            System.out.println("Comenzi ADMIN:\n" +
                    "1) Afiseaza clienti\n" +
                    "2) Afiseaza restaurante\n" +
                    "3) Afiseaza rezervari\n" +
                    "4) Afiseaza angajati\n" +
                    "5) Afiseaza produse\n" +
                    "6) Adauga client\n" +
                    "7) Adauga produse\n" +
                    "8) Adauga rezervare\n" +
                    "9) Adauga angajat\n" +
                    "10) Adauga restaurant\n" +
                    "11) Modifica angajat\n" +
                    "12) Modifica produse\n" +
                    "13) Modifica rezervari\n" +
                    "14) Modifica clienti\n" +
                    "15) Modifica restaurant\n" +
                    "16) Sterge produs\n" +
                    "17) Sterge rezervare\n" +
                    "18) Sterge angajat\n" +
                    "19) Sterge client\n" +
                    "20) Sterge restaurant\n" +
                    "21) Inchide aplicatia\n" +
                    "------------------------------------------"
            );
        }
    }

    private void afiseazaProduse() {
        ArrayList<Produs> produse = produseService.afiseazaProduse();
        for (Produs produs : produse) {
            System.out.println(produs);
        }
        ioSingleton.write("afiseazaProduse");
    }
    private void afiseazaClienti() {
        ArrayList<Client> clienti = clientService.afiseazaClienti();
        for (Client client : clienti) {
            System.out.println(client);
        }
        ioSingleton.write("afiseazaClienti");
    }
    private void afiseazaAngajati() {
        ArrayList<Angajat> angajati = angajatService.afiseazaAngajati();
        for (Angajat angajat : angajati) {
            System.out.println(angajat);
        }
        ioSingleton.write("afiseazaAngajati");
    }
    private void afiseazaRestaurante() {
        ArrayList<Restaurant> restaurante = restauranteService.afiseazaRestaurante();
        for (Restaurant restaurant : restaurante) {
            System.out.println(restaurant);
        }
        ioSingleton.write("afiseazaRestaurante");
    }
    private void afiseazaRezervari() {
        ArrayList<Rezervare> rezervari = rezervariService.afiseazaRezervari();
        for (Rezervare rezervare : rezervari) {
            System.out.println(rezervare);
        }
        ioSingleton.write("afiseazaRezervari");
    }

    private void adaugaClient() {
        System.out.println("Nume = ");
        String nume = input.nextLine();
        System.out.println("Telefon = ");
        String telefon = input.nextLine();
        System.out.println("Parola = ");
        String parola = input.nextLine();

        clientService.adaugaClient(nume, telefon, parola);
        ioSingleton.write("adaugaClient");
    }
    private void adaguaAngajat() {
        System.out.println("Nume = ");
        String nume = input.nextLine();
        System.out.println("Telefon = ");
        String telefon = input.nextLine();
        System.out.println("Parola = ");
        String parola = input.nextLine();
        System.out.println("Salariu = ");
        double salariu = Double.parseDouble(input.nextLine());
        System.out.println("Functie = ");
        String functie = input.nextLine();
        System.out.println("Este admin? (y/n)");
        boolean eAdmin = input.nextLine().toLowerCase().equals("y");

        angajatService.adaugaAngajat(nume, telefon, parola, salariu, functie, eAdmin);
        ioSingleton.write("adaguaAngajat");
    }
    private void adaugaProdus() {
        System.out.println("Aliment(1) sau bautura(2)? (tastati cifra corespunzatoare) = ");
        int alegere = Integer.parseInt(input.nextLine());
        if (alegere == 1) {
            System.out.println("Denumire = ");
            String denumire = input.nextLine();
            System.out.println("Pret = ");
            double pret = Double.parseDouble(input.nextLine());
            System.out.println("Descriere = ");
            String descriere = input.nextLine();
            System.out.println("Categorie = ");
            String categorie = input.nextLine();

            produseService.adaugaAliment(denumire, pret, descriere, categorie);
            ioSingleton.write("adaugaAliment");
        }
        else if (alegere == 2) {
            System.out.println("Denumire = ");
            String denumire = input.nextLine();
            System.out.println("Pret = ");
            double pret = Double.parseDouble(input.nextLine());
            System.out.println("Numar ingrediente = ");
            int nr = Integer.parseInt(input.nextLine());
            System.out.println("Ingregiente = ");
            ArrayList<String> ingrediente = new ArrayList<String>();
            for (int i = 0; i < nr; i++) {
                ingrediente.add(input.nextLine());
            }
            System.out.println("Are alcool? (Y/N)");
            String raspuns = input.nextLine();
            boolean areAlcool = raspuns.toLowerCase().equals("y");

            produseService.adaugaBautura(denumire, pret, ingrediente, areAlcool);
            ioSingleton.write("adaugaBautura");
        }
        else {
            System.out.println("Nu s-a putut adauga produsul");
        }
    }
    private void adaugaRestaurant() {
        System.out.println("Strada = ");
        String strada = input.nextLine();
        System.out.println("Numar = ");
        String numar = input.nextLine();
        System.out.println("Oras = ");
        String oras = input.nextLine();

        restauranteService.adaugaRestaurant(strada, numar, oras);
        ioSingleton.write("adaugaRestaurant");
    }
    private void adaugaRezervare() {
        System.out.println("Data = ");
        String data = input.nextLine();
        System.out.println("Ora = ");
        String ora = input.nextLine();
        System.out.println("Restaurant ID = ");
        int id_r = Integer.parseInt(input.nextLine());
        Restaurant restaurant = new Restaurant();
        boolean ok1 = false;
        for (Restaurant r : restauranteService.afiseazaRestaurante()) {
            if (r.getRestaurantID() == id_r) {
                restaurant = r;
                ok1 = true;
                break;
            }
        }
        System.out.println("Client ID = ");
        int id_c = Integer.parseInt(input.nextLine());
        Client client = new Client();
        boolean ok2 = false;
        for (Client c : clientService.afiseazaClienti()) {
            if (c.getPersoanaID() == id_c) {
                client = c;
                ok2 = true;
                break;
            }
        }
        if (ok1 && ok2) {
            rezervariService.adaugaRezervare(data, ora, restaurant, client);
            ioSingleton.write("adaugaRezervare");
        }
        else {
            System.out.println("Nu s-a putut face rezervarea");
        }
    }

    private void modificaClient() {
        System.out.println("ID client = ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Nume = ");
        String nume = input.nextLine();
        System.out.println("Telefon = ");
        String telefon = input.nextLine();
        System.out.println("Parola = ");
        String parola = input.nextLine();

        clientService.modificaClient(id, nume, telefon, parola);
        ioSingleton.write("modificaClient");
    }
    private void modificaAngajat() {
        System.out.println("ID Angajat = ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Nume = ");
        String nume = input.nextLine();
        System.out.println("Telefon = ");
        String telefon = input.nextLine();
        System.out.println("Parola = ");
        String parola = input.nextLine();
        System.out.println("Salariu = ");
        double salariu = Double.parseDouble(input.nextLine());
        System.out.println("Functie = ");
        String functie = input.nextLine();
        System.out.println("Este admin? (y/n)");
        boolean eAdmin = input.nextLine().toLowerCase().equals("y");

        angajatService.modificaAngajat(id, nume, telefon, parola, salariu, functie, eAdmin);
        ioSingleton.write("modificaAngajat");
    }
    private void modificaProdus() {
        System.out.println("Aliment(1) sau bautura(2)? (tastati cifra corespunzatoare) = ");
        int alegere = Integer.parseInt(input.nextLine());
        if (alegere == 1) {
            System.out.println("ID aliment = ");
            int id = Integer.parseInt(input.nextLine());
            System.out.println("Denumire = ");
            String denumire = input.nextLine();
            System.out.println("Pret = ");
            double pret = Double.parseDouble(input.nextLine());
            System.out.println("Descriere = ");
            String descriere = input.nextLine();
            System.out.println("Categorie = ");
            String categorie = input.nextLine();

            produseService.modificaAliment(id, denumire, pret, descriere, categorie);
            ioSingleton.write("modificaAliment");
        }
        else if (alegere == 2) {
            System.out.println("ID bautura = ");
            int id = Integer.parseInt(input.nextLine());
            System.out.println("Denumire = ");
            String denumire = input.nextLine();
            System.out.println("Pret = ");
            double pret = Double.parseDouble(input.nextLine());
            System.out.println("Numar ingrediente = ");
            int nr = Integer.parseInt(input.nextLine());
            System.out.println("Ingregiente = ");
            ArrayList<String> ingrediente = new ArrayList<String>();
            for (int i = 0; i < nr; i++) {
                ingrediente.add(input.nextLine());
            }
            System.out.println("Are alcool? (Y/N)");
            String raspuns = input.nextLine();
            boolean areAlcool = raspuns.toLowerCase().equals("y");

            produseService.modificaBautura(id, denumire, pret, ingrediente, areAlcool);
            ioSingleton.write("modificaBautura");
        }
        else {
            System.out.println("Nu s-a putut modifica produsul");
        }
    }
    private void modificaRestaurant() {
        System.out.println("ID restaurant = ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Strada = ");
        String strada = input.nextLine();
        System.out.println("Numar = ");
        String numar = input.nextLine();
        System.out.println("Oras = ");
        String oras = input.nextLine();

        restauranteService.modificaRestaurant(id, strada, numar, oras);
        ioSingleton.write("modificaRestaurant");
    }
    private void modificaRezervare() {
        System.out.println("ID rezervare = ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Data = ");
        String data = input.nextLine();
        System.out.println("Ora = ");
        String ora = input.nextLine();
        System.out.println("Restaurant ID = ");
        int id_r = Integer.parseInt(input.nextLine());
        Restaurant restaurant = new Restaurant();
        boolean ok1 = false;
        for (Restaurant r : restauranteService.afiseazaRestaurante()) {
            if (r.getRestaurantID() == id_r) {
                restaurant = r;
                ok1 = true;
                break;
            }
        }
        System.out.println("Client ID = ");
        int id_c = Integer.parseInt(input.nextLine());
        Client client = new Client();
        boolean ok2 = false;
        for (Client c : clientService.afiseazaClienti()) {
            if (c.getPersoanaID() == id_c) {
                client = c;
                ok2 = true;
                break;
            }
        }
        if (ok1 && ok2) {
            rezervariService.modificaRezervare(id, data, ora, restaurant, client);
            ioSingleton.write("modificaRezervare");
        }
        else {
            System.out.println("Nu s-a putut modifica rezervarea");
        }
    }
    private void modificaNotaClient() {
        System.out.println("ID Client = ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Nota = ");
        double nota = Double.parseDouble(input.nextLine());

        clientService.modificaNota(id, nota);
        ioSingleton.write("modificaNotaClient");
    }

    private void stergeClient() {
        System.out.println("ID client = ");
        int id = Integer.parseInt(input.nextLine());

        clientService.stergeClient(id);
        ioSingleton.write("stergeClient");
    }
    private void stergeAngajat() {
        System.out.println("ID angajat = ");
        int id = Integer.parseInt(input.nextLine());

        angajatService.stergeAngajat(id);
        ioSingleton.write("stergeAngajat");
    }
    private void stergeProdus() {
        System.out.println("Aliment(1) sau bautura(2)? (tastati cifra corespunzatoare) = ");
        int alegere = Integer.parseInt(input.nextLine());
        if (alegere == 1) {
            System.out.println("ID Aliment = ");
            int id = Integer.parseInt(input.nextLine());

            produseService.stergeAliment(id);
            ioSingleton.write("stergeAliment");
        }
        else if (alegere == 2) {
            System.out.println("ID Bautura = ");
            int id = Integer.parseInt(input.nextLine());

            produseService.stergeBautura(id);
            ioSingleton.write("stergeBautura");
        }
        else {
            System.out.println("Nu s-a putut sterge produsul");
        }
    }
    private void stergeRezervare() {
        System.out.println("ID rezervare");
        int id = Integer.parseInt(input.nextLine());

        rezervariService.stergeRezervare(id);
        ioSingleton.write("stergeRezervare");
    }
    private void stergeRestaurant() {
        System.out.println("ID restaurant = ");
        int id = Integer.parseInt(input.nextLine());

        restauranteService.stergeRestaurant(id);
        ioSingleton.write("stergeRestaurant");
    }

    private void loadDB() {
        ArrayList<String> citire = ioSingleton.read("D:\\IntelliJ\\Projects\\ProiectPAO\\src\\database\\angajati.csv");
        for (String linie : citire) {
            String[] linie_split = linie.split(",");
            angajatService.adaugaAngajat(linie_split[0], linie_split[1], linie_split[2],
                    Double.parseDouble(linie_split[3]), linie_split[4], Boolean.parseBoolean(linie_split[5]));
        }
        citire = ioSingleton.read("D:\\IntelliJ\\Projects\\ProiectPAO\\src\\database\\clienti.csv");
        for (String linie : citire) {
            String[] linie_split = linie.split(",");
            clientService.adaugaClient(linie_split[0], linie_split[1], linie_split[2]);
        }
        citire = ioSingleton.read("D:\\IntelliJ\\Projects\\ProiectPAO\\src\\database\\restaurante.csv");
        for (String linie : citire) {
            String[] linie_split = linie.split(",");
            restauranteService.adaugaRestaurant(linie_split[0], linie_split[1], linie_split[2]);
        }
        citire = ioSingleton.read("D:\\IntelliJ\\Projects\\ProiectPAO\\src\\database\\alimente.csv");
        for (String linie : citire) {
            String[] linie_split = linie.split(",");
            produseService.adaugaAliment(linie_split[0], Double.parseDouble(linie_split[1]), linie_split[2], linie_split[3]);
        }
        citire = ioSingleton.read("D:\\IntelliJ\\Projects\\ProiectPAO\\src\\database\\bauturi.csv");
        for (String linie : citire) {
            String[] linie_split = linie.split(",");
            ArrayList<String> ingrediente = new ArrayList<String>();
            int nr_ingrediente = Integer.parseInt(linie_split[2]);
            for (int i = 0; i < nr_ingrediente; i++) {
                ingrediente.add(linie_split[i + 3]);
            }
            produseService.adaugaBautura(linie_split[0], Double.parseDouble(linie_split[1]), ingrediente,
                    Boolean.parseBoolean(linie_split[nr_ingrediente + 3]));
        }
    }

    public void run() {
        loadDB();

        System.out.println("==========Bun venit!==========");
        int command;
        String rol = "nelogat";
        int userID = -1;
        while (true) {
            afiseazaFunctii(rol);
            System.out.println("Comanda = ");
            command = Integer.parseInt(input.nextLine());

            if (rol.equals("nelogat")) {
                if (command == 1) {// register client
                    adaugaClient();
                }
                else if (command == 2) {//login client
                    System.out.println("Nume = ");
                    String nume = input.nextLine();
                    System.out.println("Parola = ");
                    String parola = input.nextLine();

                    rol = clientService.loginClient(nume, parola);
                    if (!rol.equals("nelogat")) {
                        for (Client client : clientService.afiseazaClienti()) {
                            if (client.getNume().equals(nume)) {
                                userID = client.getPersoanaID();
                                break;
                            }
                        }
                        ioSingleton.write("loginClient");
                    }
                }
                else if (command == 3) {//login angajat
                    System.out.println("Nume = ");
                    String nume = input.nextLine();
                    System.out.println("Parola = ");
                    String parola = input.nextLine();

                    rol = angajatService.loginAngajat(nume, parola);
                    if (!rol.equals("nelogat")) {
                        for (Angajat angajat : angajatService.afiseazaAngajati()) {
                            if (angajat.getNume().equals(nume)) {
                                userID = angajat.getPersoanaID();
                                break;
                            }
                        }
                        ioSingleton.write("loginAngajat");
                    }
                }
                else if (command == 4) {//afiseaza produse
                    afiseazaProduse();
                }
                else if (command == 5) {//afiseaza restaurante
                    afiseazaRestaurante();
                }
                else if (command == 6){//inchide aplicatia
                    System.out.println("La revedere!");
                    ioSingleton.write("closeApp");
                    break;
                }
                else {
                    System.out.println("Comanda inexistenta");
                }
            }
            else if (rol.equals("client")) {
                if (command == 1) {//afiseaza produse
                    afiseazaProduse();
                }
                else if (command == 2) {//afiseaza restaurante
                    afiseazaRestaurante();
                }
                else if (command == 3) {//afiseaza rezervarile tale
                    ArrayList<Rezervare> rezervari = rezervariService.afiseazaRezervariDupaClient(userID);
                    for (Rezervare rezervare : rezervari) {
                        System.out.println(rezervare);
                    }
                    ioSingleton.write("afiseazaRezervariDupaClient");
                }
                else if (command == 4) {//adauga rezervare
                    System.out.println("Data = ");
                    String data = input.nextLine();
                    System.out.println("Ora = ");
                    String ora = input.nextLine();
                    System.out.println("Restaurant ID = ");
                    int id = Integer.parseInt(input.nextLine());
                    Restaurant restaurant = new Restaurant();
                    boolean ok = false;
                    for (Restaurant r : restauranteService.afiseazaRestaurante()) {
                        if (r.getRestaurantID() == id) {
                            restaurant = r;
                            ok = true;
                            break;
                        }
                    }
                    if (ok) {
                        Client client = new Client();
                        for (Client c : clientService.afiseazaClienti()) {
                            if (c.getPersoanaID() == userID) {
                                client = c;
                                break;
                            }
                        }
                        rezervariService.adaugaRezervare(data, ora, restaurant, client);
                        ioSingleton.write("adaugaRezervare");
                    }
                    else {
                        System.out.println("Nu s-a putut face rezervarea");
                    }
                }
                else if (command == 5) {//modifica date despre rezervarile tale
                    System.out.println("ID rezervare de modificat = ");
                    int id_Rez = Integer.parseInt(input.nextLine());
                    System.out.println("Data = ");
                    String data = input.nextLine();
                    System.out.println("Ora = ");
                    String ora = input.nextLine();
                    System.out.println("Restaurant ID = ");
                    int id = Integer.parseInt(input.nextLine());
                    Restaurant restaurant = new Restaurant();
                    boolean ok = false;
                    for (Restaurant r : restauranteService.afiseazaRestaurante()) {
                        if (r.getRestaurantID() == id) {
                            restaurant = r;
                            ok = true;
                            break;
                        }
                    }
                    if (ok) {
                        Client client = new Client();
                        for (Client c : clientService.afiseazaClienti()) {
                            if (c.getPersoanaID() == userID) {
                                client = c;
                                break;
                            }
                        }
                        rezervariService.modificaRezervare(id_Rez, data, ora, restaurant, client);
                        ioSingleton.write("modificaRezervare");
                    }
                    else {
                        System.out.println("Nu s-a putut face rezervarea");
                    }
                }
                else if (command == 6) {//sterge contul
                    clientService.stergeClient(userID);
                    rol = "nelogat";
                }
                else if (command == 7) {//sterge rezervarea
                    System.out.println("ID rezervare = ");
                    int id = Integer.parseInt(input.nextLine());
                    rezervariService.stergeRezervare(id);
                    ioSingleton.write("stergeRezervare");
                }
                else if (command == 8) {//inchide aplicatia
                    System.out.println("La revedere!");
                    ioSingleton.write("closeApp");
                    break;
                }
                else {
                    System.out.println("Comanda inexistenta");
                }
            }
            else if (rol.equals("angajat")) {
                if (command == 1) {//afiseaza produse
                    afiseazaProduse();
                }
                else if (command == 2) {//afiseaza clienti
                    afiseazaClienti();
                }
                else if (command == 3) {//afiseaza restaurante
                    afiseazaRestaurante();
                }
                else if (command == 4) {//afiseaza rezervari
                    afiseazaRezervari();
                }
                else if (command == 5) {//adauga client
                    adaugaClient();
                }
                else if (command == 6) {//adauga produse
                    adaugaProdus();
                }
                else if (command == 7) {//adauga rezervare
                    adaugaRezervare();
                }
                else if (command == 8) {//modifica produse
                    modificaProdus();
                }
                else if (command == 9) {//modifica rezervare
                    modificaRezervare();
                }
                else if (command == 10) {//modifica nota client
                    modificaNotaClient();
                }
                else if (command == 11) {//sterge produs
                    stergeProdus();
                }
                else if (command == 12) {//sterge rezervare
                    stergeRezervare();
                }
                else if (command == 13) {//inchide aplicatia
                    System.out.println("La revedere!");
                    ioSingleton.write("closeApp");
                    break;
                }
                else {
                    System.out.println("Comanda inexistenta");
                }
            }
            else {//if (rol.equals("admin"))
                if (command == 1) {//afiseaza clienti
                    afiseazaClienti();
                }
                else if (command == 2) {//afiseaza restaurante
                    afiseazaRestaurante();
                }
                else if (command == 3) {//afiseaza rezervari
                    afiseazaRezervari();
                }
                else if (command == 4) {//afiseaza angajati
                    afiseazaAngajati();
                }
                else if (command == 5) {//afiseaza produse
                    afiseazaProduse();
                }
                else if (command == 6) {//adauga client
                    adaugaClient();
                }
                else if (command == 7) {//adauga produse
                    adaugaProdus();
                }
                else if (command == 8) {//adauga rezervare
                    adaugaRezervare();
                }
                else if (command == 9) {//adauga angajat
                    adaguaAngajat();
                }
                else if (command == 10) {//adauga restaurant
                    adaugaRestaurant();
                }
                else if (command == 11) {//modifica angajat
                    modificaAngajat();
                }
                else if (command == 12) {//modifica produse
                    modificaProdus();
                }
                else if (command == 13) {//modifica rezervare
                    modificaRezervare();
                }
                else if (command == 14) {//modifica client
                    modificaClient();
                }
                else if (command == 15) {//modifica restaurant
                    modificaRestaurant();
                }
                else if (command == 16) {//sterge produs
                    stergeProdus();
                }
                else if (command == 17) {//sterge rezervare
                    stergeRezervare();
                }
                else if (command == 18) {//sterge angajat
                    stergeAngajat();
                }
                else if (command == 19) {//sterge client
                    stergeClient();
                }
                else if (command == 20) {//sterge restaurant
                    stergeRestaurant();
                }
                else if (command == 21) {//inchide aplicatia
                    System.out.println("La revedere!");
                    ioSingleton.write("closeApp");
                    break;
                }
                else {
                    System.out.println("Comanda inexistenta");
                }
            }
        }
    }
}
