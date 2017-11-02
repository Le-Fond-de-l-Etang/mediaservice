package beans;

import javax.persistence.*;

@Entity
@Table(name="music")
public class Music {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="isbn")
    private String isbn;
    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="album")
    private String album;
    @Column(name="borrowed")
    private boolean borrowed;
    @Column(name="borrower")
    private String borrower;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }

    public boolean isBorrowed() {
        return borrowed;
    }
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getBorrower() {
        return borrower;
    }
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }
}
