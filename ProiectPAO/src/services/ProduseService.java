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
        for (int i = 0; i < alimentRepository.getSize(); i++) {
            result.add(alimentRepository.get(i));
        }
        for (int i = 0; i < bauturaRepository.getSize(); i++) {
            result.add(bauturaRepository.get(i));
        }
        return result;
    }
    public void modificaAliment(int id, String denumire, double pret, String descriere, String categorie) {
        Aliment aliment = new Aliment(denumire, pret, descriere, categorie);
        for (int i = 0; i < alimentRepository.getSize(); i++) {
            if (alimentRepository.get(i).getProdusID() == id) {
                alimentRepository.update(i, aliment);
                break;
            }
        }
    }
    public void modificaBautura(int id, String denumire, double pret, ArrayList<String> ingrediente, boolean areAlcool) {
        Bautura bautura = new Bautura(denumire, pret, ingrediente, areAlcool);
        for (int i = 0; i < bauturaRepository.getSize(); i++) {
            if (bauturaRepository.get(i).getProdusID() == id) {
                bauturaRepository.update(i, bautura);
                break;
            }
        }
    }
    public void stergeAliment(int id) {
        for (int i = 0; i < alimentRepository.getSize(); i++) {
            if (alimentRepository.get(i).getProdusID() == id) {
                alimentRepository.delete(i);
                break;
            }
        }
    }
    public void stergeBautura(int id) {
        for (int i = 0; i < bauturaRepository.getSize(); i++) {
            if (bauturaRepository.get(i).getProdusID() == id) {
                bauturaRepository.delete(i);
                break;
            }
        }
    }
}
