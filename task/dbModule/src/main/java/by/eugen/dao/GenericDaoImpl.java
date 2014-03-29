
package by.eugen.dao;

import by.eugen.daoExceptions.DaoExceptions;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;
import java.util.List;


public abstract class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {


    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    private Class<T> persistentClass;


    public GenericDaoImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Transactional(readOnly = true)
    public List<T> findAll() throws DaoExceptions {
        List<T> list;
        Criteria criteria;
        try {
            criteria = getCriteria();
            list = criteria.list();
        } catch (HibernateException e) {
            throw new DaoExceptions("Error in GenericDaoImpl, find all entities failed.", e);
        }
        return list;
    }

    @Transactional(readOnly = true)
    public T findByPrimaryKey(PK id) throws DaoExceptions {
        T t;
        try {
            t = (T) getSession().get(persistentClass, id);
        } catch (HibernateException e) {
            throw new DaoExceptions("Error in GenericDaoImpl, find by primary key of entity failed.", e);
        }
        return t;
    }

    @Transactional
    public void add(T t) throws DaoExceptions {
        try {
            getSession().persist(t);
        } catch (HibernateException e) {
            throw new DaoExceptions("Error in GenericDaoImpl, add entity failed.", e);
        }
    }

    @Transactional
    public void edit(T t) throws DaoExceptions {
        try {
            getSession().merge(t);
        } catch (HibernateException e) {
            throw new DaoExceptions("Error in GenericDaoImpl, edit entity failed.", e);
        }
    }

    @Transactional
    public void deleteAll() throws DaoExceptions {
        Query query;
        try {
            query = getQuery("delete from " + persistentClass.getSimpleName());
            query.executeUpdate();
        } catch (HibernateException e) {
            throw new DaoExceptions("Error in GenericDaoImpl, delete entity failed.", e);
        }
    }

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }

    public Criteria getCriteria() throws DaoExceptions {
        Criteria criteria = getSession().createCriteria(persistentClass);
        return criteria;
    }

    public Query getQuery(String hql) throws DaoExceptions {
        Query query = getSession().createQuery(hql);
        return query;
    }

    public Query getNamedQuery(String hql) throws DaoExceptions {
        Query query = getSession().getNamedQuery(hql);
        return query;
    }

    public T getFirst(List<T> list) {
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }


}