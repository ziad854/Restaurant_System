package System;


public interface Crud<T> {
    boolean add(T entity);
    boolean delete(int id);

    boolean update(int id,T entity);
    void list();

    String search(String Name);
    boolean Check_ID(int id);
}
