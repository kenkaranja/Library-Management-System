package Interfaces;

import Entities.AuditTrail;
import Entities.Book;
import Entities.IssuedBook;
import Entities.Student;
import Exceptions.BookException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StudentI {
    boolean add(Student student);

    Student viewById(Student student);

    List<Student> viewAll();

    List<Book> viewAvailable() throws BookException;

    List<IssuedBook> viewBorrowed(String regno) throws BookException;

    List<Book> viewBookByName(Book book) throws BookException;



}
