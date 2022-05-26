package services;

import domain.Aliment;
import domain.Bautura;
import domain.Produs;
import persistence.AlimentRepository;
import persistence.BauturaRepository;
import java.util.ArrayList;

public class ProduseService {
    private AlimentRepository alimentRepository = new AlimentRepository();
    private BauturaRepository bauturaRepository = new BauturaRepository();

    public void adaugaAliment(String denumire, double pret, String descriere, String categorie) {
        Aliment aliment = new Aliment(denumire, pret, descriere, categorie);
        alimentRepository.add(aliment);
    }
    public void adaugaBautura(String denumire, double pret, ArrayList<String> ingrediente, boolean areAlcool) {
        Bautura bautura = new Bautura(denumire, pret, ingrediente, areAlcool);
        bauturaRepository.add(bautura);
    }
    public ArrayList<Produs> afiseazaProduse() {
        ArrayList<Produs> result = new ArrayList<Produs>();
        result.addAll(alimentRepository.getAll());
        result.addAll(bauturaRepository.getAll());
        return result;
    }
    public void modificaAliment(int id, String denumire, double pret, String descriere, String categorie) {
        Aliment aliment = new Aliment(id, denumire, pret, descriere, categorie);
        alimentRepository.update(id, aliment);
    }
    public void modificaBautura(int id, String denumire, double pret, ArrayList<String> ingrediente, boolean areAlcool) {
        Bautura bautura = new Bautura(id, denumire, pret, ingrediente, areAlcool);
        bauturaRepository.update(id, bautura);
    }
    public void stergeAliment(int id) {
        alimentRepository.delete(id);
        Produs.setNrProduse(Produs.getNrProduse() - 1);
    }
    public void stergeBautura(int id) {
        bauturaRepository.delete(id);
        Produs.setNrProduse(Produs.getNrProduse() - 1);
    }
    public int getSize() {
        return alimentRepository.getSize() + bauturaRepository.getSize();
    }
    public int getID() {
        ArrayList<Aliment> alimente = alimentRepository.getAll();
        ArrayList<Bautura> bauturi = bauturaRepository.getAll();
        int id_max = 0;
        for (Aliment aliment : alimente) {
            if (aliment.getProdusID() > id_max) {
                id_max = aliment.getProdusID();
            }
        }
        for (Bautura bautura : bauturi) {
            if (bautura.getProdusID() > id_max) {
                id_max = bautura.getProdusID();
            }
        }
        return id_max;
    }
}
