package Entities;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = "viewEachReturnInfo", query = "select i from ReturnInfo i where i.issuedBook.student.regNo=:regno and i.issuedBook.book.bookId=:bookId"),
})
@Entity
public class ReturnInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private IssuedBook issuedBook;
    private java.util.Date todayDate;
    private int late;
    private float lateFee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(Date todayDate) {
        this.todayDate = todayDate;
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }

    public float getLateFee() {
        return lateFee;
    }

    public void setLateFee(float lateFee) {
        this.lateFee = lateFee;
    }


    public IssuedBook getIssuedBook() {
        return issuedBook;
    }

    public void setIssuedBook(IssuedBook issuedBook) {
        this.issuedBook = issuedBook;
    }

}
