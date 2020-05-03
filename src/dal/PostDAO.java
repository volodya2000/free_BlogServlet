package dal;

import entities.Author;
import entities.Post;
import javafx.geometry.Pos;

import java.util.List;

public interface PostDAO {

    Post getPostById(int id);
    List<Post> getPostByName(String name);
    boolean addPost(Post post);
    boolean deletePost(int id);
    boolean updatePost(Post post);
    List<Post> getAll();
    List<Author>getAuthorsByPostId(int id);
    List<Post>findPosts(int currentPage, int recordsPerPage);
    int numberOfPost();
}
