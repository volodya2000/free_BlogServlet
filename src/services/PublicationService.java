package services;

import dal.PublicationDAOImpl;
import entities.Publication;

import java.util.List;

public class PublicationService {

    private PublicationDAOImpl publicationDAO = new PublicationDAOImpl();

    List<Publication> getAll()
        {return publicationDAO.getAll();}

    void addPublication(int postId,int authorId)
        {publicationDAO.addPublication(postId,authorId);}
}
