package domain;

import java.util.Objects;

public class Angajat extends Persoana {
    private double Salariu;
    private String Functie;
    private boolean eAdmin;

    public Angajat() {
        super();
        this.Salariu = 0;
        this.Functie = "Lipsa functie";
        this.eAdmin = false;
    }
    public Angajat(String Nume, String Telefon, String parola, double Salariu, String Functie, boolean eAdmin) {
        super(Nume,Telefon, parola);
        this.Salariu = Salariu;
        this.Functie = Functie;
        this.eAdmin = eAdmin;
    }
    public Angajat(Angajat a) {
        super(a);
        this.Salariu = a.Salariu;
        this.Functie = a.Functie;
        this.eAdmin = a.eAdmin;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Salariu: " + this.Salariu +
                "\nFunctie: " + this.Functie +
                "\nEste admin: " + this.eAdmin +
                "\n";
    }

    public double getSalariu() { return Salariu; }
    public void setSalariu(double salariu) {
        Salariu = salariu;
    }
    public String getFunctie() {
        return Functie;
    }
    public void setFunctie(String functie) {
        Functie = functie;
    }
    public boolean geteAdmin() { return eAdmin; }
    public void seteAdmin(boolean eAdmin) { this.eAdmin = eAdmin; }
}

