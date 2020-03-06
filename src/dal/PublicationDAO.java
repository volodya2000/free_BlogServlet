package dal;

import entities.Publication;

import java.util.List;

public interface PublicationDAO {

    List<Publication> getAll();
    boolean createPublication();
    boolean deletePublication();
}
