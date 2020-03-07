package dal;

import entities.Publication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PublicationDAOImpl implements PublicationDAO {

    private Logger logger= Logger.getLogger(PublicationDAOImpl.class.toString());

    @Override
    public List<Publication> getAll() {
        List<Publication> publications= new ArrayList<>();
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;

        final String sql="SELECT * FROM publication;";

        try{
            logger.info("Opening connection!");
            connection=ConnectionFactory.getConnection();
                try {
                    logger.info("Creating statement!");
                    statement = connection.prepareStatement(sql);
                    statement.execute();
                    resultSet = statement.executeQuery();
                    while (resultSet.next())
                    {
                        publications.add(extractPublicationFromResultSet(resultSet));
                    }
                    return publications;
                }catch (SQLException ex)
                {
                    ex.printStackTrace();
                }finally {
                    try {
                        logger.info("Closing statement!");
                        statement.close();
                    } catch (SQLException ex)
                    {
                        logger.info("Closing statement error!");
                        ex.printStackTrace();
                    }
                }
        }finally {
            try {
                logger.info("Closing connection!");
                connection.close();
            }catch (SQLException ex)
            {
                logger.info("Closing connection error!");
                ex.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public boolean addPublication(int postId, int authorId) {

        Connection connection =null;
        PreparedStatement statement=null;

        final String sql="INSERT INTO publication (post_id," +
                "author_id,date_of_creation) values (?,?,?);";
        try {
                logger.info("Opening connection!");
                connection=ConnectionFactory.getConnection();
                    try {
                        logger.info("Creating statement!");
                        statement=connection.prepareStatement(sql);
                        statement.setInt(1,postId);
                        statement.setInt(2,authorId);
                        statement.setString(3,
                                LocalDateTime.of(LocalDate.now(), LocalTime.now()).toString());
                        return statement.executeUpdate()==1;
                    }
                    catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }finally {
                        try{
                            logger.info("Closing statemenr!");
                            statement.close();
                        }catch (SQLException ex)
                        {
                            logger.info("Closing statement error!");
                            ex.printStackTrace();
                        }
                    }
        }finally {
            try {
                logger.info("Closing connection!");
                connection.close();
            } catch (SQLException ex)
            {
                logger.info("Closing connection error!");
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean deletePublication() {
        return false;
    }

    @Override
    public boolean updatePublication() {
        return false;
    }


    private Publication extractPublicationFromResultSet(ResultSet rs) throws SQLException {

        try {
            Publication publication=new Publication();
            publication.setId(rs.getInt("publication_id"));
            publication.setPost_id(rs.getInt("post_id"));
            publication.setAuthor_id(rs.getInt("author_id"));
            publication.setDateOfCreation(rs.getString("date_of_creation"));
            return publication;
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
