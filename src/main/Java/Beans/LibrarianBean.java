package Beans;

import Dao.*;
import Entities.*;
import Events.AuditTrailEvent;
import Exceptions.BookException;
import Interfaces.LibrarianI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class LibrarianBean implements LibrarianI {
    @PersistenceContext
    private EntityManager em;

    public boolean add(Librarian librarian) {
        LibrarianDao librarianDao = new LibrarianDao(em);
        return librarianDao.add(librarian);
    }

    public List<Book> viewAll() throws BookException {
        BookDao bookDao = new BookDao(em);
        return bookDao.viewAll();
    }

    public List<IssuedBook> viewIssued() {
        IssuedBookDao issuedBookDao = new IssuedBookDao(em);
        return issuedBookDao.viewIssued();
    }


    public IssuedBook viewEachIssued(String regNo, String bookId) {
        IssuedBookDao issuedBookDao = new IssuedBookDao(em);
        return issuedBookDao.viewEachIssued(regNo, bookId);
    }

}
