package com.footprint.dao;

import java.util.List;

public interface IBaseDao<T> {
    void add(T t);
    void delete(int id);
    void update(T t);
    T get(int id);
    List<T> getAll();
}
