package Dao;

import Entities.Book;
import Entities.IssuedBook;
import Exceptions.BookException;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class BookDao extends CustomDao<Book> {
    private final Logger logger = Logger.getLogger(BookDao.class);

    public BookDao(EntityManager em) {
        super(em);
    }

    public boolean add(Book book) {
        return this.addCustom(book);
    }

    @SuppressWarnings("unchecked")
    public Book viewById(Book book) throws BookException {
        try {
            List<Book> bookList = em.createNamedQuery("viewBookById").setParameter("bookId", book.getBookId()).getResultList();
            return bookList.size() > 0 ? bookList.get(0) : null;
        } catch (PersistenceException e) {
            logger.warn(e.getMessage());
            return null;
        } catch (Exception e) {
            throw new BookException("unable to view by id", e);
        }

    }

    @SuppressWarnings("unchecked")
    public List<Book> viewBookById(Book book) throws BookException {
        try {
            return em.createNamedQuery("viewBookById").setParameter("bookId", book.getBookId()).getResultList();
        } catch (PersistenceException e) {
            logger.warn(e.getMessage());
            return null;
        } catch (Exception e) {
            throw new BookException("unable to view by id", e);
        }

    }

    @SuppressWarnings("unchecked")
    public List<Book> viewBookByName(Book book) throws BookException {
        try {
            return em.createNamedQuery("viewBookByName").setParameter("bookName", "%" + book.getBookName() + "%").getResultList();
        } catch (PersistenceException e) {
            logger.warn(e.getMessage());
            return null;
        } catch (Exception e) {
            throw new BookException("unable to view by Name For That Book", e);
        }

    }

    @SuppressWarnings("unchecked")
    public List<Book> viewAll() throws BookException {
        try {
            return em.createNamedQuery("viewAllBook").getResultList();
        } catch (PersistenceException e) {
            logger.warn(e.getMessage());
            return null;
        } catch (Exception e) {
            throw new BookException("Unable to View", e);
        }


    }

    public boolean update(Book book) throws BookException {
        try {
            em.merge(book);
            return true;
        } catch (PersistenceException e) {
            logger.warn(e.getMessage());
            return false;
        } catch (Exception ex) {
            throw new BookException("Unable to Udate Reason", ex);
        }

    }

    public boolean deleteBook(Book book) throws BookException {
        try {
            em.remove(em.merge(book));
            return true;
        } catch (PersistenceException ex) {
            logger.warn(ex.getMessage());
            return false;
        } catch (Exception e) {
            throw new BookException("Problem Occured Deleting a book", e);

        }
    }

    @SuppressWarnings("unchecked")
    public List<Book> viewByCategory(Book book) throws BookException {
        try {
            return em.createNamedQuery("viewBookByCategory").setParameter("category", book.getCategory()).getResultList();
        } catch (PersistenceException e) {
            logger.warn(e.getMessage());
            return null;
        } catch (Exception e) {
            throw new BookException("unable to view by id", e);
        }
    }

    public boolean returnBook(Book book, IssuedBook issuedBook) throws BookException {
        try {
            em.merge(issuedBook);
            em.merge(book);
            return true;
        } catch (PersistenceException e) {
            logger.warn(e.getMessage());
            return true;
        } catch (Exception e) {
            throw new BookException("unable to view by id", e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Book> viewAvailable() throws BookException {
        String available = "yes";
        try {
            return em.createNamedQuery("viewAvailable").setParameter("available", available).getResultList();
        } catch (PersistenceException e) {
            logger.warn(e);
            return null;
        } catch (Exception e) {
            throw new BookException("unable to view by id", e);
        }
    }


}


