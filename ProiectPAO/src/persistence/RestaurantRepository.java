package persistence;

import domain.Restaurant;

public class RestaurantRepository implements GenericRepository<Restaurant> {
    private Restaurant[] restaurante = new Restaurant[10];
    private int nr_restaurante = 0;

    @Override
    public void add(Restaurant entity) {
        restaurante[nr_restaurante] = entity;
        nr_restaurante++;
    }

    @Override
    public Restaurant get(int index) {
        return restaurante[index];
    }

    @Override
    public void update(int index, Restaurant entity) {
        restaurante[index] = entity;
    }

    @Override
    public void delete(int index) {
        for (int i = index; i < nr_restaurante - 1; i++) {
            restaurante[i] = restaurante[i + 1];
        }
        nr_restaurante--;
    }

    @Override
    public int getSize() {
        return nr_restaurante;
    }
}
