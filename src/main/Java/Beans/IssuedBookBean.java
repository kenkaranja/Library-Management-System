package Beans;

import Dao.IssuedBookDao;
import Entities.Book;
import Entities.IssuedBook;
import Interfaces.IssuedBookI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class IssuedBookBean implements IssuedBookI {
    @PersistenceContext
    private EntityManager em;

    public IssuedBook viewEachIssued(String regno, String bookId) {
        IssuedBookDao issuedBookDao = new IssuedBookDao(em);
        return issuedBookDao.viewEachIssued(regno, bookId);
    }

    public boolean issueBook(IssuedBook issuedBook, Book book) {
        IssuedBookDao issuedBookDao = new IssuedBookDao(em);
        return issuedBookDao.issueBook(issuedBook, book);
    }

    public List<IssuedBook> viewIssued() {
        IssuedBookDao issuedBookDao = new IssuedBookDao(em);
        return issuedBookDao.viewIssued();
    }
}
