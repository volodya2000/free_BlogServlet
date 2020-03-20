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

    public int getNumberOfPublicationsByAuthorId(int id)
         {return authorDAO.getNumberOfPublicationsByAuthorId(id);}

    public void deleteAuthorByUserId(int id)
        {authorDAO.deleteAuthorByUserId(id);}

    public void updateAuthor(Author author)
        {authorDAO.updateAuthor(author);}

    public Author getAuthorByUserId(int id)
        {return authorDAO.getAuthorByUserId(id);}

    public List<Author> getAll()
        {return authorDAO.getAll();}

    public List<Post>getAllPublicationsByAuthorId(int id)
        {return authorDAO.getAllPublicationsByAuthorId(id);}

    public boolean isAuthorExist(int userId)
    {return authorDAO.isAuthorExist(userId);}
}
