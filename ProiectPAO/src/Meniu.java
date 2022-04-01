import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Meniu {

    private void loadDB(Angajat[] angajati, Client[] clienti, Restaurant[] restaurante,
                              Rezervare[] rezervari, List<Produs> produse) {

        angajati[0] = new Angajat("Almar", "0767123456", "admin", 5234.5, "Manager", true);
        angajati[1] = new Angajat("Theo", "0767654321", "angajat1", 3234.5, "Ospatar", false);
        angajati[2] = new Angajat("Cosmin", "0767123789", "angajat2", 3234.5, "Bucatar", false);

        clienti[0] = new Client("Marcel", "0761234567", "123456");
        clienti[1] = new Client("Costel", "0712345678", "qwerty");
        clienti[2] = new Client("Gigel", "0798765432", "q1w2e3r4");

        restaurante[0] = new Restaurant("Teilor", "12", "Bucuresti");
        restaurante[1] = new Restaurant("Livezilor", "56A", "Brasov");
        restaurante[2] = new Restaurant("Lalelelor", "25", "Constanta");

        rezervari[0] = new Rezervare("12:00", "01.06.2022", restaurante[0], clienti[0]);
        rezervari[1] = new Rezervare("15:00", "15.10.2022", restaurante[0], clienti[1]);
        rezervari[2] = new Rezervare("20:00", "20.05.2022", restaurante[1], clienti[2]);

        produse.add(new Aliment("Salata asortata", 12.0, "Salata de rosii, castraveti, ardei si ceapa.", "salate"));
        produse.add(new Aliment("Orez sarbesc", 8.5, "Orez cu morcovi, ardei si ceapa.", "garnituri"));
        produse.add(new Bautura("Mojito", 21.0, new String[] {"lime", "zahar", "menta", "rom", "apa minerala"}, true));
    }

    private void afiseazaFunctii1() {
        System.out.println("Apasati cifra corespunzatoare comenzii:\n" +
                "1) Login angajat\n" +
                "2) Login client\n" +
                "3) Afiseaza produse\n" +
                "4) Afiseaza restaurante\n" +
                "5) Register client\n" +
                "6) Inchide aplicatia\n" +
                "Pentru mai multe comenzi logheaza-te\n" +
                "---------------------------------------"
        );
    }
    private void afiseazaFunctii2() {
        System.out.println("Apasati cifra corespunzatoare comenzii:\n" +
                "1) Afiseaza produse\n" +
                "2) Afiseaza restaurante\n" +
                "3) Afiseaza angajati (admin)\n" +
                "4) Afiseaza clienti (angajat)\n" +
                "5) Afiseaza rezervari (angajat)\n" +
                "6) Adauga client (admin)\n" +
                "7) Adauga produse (angajat)\n" +
                "8) Adauga angajat (admin)\n" +
                "9) Adauga restaurant (admin)\n" +
                "10) Adauga rezervare (client)\n" +
                "11) Inchide aplicatia\n" +
                "---------------------------------------"
        );
    }

    private int loginAngajat(Scanner input, Angajat[] angajati) {
        System.out.println("Nume = ");
        String nume = input.nextLine();

        System.out.println("Parola = ");
        String parola = input.nextLine();

        for (Angajat angajat : angajati) {
            if (angajat != null)
                if (angajat.getNume().equals(nume) && angajat.getParola().equals(parola)) {
                    if (angajat.geteAdmin()) {
                        System.out.println("Ati fost logat ca admin");
                        return 3;
                    }
                    else {
                        System.out.println("Ati fost logat ca angajat");
                        return 2;
                    }
                }
        }
        System.out.println("Nu ati fost gasit in baza de date");
        return 0;
    }
    private int loginClient(Scanner input, Client[] clienti) {
        System.out.println("Nume = ");
        String nume = input.nextLine();

        System.out.println("Parola = ");
        String parola = input.nextLine();

        for (Client client : clienti) {
            if (client != null)
                if (client.getNume().equals(nume) && client.getParola().equals(parola)) {
                    System.out.println("Ati fost logat ca client");
                    return 1;
                }
        }
        System.out.println("Nu ati fost gasit in baza de date");
        return 0;
    }

    private void afisareProduse(List<Produs> produse) {
        for (Produs produs : produse) {
            System.out.println(produs);
        }
    }
    private void afisareAngajati(Angajat[] angajati, int nr_angajati) {
        for (int i = 0; i < nr_angajati; i++) {
            System.out.println(angajati[i]);
        }
    }
    private void afisareClienti(Client[] clienti, int nr_clienti) {
        for (int i = 0; i < nr_clienti; i++) {
            System.out.println(clienti[i]);
        }
    }
    private void afisareRestaurante(Restaurant[] restaurante, int nr_restaurante) {
        for (int i = 0; i < nr_restaurante; i++) {
            System.out.println(restaurante[i]);
        }
    }
    private void afisareRezervari(Rezervare[] rezervari, int nr_rezervari) {
        for (int i = 0; i < nr_rezervari; i++) {
            System.out.println(rezervari[i]);
        }
    }

    private void addClient(Scanner input, Client[] clienti, int nr_clienti) {
        System.out.println("Nume = ");
        String nume = input.nextLine();

        System.out.println("Telefon = ");
        String telefon = input.nextLine();

        System.out.println("Parola = ");
        String parola = input.nextLine();

        clienti[nr_clienti] = new Client(nume, telefon, parola);
    }
    private void addAngajat(Scanner input, Angajat[] angajati, int nr_angajati) {
        System.out.println("Nume = ");
        String nume = input.nextLine();

        System.out.println("Telefon = ");
        String telefon = input.nextLine();

        System.out.println("Parola = ");
        String parola = input.nextLine();

        System.out.println("Salariu =");
        double salariu = Double.parseDouble(input.nextLine());

        System.out.println("Functie = ");
        String functie = input.nextLine();

        System.out.println("Este admin = ");
        boolean eAdmin = Boolean.parseBoolean(input.nextLine());

        angajati[nr_angajati] = new Angajat(nume, telefon, parola, salariu, functie, eAdmin);
    }
    private void addProdus(Scanner input, List<Produs> produse) {
        System.out.println("Aliment(1) sau bautura(2): ");
        int tipProdus = Integer.parseInt(input.nextLine());

        System.out.println("Denumire = ");
        String denumire = input.nextLine();

        System.out.println("Pret = ");
        double pret = Double.parseDouble(input.nextLine());

        if (tipProdus == 1) {
            System.out.println("Descriere = ");
            String descriere = input.nextLine();

            System.out.println("Categorie = ");
            String categorie = input.nextLine();

            produse.add(new Aliment(denumire, pret, descriere, categorie));
        }
        else if (tipProdus == 2) {
            System.out.println("Numar de ingrediente");
            int nr = Integer.parseInt(input.nextLine());

            System.out.println("Lista de ingrediente = ");
            String[] ingrediente = new String[nr];
            for (int i = 0; i < nr; i++) {
                ingrediente[i] = input.nextLine();
            }

            System.out.println("Are alcool = ");
            boolean areAlcool = Boolean.parseBoolean(input.nextLine());

            produse.add(new Bautura(denumire, pret, ingrediente, areAlcool));
        }
    }
    private void addRestaurant(Scanner input, Restaurant[] restaurante, int nr_restaurante) {
        System.out.println("Strada = ");
        String strada = input.nextLine();

        System.out.println("Numar = ");
        String numar = input.nextLine();

        System.out.println("Oras = ");
        String oras = input.nextLine();

        restaurante[nr_restaurante] = new Restaurant(strada, numar, oras);
    }
    private void addRezervare(Scanner input, Rezervare[] rezervari, Restaurant[] restaurante, Client[] clienti,
                              int nr_restaurante, int nr_rezervari, int nr_clienti) {
        System.out.println("Data = ");
        String data = input.nextLine();

        System.out.println("Ora = ");
        String ora = input.nextLine();

        System.out.println("ID restaurant = ");
        int idr = Integer.parseInt(input.nextLine());
        Restaurant restaurant = null;
        for (int i = 0; i < nr_restaurante; i++) {
            if (restaurante[i].getRestaurantID() == idr) {
                restaurant = restaurante[i];
                break;
            }
        }
        System.out.println("ID client = ");
        int idc = Integer.parseInt(input.nextLine());
        Client client = null;
        for (int i = 0; i < nr_clienti; i++) {
            if (clienti[i].getPersoanaID() == idc) {
                client = clienti[i];
                break;
            }
        }
        rezervari[nr_rezervari] = new Rezervare(data, ora, restaurant, client);
    }


    public void start() {
        int nr_angajati = 3;
        int nr_clienti = 3;
        int nr_restaurante = 3;
        int nr_rezervari = 3;
        Angajat[] angajati = new Angajat[10];
        Client[] clienti = new Client[10];
        Restaurant[] restaurante = new Restaurant[10];
        Rezervare[] rezervari = new Rezervare[10];
        List<Produs> produse = new ArrayList<Produs>();

        loadDB(angajati, clienti, restaurante, rezervari, produse);

        System.out.println("==========Bun venit!==========");
        int command;
        int login = 0;
        Scanner input = new Scanner(System.in);
        while (login == 0) {
            do {
                afiseazaFunctii1();
                System.out.println("Comanda = ");
                command = Integer.parseInt(input.nextLine());
            } while (!(command >= 1 && command <= 6));
            if (command == 1) {
                login = loginAngajat(input, angajati);
            } else if (command == 2) {
                login = loginClient(input, clienti);
            } else if (command == 3) {
                afisareProduse(produse);
            } else if (command == 4) {
                afisareRestaurante(restaurante, nr_restaurante);
            } else if (command == 5) {
                addClient(input, clienti, nr_clienti);
                nr_clienti++;
                afisareClienti(clienti, nr_clienti);
            } else if (command == 6) {
                System.out.println("La revedere!");
                return;
            }
        }

        boolean stop = false;
        while (!stop) {
            do {
                afiseazaFunctii2();
                System.out.println("Comanda = ");
                command = Integer.parseInt(input.nextLine());
            } while (!(command >= 1 && command <= 11));
            if (command == 1) {
                afisareProduse(produse);
            }
            else if (command == 2) {
                afisareRestaurante(restaurante, nr_restaurante);
            }
            else if (command == 3) {
                if (login == 3) {
                    afisareAngajati(angajati, nr_angajati);
                }
                else {
                    System.out.println("Nu ai permisiune");
                }
            }
            else if (command == 4) {
                if (login >= 2) {
                    afisareClienti(clienti, nr_clienti);
                }
                else {
                    System.out.println("Nu ai permisiune");
                }
            }
            else if (command == 5) {
                if (login >= 2) {
                    afisareRezervari(rezervari, nr_rezervari);
                }
                else {
                    System.out.println("Nu ai permisiune");
                }
            }
            else if (command == 6) {
                if (login == 3) {
                    addClient(input, clienti, nr_clienti);
                    nr_clienti++;
                }
                else {
                    System.out.println("Nu ai permisiune");
                }
            }
            else if (command == 7) {
                if (login >= 2) {
                    addProdus(input, produse);
                }
                else {
                    System.out.println("Nu ai permisiune");
                }
            }
            else if (command == 8) {
                if (login == 3) {
                    addAngajat(input, angajati, nr_angajati);
                    nr_angajati++;
                }
                else {
                    System.out.println("Nu ai permisiune");
                }
            }
            else if (command == 9) {
                if (login == 3) {
                    addRestaurant(input, restaurante, nr_restaurante);
                    nr_restaurante++;
                }
                else {
                    System.out.println("Nu ai permisiune");
                }
            }
            else if (command == 10) {
                if (login >= 1) {
                    addRezervare(input, rezervari, restaurante, clienti, nr_restaurante, nr_rezervari, nr_clienti);
                    nr_rezervari++;
                }
                else {
                    System.out.println("Nu ai permisiune");
                }
            }
            else if (command == 11) {
                stop = true;
            }
        }
    }
}
