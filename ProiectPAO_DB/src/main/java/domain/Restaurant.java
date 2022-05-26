package domain;

public class Restaurant {
    private static int NrRestaurante;

    private int RestaurantID;
    private String Strada;
    private String Numar;
    private String Oras;

    public Restaurant() {
        RestaurantID = ++NrRestaurante;
        Strada = "Lipsa strada";
        Numar = "Lipsa numar";
        Oras = "Lipsa oras";
    }
    public Restaurant(int restaurantID, String strada, String numar, String oras) {
        RestaurantID = restaurantID;
        Strada = strada;
        Numar = numar;
        Oras = oras;
    }
    public Restaurant(String strada, String numar, String oras) {
        RestaurantID = ++NrRestaurante;
        Strada = strada;
        Numar = numar;
        Oras = oras;
    }
    public Restaurant(Restaurant r) {
        RestaurantID = ++NrRestaurante;
        Strada = r.Strada;
        Numar = r.Numar;
        Oras = r.Oras;
    }

    @Override
    public String toString() {
        return "RestaurantID: " + RestaurantID +
                "\nStrada: " + Strada +
                "\nNumar: " + Numar +
                "\nOras: " + Oras +
                "\n";
    }

    public static int getNrRestaurante() {
        return NrRestaurante;
    }
    public static void setNrRestaurante(int nrRestaurante) {
        NrRestaurante = nrRestaurante;
    }
    public int getRestaurantID() {
        return RestaurantID;
    }
    public void setRestaurantID(int restaurantID) {
        RestaurantID = restaurantID;
    }
    public String getStrada() {
        return Strada;
    }
    public void setStrada(String strada) {
        Strada = strada;
    }
    public String getNumar() {
        return Numar;
    }
    public void setNumar(String numar) {
        Numar = numar;
    }
    public String getOras() {
        return Oras;
    }
    public void setOras(String oras) {
        Oras = oras;
    }
}

