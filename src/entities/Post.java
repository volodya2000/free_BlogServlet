package entities;

import java.util.Date;

public class Post {

    private int id;

    private String nameOfPost;

    private String information;

    private String description;

    private Date date;

    private String imageSource;

    private long timeOfCreation;


    public Post() {
    }


    public Post(String nameOfPost) {
        this.nameOfPost = nameOfPost;
    }

    public Post(int id, String nameOfPost,String description,String imageSource) {
        this.id = id;
        this.nameOfPost = nameOfPost;
        this.description=description;
        this.imageSource=imageSource;
    }

    public long getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(long timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
