package dal;

import entities.Publication;

import java.util.List;

public interface PublicationDAO {

    List<Publication> getAll();
    boolean addPublication(int postId,int authorId);
    boolean deletePublication();
    boolean updatePublication();
}
