package Entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Llogin", query = "select username, password from Librarian where username=:username and password=:password")
})
@Entity
public class Librarian extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String librarianId;
    private String librarianName;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(String librarianId) {
        this.librarianId = librarianId;
    }
}
