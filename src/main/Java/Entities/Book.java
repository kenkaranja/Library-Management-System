package Entities;

import javax.persistence.*;
import java.sql.Date;

@NamedQueries({

        @NamedQuery(name = "viewBookById", query = "select b from Book b where b.bookId=:bookId"),
        @NamedQuery(name = "viewBookByName", query = "select b from Book b where b.bookName like lower(:bookName) and b.available='yes'"),
        @NamedQuery(name = "viewAvailable", query = "select b from Book b  where b.available=:available"),
        @NamedQuery(name = "viewBorrow", query = "select b from Book b  where b.available='no'"),
        @NamedQuery(name = "viewAllBook", query = "select  b from  Book  b"),
        @NamedQuery(name = "updateBook", query = "update Book set bookId=:bookId, bookName=:bname,author=:author"),
        @NamedQuery(name = "viewBookByCategory", query = "select b from Book b where b.category=:category")

})
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String bookId;
    private String isbn;
    private String bookName;
    private String author;
    private String edition;
    private String category;
    private String shelfNo;
    private String rowNo;
    private String columNo;
    private String available;
    private float price;
    private Date addedDate;
    private String photo;

    public String getPhoto() {
        return photo;
    }


    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }


    public String getRowNo() {
        return rowNo;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void setRowNo(String rowNo) {
        this.rowNo = rowNo;
    }

    public String getColumNo() {
        return columNo;
    }

    public void setColumNo(String columNo) {
        this.columNo = columNo;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getShelfNo() {
        return shelfNo;
    }

    public void setShelfNo(String shelfNo) {
        this.shelfNo = shelfNo;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public float getPrice() {
        return price;
    }
}
