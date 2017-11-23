package Interfaces;

import Entities.*;
import Exceptions.BookException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface LibrarianI {
    boolean add(Librarian librarian);

    boolean addBook(Book book);

    List<Book> viewAll() throws BookException;

    List<IssuedBook> viewIssued();

    List<ReturnInfo> viewDebtInfo(ReturnInfo returnInfo);

    ReturnInfo viewDebtInfoO(ReturnInfo returnInfo);


}
