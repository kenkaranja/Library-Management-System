package Dao;

import Entities.Librarian;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class LibrarianDao extends CustomDao<Librarian> {

    public LibrarianDao(EntityManager em) {
        super(em);
    }

    public boolean add(Librarian librarian) {
        return this.addCustom(librarian);
    }

    @SuppressWarnings("unchecked")
    public boolean login(Librarian librarian) {
        try {
            List<Librarian> librarianList = em.createNamedQuery("Llogin").setParameter("username", librarian.getUsername()).setParameter("password", librarian.getPassword()).getResultList();
            return librarianList.size() > 0;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }
}
