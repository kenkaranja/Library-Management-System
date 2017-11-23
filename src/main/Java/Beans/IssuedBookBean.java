package Beans;

import Dao.IssuedBookDao;
import Entities.Book;
import Entities.IssuedBook;
import Entities.Student;
import Exceptions.BookException;
import Interfaces.BookI;
import Interfaces.IssuedBookI;
import Interfaces.StudentI;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class IssuedBookBean implements IssuedBookI {
    @EJB
    private StudentI studentI;
    @EJB
    private BookI bookI;
    @PersistenceContext
    private EntityManager em;

    public IssuedBook viewEachIssued(String regno, String bookId) {
        IssuedBookDao issuedBookDao = new IssuedBookDao(em);
        return issuedBookDao.viewEachIssued(regno, bookId);
    }

    public boolean issueBook(IssuedBook issuedBook, Book book) {
        try {
            if (bookI.viewById(book) != null) {
                IssuedBookDao issuedBookDao = new IssuedBookDao(em);
                return issuedBookDao.issueBook(issuedBook, book);
            } else {
                return false;
            }
        } catch (BookException e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<IssuedBook> viewIssued() {
        IssuedBookDao issuedBookDao = new IssuedBookDao(em);
        return issuedBookDao.viewIssued();
    }
}
