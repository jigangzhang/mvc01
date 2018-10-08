package com.footprint.service;

import java.util.List;

public interface IService<T> {
    void add(T t) throws Exception;
    void delete(int id);
    void update(T t);
    T get(int id);
    List<T> getAll();
}
