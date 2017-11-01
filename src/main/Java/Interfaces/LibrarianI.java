package Interfaces;

import Entities.*;
import Exceptions.BookException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface LibrarianI {
    boolean add(Librarian librarian);

    List<Book> viewAll() throws BookException;

    List<IssuedBook> viewIssued();



}
