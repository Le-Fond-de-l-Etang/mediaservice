package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="music")
public class Music {
    @Id
    @Column(name="isbn")
    private String isbn;
    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="album")
    private String album;
}
