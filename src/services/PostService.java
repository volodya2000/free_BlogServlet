package services;

import dal.PostDAOImpl;
import entities.Author;
import entities.Post;

import java.util.List;

public class PostService {

    private PostDAOImpl postDAO = new PostDAOImpl();

    Post getPostById(int id) {
        return postDAO.getPostById(id);
    }

    public void addPost(String postName,String information) {
        postDAO.addPost( postName,information);
    }

    void deletePost(int id) {
        postDAO.deletePost(id);
    }

    void updatePost(Post post) {
        postDAO.updatePost(post);
    }

    List<Post> getAll() {
        return postDAO.getAll();
    }

    List<Author> getAuthorsByPostId(int id)
        {return postDAO.getAuthorsByPostId(id);}
}
