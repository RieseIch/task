package by.eugen.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

    List<T> findAll();
    T findByPrimaryKey(PK id);
    void add(T t);
    void deleteAll();
    void edit(T t);
}
