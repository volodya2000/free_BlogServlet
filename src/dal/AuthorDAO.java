package dal;

import entities.Author;
import entities.Post;
import entities.Publication;
import entities.User;

import java.util.List;

public interface AuthorDAO {

    List<Post> getAllPublicationsByAuthorId(int id);
    int getNumberOfPublicationsByAuthorId(int id);
    boolean addAuthor(User user,String name,String surname);
    boolean deleteAuthor(int id);
    boolean updateAuthor(Author author);
    Author getAuthorById(int id);
    List<Author> getAll();
}
