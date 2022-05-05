package domain;

public class Aliment extends Produs {
    private String Descriere;
    private String Categorie;

    public Aliment() {
        super();
        Descriere = "Fara descriere";
        Categorie = "Fara categorie";
    }
    public Aliment(String denumire, double pret, String descriere, String categorie) {
        super(denumire, pret);
        Descriere = descriere;
        Categorie = categorie;
    }
    public Aliment(Aliment a) {
        super(a);
        Descriere = a.Descriere;
        Categorie = a.Categorie;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Descriere: " + Descriere +
                "\nCategorie: " + Categorie +
                '\n';
    }

    public String getDescriere() {
        return Descriere;
    }
    public void setDescriere(String descriere) {
        Descriere = descriere;
    }
    public String getCategorie() {
        return Categorie;
    }
    public void setCategorie(String categorie) {
        Categorie = categorie;
    }
}

