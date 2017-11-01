package Beans;

import Dao.BookDao;
import Dao.IssuedBookDao;
import Dao.StudentDao;
import Entities.Book;
import Entities.IssuedBook;
import Entities.Student;
import Exceptions.BookException;
import Interfaces.StudentI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class StudentBean implements StudentI {
    @PersistenceContext
    private EntityManager em;

    public boolean register(Student student) {
        return false;
    }

    public boolean login(Student s) {
        StudentAuth studentAuth = new StudentAuth();
        return studentAuth.login(s);
    }

    public boolean add(Student student) {
        StudentDao studentDao = new StudentDao(em);
        return studentDao.add(student);
    }

    public Student viewById(Student student) {
        StudentDao studentDao = new StudentDao(em);
        return studentDao.viewById(student);
    }

    public List<Student> viewAll() {
        StudentDao studentDao = new StudentDao(em);
        return studentDao.viewAll();
    }

    public List<Book> viewAvailable() throws BookException {
        BookDao bookDao = new BookDao(em);
        return bookDao.viewAvailable();
    }

    public List<IssuedBook> viewBorrowed(String regno) throws BookException {
        IssuedBookDao issuedBookDao = new IssuedBookDao(em);
        return issuedBookDao.viewBorrowed(regno);
    }

    public List<Book> viewBookByName(Book book) throws BookException {
        BookDao bookDao = new BookDao(em);
        return bookDao.viewBookByName(book);
    }
}
