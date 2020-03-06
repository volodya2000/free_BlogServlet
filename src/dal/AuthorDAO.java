package dal;

import entities.Author;
import entities.Post;
import entities.User;

import java.util.List;

public interface AuthorDAO {

    List<Post> getAllPublicationsByAuthorId(int id);
    int getNumberOfPublicationsByAuthorId(int id);
    boolean addAuthor(User user,Author futureAuthor);
    boolean deleteAuthor(int id);
    boolean updateAuthor(Author author);
    Author getAuthorById(int id);
    List<Author> getAll();
}
