package Entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "viewById", query = "select s from Student s where s.regNo=:regNo"),
        @NamedQuery(name = "Slogin", query = "select regNo,password from Student s where s.regNo=:username and s.password=:password"),
        @NamedQuery(name = "viewAll", query = "select s from Student  s")
})


@Entity
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String regNo;
    private String name;
    private String yearOfStudy;
    private String department;
    private String contact;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
