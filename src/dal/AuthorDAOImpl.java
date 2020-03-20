package dal;

import entities.Author;
import entities.Post;
import entities.Publication;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AuthorDAOImpl implements AuthorDAO {

    private static int counter=0;
    private Logger logger=Logger.getLogger(AuthorDAOImpl.class.toString());

    @Override
    public boolean isAuthorExist(int userID) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;

        final String sql="SELECT * FROM author WHERE user_id=?;";
        try {
            connection=ConnectionFactory.getConnection();
            try{
                statement=connection.prepareStatement(sql);
                statement.setInt(1,userID);
                resultSet=statement.executeQuery();
                if(resultSet.next())
                {
                    return true;
                }
            }catch (SQLException ex)
            {
                ex.printStackTrace();
            }finally {
                try{
                    statement.close();
                }catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        finally {
            try{
                logger.info("CLosing connection");
                connection.close();
            }catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Post> getAllPublicationsByAuthorId(int id) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Post> posts=new ArrayList<>();

        final String sql="SELECT * FROM post " +
                "INNER JOIN publication p on post.post_id = p.post_id WHERE p.author_id=?;";

        try
        {
            logger.info("Opening connection!");
            connection=ConnectionFactory.getConnection();
            try {
                logger.info("Creating statement!");
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                resultSet = statement.executeQuery();
                while(resultSet.next())
                {
                    posts.add(extractPostFromResultSet(resultSet));
                }
                return posts;
            }catch (SQLException ex)
            {
                ex.printStackTrace();
            }
            finally {
                try{
                    logger.info("Closing statement!");
                    statement.close();
                }
                catch (SQLException ex)
                {
                    logger.info("Closing statement error!");
                    ex.printStackTrace();
                }
            }
        }
        finally {
            try{
                logger.info("Closing connection!");
                connection.close();
            }catch (SQLException ex)
            {
                logger.info("Closing connection error!");
                ex.printStackTrace();
            }


            return null;
    }
    }

    @Override
    public int getNumberOfPublicationsByAuthorId(int id) {

        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;

        final String sql ="SELECT COUNT(num_publications) FROM author " +
                "WHERE author_id=?;";

        try
            {
                logger.info("Opening connection!");
                connection=ConnectionFactory.getConnection();
                    try {
                        logger.info("Creating statement!");
                        statement = connection.prepareStatement(sql);
                        statement.setInt(1, id);
                        statement.execute();
                        resultSet = statement.executeQuery();
                        if (resultSet!=null)
                        {
                            return extractAuthorFromResultSet(resultSet).getNumberOfPublication();
                        }
                    }catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }
                    finally {
                        try{
                            logger.info("Closing statement!");
                            statement.close();
                        }
                        catch (SQLException ex)
                        {
                            logger.info("Closing statement error!");
                            ex.printStackTrace();
                        }
                    }
            }
            finally {
            try{
                logger.info("Closing connection!");
                connection.close();
            }catch (SQLException ex)
            {
                logger.info("Closing connection error!");
                ex.printStackTrace();
            }
        }

        return 0;
    }

    @Override
    public boolean addAuthor(User user,String name,String surname) {

        Connection connection=null;
        PreparedStatement statement=null;
        final String sql ="INSERT INTO author(user_id,num_publications,name,surname)" +
                " VALUES(?,?,?,?);";

        try {
            logger.info("Opening connection!");
            connection=ConnectionFactory.getConnection();

                try
                {
                    ++counter;
                    logger.info("COUNTER= "+counter);
                    statement=connection.prepareStatement(sql);
                    statement.setInt(1,user.getId());
                    statement.setInt(2,0);
                    statement.setString(3,name);
                    statement.setString(4,surname);
                    int result=statement.executeUpdate();
                    if(result==1)
                    {
                        logger.info("Author with name: "+
                                name+ " is created!");
                        return true;
                    }
                }catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
                finally {
                    try{
                        logger.info("Closing statemenr!");
                        statement.close();
                    }
                    catch (SQLException ex)
                    {
                        logger.info("Closing statement error!");
                        ex.printStackTrace();
                    }
                }

        }finally {
            try {
                logger.info("Closing connection!");
                connection.close();
            }
            catch (SQLException ex)
            {
                logger.info("Closing connection error!");
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean deleteAuthorByUserId(int id) {

        Connection connection=null;
        PreparedStatement statement=null;

//        final String sql = "DELETE author,publication " +
//                "FROM author INNER JOIN publication  ON publication.author_id =author.author_id" +
//                " WHERE author.author_id=?;";

        final String sql ="DELETE FROM author WHERE user_id=?;";

        try {
                logger.info("Creating connection!");
                connection=ConnectionFactory.getConnection();
                    try {
                        logger.info("Creating statement!");
                        statement=connection.prepareStatement(sql);
                        statement.setInt(1,id);
                        int result = statement.executeUpdate();
                        if(result==1)
                        {
                            return true;
                        }

                    }catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }finally {
                        try{
                            logger.info("Closing statement!");
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
                }catch (SQLException ex)
                {
                    logger.info("Closing connection error!");
                    ex.printStackTrace();
                }
            }

        return false;
    }

    @Override
    public boolean updateAuthor(Author author) {

        Connection connection=null;
        PreparedStatement statement=null;

        final String sql ="UPDATE author SET num_publications=?,name=?, surname=?" +
                "WHERE author_id=?;";

        try{
            logger.info("Open connection");
            connection=ConnectionFactory.getConnection();
            try{
                statement=connection.prepareStatement(sql);
                statement.setInt(1,author.getNumberOfPublication());
                statement.setString(2,author.getName());
                statement.setString(3,author.getSurname());
                statement.setInt(4,author.getId());
                int result =statement.executeUpdate();
                if(result==1)
                {
                    return true;
                }
            }catch (SQLException ex){
                try{
                    logger.info("Closing statemeint!");
                    statement.close();
                }catch (SQLException exc)
                {
                    logger.info("Closing statement error!");
                    exc.printStackTrace();
                }
            }
        }finally {
            try{
                logger.info("Closing connection!");
                connection.close();
            }
            catch (SQLException ex)
            {
                logger.info("Closing connection error!");
                ex.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public Author getAuthorByUserId(int id) {

        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Author author=null;

        final String sql="SELECT * FROM author WHERE user_id=?;";

            try {
                logger.info("Opening connection!");
                connection=ConnectionFactory.getConnection();
                    try {
                        logger.info("Creating statement");
                        statement=connection.prepareStatement(sql);
                        statement.setInt(1,id);
                        resultSet=statement.executeQuery();
                        if(resultSet.next())
                        {
                            return (author=extractAuthorFromResultSet(resultSet));
                        }
                    }catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }finally {
                        try{
                            logger.info("Closing statement!");
                            statement.close();
                        }catch (SQLException ex)
                        {
                            logger.info("Closing statement error!");
                            ex.printStackTrace();
                        }
                    }

            }finally {
                try{
                    logger.info("Closing connection");
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
    public List<Author> getAll() {

        List<Author> authors = new ArrayList<>();

        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;

        final String sql = "SELECT * FROM author;";

            try {
                    logger.info("Opening connection!");
                    connection=ConnectionFactory.getConnection();
                        try {
                            logger.info("Creating statement!");
                            statement=connection.prepareStatement(sql);
                            statement.execute();
                            resultSet=statement.executeQuery();
                            while(resultSet.next())
                            {
                                authors.add(extractAuthorFromResultSet(resultSet));
                            }
                                return authors;
                        }catch (SQLException ex)
                        {
                            ex.printStackTrace();
                        }finally {
                            try{
                                logger.info("Closing statement!");
                                statement.close();
                            }catch (SQLException ex)
                            {
                                logger.info("Closing statement error!");
                                ex.printStackTrace();
                            }
                        }

            }finally {
                try
                {
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

    private Author extractAuthorFromResultSet(ResultSet rs) throws SQLException {

        try {
            Author author = new Author();
            author.setId(rs.getInt("author_id"));
            author.setUser_id(rs.getInt("user_id"));
            author.setNumberOfPublication(rs.getInt("num_publications"));
            author.setName(rs.getString("name"));
            author.setSurname(rs.getString("surname"));
            return author;
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    private Post extractPostFromResultSet(ResultSet rs) throws SQLException {

        try {
            Post post = new Post();
            post.setId(rs.getInt("post_id"));
            post.setNameOfPost(rs.getString("post_name"));
            return post;
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
