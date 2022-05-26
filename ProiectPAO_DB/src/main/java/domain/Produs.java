package domain;

public abstract class Produs {
    private static int NrProduse;

    private int ProdusID;
    private String Denumire;
    private double Pret;

    public Produs() {
        ProdusID = ++NrProduse;
        Denumire = "Lipsa denumire";
        Pret = 0;
    }
    public Produs(int produsID, String denumire, double pret) {
        ProdusID = produsID;
        Denumire = denumire;
        Pret = pret;
    }
    public Produs(String denumire, double pret) {
        ProdusID = ++NrProduse;
        Denumire = denumire;
        Pret = pret;
    }
    public Produs(Produs p) {
        ProdusID = ++NrProduse;
        Denumire = p.Denumire;
        Pret = p.Pret;
    }

    @Override
    public String toString() {
        return "ProdusID: " + ProdusID +
                "\nDenumire: " + Denumire +
                "\nPret: " + Pret +
                "\n";
    }

    public static int getNrProduse() {
        return NrProduse;
    }
    public static void setNrProduse(int nrProduse) {
        NrProduse = nrProduse;
    }
    public int getProdusID() {
        return ProdusID;
    }
    public void setProdusID(int produsID) {
        ProdusID = produsID;
    }
    public String getDenumire() {
        return Denumire;
    }
    public void setDenumire(String denumire) {
        Denumire = denumire;
    }
    public double getPret() {
        return Pret;
    }
    public void setPret(double pret) { Pret = pret; }
}
