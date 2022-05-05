package services;

import domain.Restaurant;
import persistence.RestaurantRepository;
import java.util.ArrayList;

public class RestauranteService {
    private RestaurantRepository restaurantRepository = new RestaurantRepository();

    public void adaugaRestaurant(String strada, String numar, String oras) {
        Restaurant restaurant = new Restaurant(strada, numar, oras);
        if (restaurantRepository.getSize() < 10) {
            restaurantRepository.add(restaurant);
        }
    }
    public ArrayList<Restaurant> afiseazaRestaurante() {
        ArrayList<Restaurant> result = new ArrayList<Restaurant>();
        for (int i = 0; i < restaurantRepository.getSize(); i++) {
            result.add(restaurantRepository.get(i));
        }
        return result;
    }
    public void modificaRestaurant(int id, String strada, String numar, String oras) {
        Restaurant restaurant = new Restaurant(strada, numar, oras);
        for (int i = 0; i < restaurantRepository.getSize(); i++) {
            if (restaurantRepository.get(i).getRestaurantID() == id) {
                restaurantRepository.update(i, restaurant);
                break;
            }
        }
    }
    public void stergeRestaurant(int id) {
        for (int i = 0; i < restaurantRepository.getSize(); i++) {
            if (restaurantRepository.get(i).getRestaurantID() == id) {
                restaurantRepository.delete(i);
                break;
            }
        }
    }
}
