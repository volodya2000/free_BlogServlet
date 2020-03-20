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
    boolean deleteAuthorByUserId(int id);
    boolean updateAuthor(Author author);
    Author getAuthorByUserId(int id);
    List<Author> getAll();
    boolean isAuthorExist(int userID);
}
