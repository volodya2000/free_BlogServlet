package entities;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private int id;

    private int user_id;

    private int numberOfPublication;

    private String name;

    private String surname;

    private List<Post> authorPublication = new ArrayList<>();


    public Author() {
    }

    public Author(int user_id, int numberOfPublication, String name, String surname) {
        this.user_id = user_id;
        this.numberOfPublication = numberOfPublication;
        this.name = name;
        this.surname = surname;
    }

    public Author(int id, int user_id, int numberOfPublication, String name, String surname) {
        this.id = id;
        this.user_id = user_id;
        this.numberOfPublication = numberOfPublication;
        this.name = name;
        this.surname = surname;
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

    public int getNumberOfPublication() {
        return numberOfPublication;
    }

    public void setNumberOfPublication(int numberOfPublication) {
        this.numberOfPublication = numberOfPublication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Post> getAuthorPublication() {
        return authorPublication;
    }

    public void setAuthorPost(List<Post> authorPublication) {
        this.authorPublication = authorPublication;
    }
}
