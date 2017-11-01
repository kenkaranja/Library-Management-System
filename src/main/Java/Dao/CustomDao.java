package Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class CustomDao<T> {
    EntityManager em;

    public CustomDao(EntityManager em) {
        this.em = em;
    }

    public boolean addCustom(T t) {
        try {
            em.persist(t);
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

}
