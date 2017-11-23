package Interfaces;

import Entities.Book;
import Entities.IssuedBook;
import Entities.Student;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IssuedBookI {
    IssuedBook viewEachIssued(String regno, String bookId);

    boolean issueBook(IssuedBook issuedBook, Book boo);

    List<IssuedBook> viewIssued();


}
