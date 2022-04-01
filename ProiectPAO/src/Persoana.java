public class Persoana {
    private static int NrPersoane = 0;

    private int PersoanaID;
    private String Nume;
    private String Telefon;
    private String Parola;

    public Persoana() {
        this.PersoanaID = ++NrPersoane;
        this.Nume = "Anonim";
        this.Telefon = "Lipsa numar";
        this.Parola = "1234";
    }
    public Persoana(String Nume, String Telefon, String parola) {
        this.PersoanaID = ++NrPersoane;
        this.Nume = Nume;
        this.Telefon = Telefon;
        this.Parola = parola;
    }
    public Persoana(Persoana p) {
        this.PersoanaID = ++NrPersoane;
        this.Nume = p.Nume;
        this.Telefon = p.Telefon;
        this.Parola = p.Parola;
    }

    @Override
    public String toString() {
        return "ID: " + this.PersoanaID +
                "\nNume: " + this.Nume +
                "\nTelefon: " + this.Telefon +
                "\n";
    }

    public int getPersoanaID() {
        return PersoanaID;
    }
    public void setPersoanaID(int persoanaID) {
        PersoanaID = persoanaID;
    }
    public String getNume() {
        return Nume;
    }
    public void setNume(String nume) {
        Nume = nume;
    }
    public String getTelefon() {
        return Telefon;
    }
    public void setTelefon(String telefon) {
        Telefon = telefon;
    }
    public String getParola() {
        return Parola;
    }
    public void setParola(String parola) {
        Parola = parola;
    }
}
