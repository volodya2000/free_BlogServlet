package entities;

import java.sql.Date;
import java.util.List;

public class Publication {

    private int id;

    private int user_id;

    private int author_id;

    private Date dateOfCreation;

    private List<Author> authors;

    public Publication(){}

    public Publication(int user_id, int author_id, Date dateOfCreation) {
        this.user_id = user_id;
        this.author_id = author_id;
        this.dateOfCreation = dateOfCreation;
    }

    public Publication(int id, int user_id, int author_id, Date dateOfCreation) {
        this.id = id;
        this.user_id = user_id;
        this.author_id = author_id;
        this.dateOfCreation = dateOfCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
