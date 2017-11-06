package beans;

import javax.persistence.*;

@Entity
@Table(name="music")
public class MusicEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="ismn")
    private String ismn;
    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="album")
    private String album;
    @Column(name="borrowed")
    private boolean borrowed = false;
    @Column(name="borrower")
    private String borrower = "";

    public MusicEntity() {
    }
    public MusicEntity(String ismn, String title, String author, String album) {
        this.ismn = ismn;
        this.title = title;
        this.author = author;
        this.album = album;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getIsmn() {
        return ismn;
    }
    public void setIsmn(String ismn) {
        this.ismn = ismn;
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
