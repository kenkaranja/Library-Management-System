package Servlets;

import Entities.Book;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class CustomAddBook extends Custom {
    public Book addBook(HttpServletRequest req) {
        Book book = new Book();
        book.setAddedDate(Date.valueOf((get(req, "addeddate"))));
        book.setAuthor(get(req, "author"));
        book.setBookId(get(req, "bookid"));
        book.setBookName(get(req, "bname"));
        book.setCategory(get(req, "category"));
        book.setShelfNo(get(req, "shelfno"));
        book.setColumNo(get(req, "column"));
        book.setEdition(get(req, "edition"));
        book.setIsbn(get(req, "isbn"));
        book.setRowNo(get(req, "row"));
        book.setPrice(Float.parseFloat(get(req, "price")));
        book.setAvailable("yes");
        return book;
    }
}
