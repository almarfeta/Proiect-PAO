package services;

import domain.Restaurant;
import persistence.RestaurantRepository;
import java.util.ArrayList;

public class RestauranteService {
    private RestaurantRepository restaurantRepository = new RestaurantRepository();

    public void adaugaRestaurant(String strada, String numar, String oras) {
        Restaurant restaurant = new Restaurant(strada, numar, oras);
        restaurantRepository.add(restaurant);
    }
    public ArrayList<Restaurant> afiseazaRestaurante() {
        return restaurantRepository.getAll();
    }
    public void modificaRestaurant(int id, String strada, String numar, String oras) {
        Restaurant restaurant = new Restaurant(id, strada, numar, oras);
        restaurantRepository.update(id, restaurant);
    }
    public void stergeRestaurant(int id) {
        restaurantRepository.delete(id);
        Restaurant.setNrRestaurante(Restaurant.getNrRestaurante() - 1);
    }
    public int getSize() {
        return restaurantRepository.getSize();
    }
    public int getID() {
        ArrayList<Restaurant> restaurante = restaurantRepository.getAll();
        int id_max = 0;
        for (Restaurant restaurant : restaurante) {
            if (restaurant.getRestaurantID() > id_max) {
                id_max = restaurant.getRestaurantID();
            }
        }
        return id_max;
    }
}
