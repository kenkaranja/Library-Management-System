package Beans;

import Dao.*;
import Entities.*;
import Exceptions.BookException;
import Interfaces.BookI;
import Interfaces.LibrarianI;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class LibrarianBean implements LibrarianI {
    @EJB
    private BookI bookI;

    @PersistenceContext
    private EntityManager em;

    public boolean add(Librarian librarian) {
        LibrarianDao librarianDao = new LibrarianDao(em);
        return librarianDao.add(librarian);
    }

    public boolean addBook(Book book) {
        return bookI.add(book);
    }

    public List<Book> viewAll() throws BookException {
        return bookI.viewAll();
    }

    public List<IssuedBook> viewIssued() {
        IssuedBookDao issuedBookDao = new IssuedBookDao(em);
        return issuedBookDao.viewIssued();
    }


    public IssuedBook viewEachIssued(String regNo, String bookId) {
        IssuedBookDao issuedBookDao = new IssuedBookDao(em);
        return issuedBookDao.viewEachIssued(regNo, bookId);
    }

    public List<ReturnInfo> viewDebtInfo(ReturnInfo returnInfo) {
        ReturnInfoDao returnInfoDao = new ReturnInfoDao(em);
        return returnInfoDao.viewDebtInfo(returnInfo);
    }

    public ReturnInfo viewDebtInfoO(ReturnInfo returnInfo) {
        ReturnInfoDao returnInfoDao = new ReturnInfoDao(em);
        return returnInfoDao.viewDebtInfoO(returnInfo);
    }
}
