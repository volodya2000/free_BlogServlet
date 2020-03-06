package dal;

import entities.Post;

import java.util.List;

public interface PostDAO {

    Post getPostById(int id);
    boolean addPost(Post post);
    boolean deletePost(int id);
    boolean updatePost(Post post);
    List<Post> getAll();
}
