package services;

import dal.PostDAOImpl;
import entities.Author;
import entities.Post;

import java.util.List;

public class PostService {

    private PostDAOImpl postDAO = new PostDAOImpl();

    public Post getPostById(int id) {
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

    public  List<Post> getAll() {
        return postDAO.getAll();
    }

    public List<Author> getAuthorsByPostId(int id)
        {return postDAO.getAuthorsByPostId(id);}

    public List<Post> findPosts(int currentPage, int pagesPerPage)
    {
        return postDAO.findPosts(currentPage,pagesPerPage);
    }

    public int numberOfPosts()
    {return postDAO.numberOfPost();}
}
