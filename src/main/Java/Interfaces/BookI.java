package Interfaces;

import Entities.Book;
import Entities.IssuedBook;
import Entities.ReturnInfo;
import Exceptions.BookException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BookI {
    boolean add(Book book);

    boolean update(Book book) throws BookException;

    boolean deleteBook(Book book) throws BookException;

    Book viewById(Book book) throws BookException;

    List<Book> viewByCategory(Book book) throws BookException;

    List<Book> viewByName(Book book) throws BookException;

    List<Book> viewAll() throws BookException;

    boolean returnBook(Book book, IssuedBook issuedBook) throws BookException;

    List<Book> viewBookById(Book book) throws BookException;



}
