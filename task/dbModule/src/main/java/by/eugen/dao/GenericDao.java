package by.eugen.dao;

import by.eugen.daoExceptions.DaoExceptions;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

    List<T> findAll() throws DaoExceptions;
    T findByPrimaryKey(PK id) throws DaoExceptions;
    void add(T t) throws DaoExceptions;
    void deleteAll() throws DaoExceptions;
    void edit(T t) throws DaoExceptions;
}
