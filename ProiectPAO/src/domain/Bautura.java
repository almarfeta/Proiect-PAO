package domain;
import java.util.ArrayList;

public class Bautura extends Produs {
    private ArrayList<String> Ingrediente;
    private boolean areAlcool;

    public Bautura() {
        Ingrediente = new ArrayList<String>();
        areAlcool = false;
    }
    public Bautura(String denumire, double pret, ArrayList<String> ingrediente, boolean areAlcool) {
        super(denumire, pret);
        this.Ingrediente = new ArrayList<String>();
        this.Ingrediente = ingrediente;
        this.areAlcool = areAlcool;
    }
    public Bautura(Bautura b) {
        super(b);
        this.Ingrediente = new ArrayList<String>();
        this.Ingrediente = b.Ingrediente;
        this.areAlcool = b.areAlcool;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Ingrediente: " + Ingrediente +
                "\nAre alcool: " + areAlcool +
                "\n";
    }

    public ArrayList<String> getIngrediente() {
        return Ingrediente;
    }
    public void setIngrediente(ArrayList<String> ingrediente) {
        Ingrediente = ingrediente;
    }
    public boolean getAreAlcool() {
        return areAlcool;
    }
    public void setAreAlcool(boolean areAlcool) {
        this.areAlcool = areAlcool;
    }
}

