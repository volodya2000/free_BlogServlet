package entities;

public class Post {

    private int id;

    private String nameOfPost;

    private String information;

    public Post() {
    }


    public Post(String nameOfPost) {
        this.nameOfPost = nameOfPost;
    }

    public Post(int id, String nameOfPost) {
        this.id = id;
        this.nameOfPost = nameOfPost;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfPost() {
        return nameOfPost;
    }

    public void setNameOfPost(String nameOfPost) {
        this.nameOfPost = nameOfPost;
    }
}
