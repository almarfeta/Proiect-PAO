import java.util.Arrays;

public class Bautura extends Produs{
    private String[] Ingrediente;
    private boolean areAlcool;

    public Bautura() {
        areAlcool = false;
    }
    public Bautura(String denumire, double pret, String[] ingrediente, boolean areAlcool) {
        super(denumire, pret);
        Ingrediente = new String[ingrediente.length];
        for (int i = 0; i < ingrediente.length; i++) {
            Ingrediente[i] = ingrediente[i];
        }
        this.areAlcool = areAlcool;
    }
    public Bautura(Bautura b) {
        super(b);
        Ingrediente = new String[b.Ingrediente.length];
        for (int i = 0; i < b.Ingrediente.length; i++) {
            Ingrediente[i] = b.Ingrediente[i];
        }
        this.areAlcool = b.areAlcool;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Ingrediente: " + Arrays.toString(Ingrediente) +
                "\nAre alcool: " + areAlcool +
                "\n";
    }

    public String[] getIngrediente() {
        return Ingrediente;
    }
    public void setIngrediente(String[] ingrediente) {
        Ingrediente = ingrediente;
    }
    public boolean isAreAlcool() {
        return areAlcool;
    }
    public void setAreAlcool(boolean areAlcool) {
        this.areAlcool = areAlcool;
    }
}
