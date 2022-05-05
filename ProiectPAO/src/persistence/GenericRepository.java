package persistence;

public interface GenericRepository<T> {
    public void add(T entity);

    public T get(int index);

    public void update(int index, T entity);

    public void delete(int index);

    public int getSize();
}
