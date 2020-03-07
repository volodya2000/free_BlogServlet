package entities;

import java.sql.Date;
import java.util.List;

public class Publication {

    private int id;

    private int post_id;

    private int author_id;

    private String dateOfCreation;

    private List<Author> authors;

    public Publication(){}

    public Publication(int post_id, int author_id, String dateOfCreation) {
        this.post_id = post_id;
        this.author_id = author_id;
        this.dateOfCreation = dateOfCreation;
    }

    public Publication(int id, int post_id, int author_id, String dateOfCreation) {
        this.id = id;
        this.post_id = post_id;
        this.author_id = author_id;
        this.dateOfCreation = dateOfCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost_id() { return post_id; }

    public void setPost_id(int post_id) { this.post_id = post_id; }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
