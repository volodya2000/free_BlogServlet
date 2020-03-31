package services;

import dal.PostDAOImpl;
import entities.Author;
import entities.Post;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PostService {

    private PostDAOImpl postDAO = new PostDAOImpl();

    public Post getPostById(int id) {
        return postDAO.getPostById(id);
    }

    public void addPost(Post post) {
        postDAO.addPost(post);
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

    public List<Post> getLatestNews()
    {
        List<Post> latest= getAll().stream().sorted((post1,post2)->(post2.getDate().compareTo(post1.getDate()))).limit(9).collect(Collectors.toList());
        return latest;
    }

    public List<Post>getPostByName(String name)
    {return postDAO.getPostByName(name);}
}
