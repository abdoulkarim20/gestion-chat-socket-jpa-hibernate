package org.example.dao;

import java.util.List;

public interface Repository<T> {
    public int create(T t);
    public List<T> getAll();
    public T get(int id);
    public int  update(T t);
    public int delete(int id);
}
