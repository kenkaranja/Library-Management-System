package Dao;

import Entities.Book;
import Entities.IssuedBook;
import Exceptions.BookException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

public class IssuedBookDao {

    private EntityManager em;

    public IssuedBookDao(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public IssuedBook viewEachIssued(String regno, String bookId) {
        try {
            List<IssuedBook> issuedBooks = em.createNamedQuery("viewEachIssued").setParameter("regno", regno).setParameter("bookId", bookId).getResultList();
            return issuedBooks.size() > 0 ? issuedBooks.get(0) : null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }


    public boolean issueBook(IssuedBook issuedBook, Book book) {
        try {
            em.merge(book);
            em.persist(issuedBook);

            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }

    }

    @SuppressWarnings("unchecked")
    public List<IssuedBook> viewIssued() {
        try {
            return em.createNamedQuery("viewBorrowed").getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<IssuedBook> viewBorrowed(String regno) throws BookException {
        try {
            return em.createNamedQuery("viewBorrowByStudent").setParameter("regno", regno).getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            throw new BookException("No book Found", e);
        }
    }
}
