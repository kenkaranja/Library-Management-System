package Entities;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = "viewEachReturnInfo", query = "select i from ReturnInfo i where i.issuedBook.student.regNo=:regno and i.issuedBook.book.bookId=:bookId"),
        @NamedQuery(name = "viewDebtInfo", query = "select r from ReturnInfo r where r.issuedBook.student.regNo=:regno and r.paid='no'"),
        @NamedQuery(name = "viewDebt", query = "select  SUM(r.lateFee) from ReturnInfo r where r.paid='no' and r.issuedBook.student.regNo=:regno"),
        @NamedQuery(name = "viewAllDebt", query = "select  r from ReturnInfo r where r.paid='no'")
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
    private float amountPaid;
    private String paid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public IssuedBook getIssuedBook() {
        return issuedBook;
    }

    public void setIssuedBook(IssuedBook issuedBook) {
        this.issuedBook = issuedBook;
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

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }
}
