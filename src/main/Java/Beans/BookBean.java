package Beans;

import Dao.BookDao;
import Dao.IssuedBookDao;
import Entities.Book;
import Entities.IssuedBook;
import Entities.ReturnInfo;
import Exceptions.BookException;
import Interceptor.RecordReturnInfo;
import Interfaces.BookI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless

public class BookBean implements BookI {
    @PersistenceContext
    private EntityManager em;

    public boolean add(Book book) {
        BookDao bookDao = new BookDao(em);
        return bookDao.add(book);
    }

    public Book viewById(Book book) throws BookException {
        BookDao bookDao = new BookDao(em);
        return bookDao.viewById(book);
    }


    public List<Book> viewAll() throws BookException {
        BookDao bookDao = new BookDao(em);
        return bookDao.viewAll();
    }


    public boolean returnBook(Book book, IssuedBook issuedBook) throws BookException {
        BookDao bookDao = new BookDao(em);
        return bookDao.returnBook(book, issuedBook);
    }

    public boolean update(Book book) throws BookException {
        BookDao bookDao = new BookDao(em);
        return bookDao.update(book);
    }

    public boolean deleteBook(Book book) throws BookException {
        BookDao bookDao = new BookDao(em);
        return bookDao.deleteBook(book);
    }

    public List<Book> viewBookById(Book book) throws BookException {
        BookDao bookDao = new BookDao(em);
        return bookDao.viewBookById(book);
    }

    public List<Book> viewByCategory(Book book) throws BookException {
        BookDao bookDao = new BookDao(em);
        return bookDao.viewByCategory(book);
    }

    public List<Book> viewByName(Book book) throws BookException {
        BookDao bookDao = new BookDao(em);
        return bookDao.viewBookByName(book);
    }
}
