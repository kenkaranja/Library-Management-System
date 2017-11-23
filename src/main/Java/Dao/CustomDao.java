package Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

class CustomDao<T> {
    final EntityManager em;

    CustomDao(EntityManager em) {
        this.em = em;
    }

    boolean addCustom(T t) {
        try {
            em.persist(t);
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

}
