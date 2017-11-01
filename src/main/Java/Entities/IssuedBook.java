package Entities;

import javax.persistence.*;
import java.sql.Date;

@NamedQueries({

        @NamedQuery(name = "viewBorrowByStudent", query = "select b from IssuedBook b  where b.returnStatus='no' and b.student.regNo=:regno"),
        @NamedQuery(name = "viewBorrowed", query = "select s from  IssuedBook s where returnStatus='no' "),
        @NamedQuery(name = "viewEachIssued", query = "select i from IssuedBook i where i.student.regNo=:regno and i.book.bookId=:bookId and returnStatus='no'"),


})
@Entity
public class IssuedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Student student;
    private Date issueDate;
    private Date returnDate;
    private String returnStatus;

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

