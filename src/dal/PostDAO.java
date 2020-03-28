package dal;

import entities.Author;
import entities.Post;

import java.util.List;

public interface PostDAO {

    Post getPostById(int id);
    boolean addPost(String postName,String information);
    boolean deletePost(int id);
    boolean updatePost(Post post);
    List<Post> getAll();
    List<Author>getAuthorsByPostId(int id);
    List<Post>findPosts(int currentPage, int recordsPerPage);
    int numberOfPost();
}
