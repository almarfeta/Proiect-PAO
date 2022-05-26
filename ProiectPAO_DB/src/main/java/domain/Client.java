package domain;

public class Client extends Persoana {
    private double Nota;

    public Client() {
        super();
        Nota = 0;
    }
    public Client(int persoanaID, String nume, String telefon, String parola, double nota) {
        super(persoanaID, nume, telefon, parola);
        Nota = nota;
    }
    public Client(String nume, String telefon, String parola) {
        super(nume, telefon, parola);
        Nota = 0;
    }
    public Client(Client c) {
        super(c);
        Nota = 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Nota: " + Nota +
                "\n";
    }

    public double getNota() { return Nota; }
    public void setNota(double nota) {
        Nota = nota;
    }
}

