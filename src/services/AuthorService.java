package services;

import dal.AuthorDAOImpl;
import entities.Author;
import entities.Post;
import entities.User;

import java.util.List;
import java.util.logging.Logger;

public class AuthorService {

    private AuthorDAOImpl authorDAO=new AuthorDAOImpl();
    private Logger logger = Logger.getLogger(AuthorService.class.toString());

    public void addAuthor(User user,String name,String surname)
        {authorDAO.addAuthor(user,name,surname);}

    int getNumberOfPublicationsByAuthorId(int id)
         {return authorDAO.getNumberOfPublicationsByAuthorId(id);}

    void deleteAuthor(int id)
        {authorDAO.deleteAuthor(id);}

    void updateAuthor(Author author)
        {authorDAO.updateAuthor(author);}

    Author getAuthorById(int id)
        {return authorDAO.getAuthorById(id);}

    List<Author> getAll()
        {return authorDAO.getAll();}

    List<Post>getAllPublicationsByAuthorId(int id)
        {return authorDAO.getAllPublicationsByAuthorId(id);}
}
