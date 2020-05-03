package dal;

import com.mysql.jdbc.Statement;
import entities.Author;
import entities.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PostDAOImpl implements PostDAO {

    private Logger logger = Logger.getLogger(PostDAOImpl.class.toString());

    @Override
    public Post getPostById(int id) {

        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Post post=null;

        final String sql="SELECT * FROM post WHERE post_id=?;";

            try {
                logger.info("Opening connection!");
                connection=ConnectionFactory.getConnection();
                    try {
                        logger.info("Creating statement!");
                        statement=connection.prepareStatement(sql);
                        statement.setInt(1,id);
                        //statement.execute();
                        resultSet=statement.executeQuery();
                        if(resultSet.next())
                        {
                            post=extractPostFromResultSet(resultSet);
                            return post;
                        }
                    }catch (SQLException ex)
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
                }catch (SQLException ex)
                {
                    logger.info("Closing connection error!");
                    ex.printStackTrace();
                }
            }

        return null;
    }

    @Override
    public boolean addPost(Post post) {

        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        final String sql ="INSERT INTO post (post_name,information,description,image_source) " +
                "values(?,?,?,?);";

        try {
            logger.info("Opening connection!");
            connection=ConnectionFactory.getConnection();
                try {
                    logger.info("Creating statement");
                    statement= connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    statement.setString(1,post.getNameOfPost());
                    statement.setString(2,post.getInformation());
                    statement.setString(3,post.getDescription());
                    statement.setString(4,post.getImageSource());
                    int result = statement.executeUpdate();
                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            post.setId(generatedKeys.getInt(1));
                            logger.warning("USER ID == "+post.getId());
                        }
                        else {
                            throw new SQLException("Creating user failed, no ID obtained.");
                        }
                    }
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
                logger.info("CLosing conection error!");
                ex.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public boolean deletePost(int id) {

        Connection connection=null;
        PreparedStatement statement=null;

        final String sql ="DELETE  post,publication FROM " +
                "post INNER JOIN publication  on post.post_id = publication.post_id WHERE publication.post_id=?;";

        try {
            logger.info("Opening connection!");
            connection=ConnectionFactory.getConnection();
                try{
                    logger.info("Creating statement!");
                    statement=connection.prepareStatement(sql);
                    statement.setInt(1,id);
                    return statement.executeUpdate()==1;
                }catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
                    finally {
                        try {
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
    public boolean updatePost(Post post) {

        Connection connection=null;
        PreparedStatement statement=null;

        final String sql = "UPDATE post SET post_name=?" +
                "WHERE post_id=?;";
        try {
            logger.info("Opening connection!");
            connection=ConnectionFactory.getConnection();
            try{
                statement=connection.prepareStatement(sql);
                statement.setString(1,post.getNameOfPost());
                statement.setInt(2,post.getId());
                return statement.executeUpdate()==1;
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
                logger.info("Closing connection");
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
    public int numberOfPost() {
        int number=0;
        Connection connection=null;
        PreparedStatement statement=null;
        final String sql="SELECT COUNT(post_id) FROM post;";

        try{
            logger.info("Opening connection");
            connection=ConnectionFactory.getConnection();
            try{
                logger.info("Creating statement");
                statement=connection.prepareStatement(sql);
                number=statement.executeUpdate();
            }catch (SQLException ex)
            {
                ex.printStackTrace();
            }finally {
                try{
                    logger.info("Closing statement");
                    statement.close();
                }catch (SQLException ex)
                {
                    logger.info("Closing statement error");
                    ex.printStackTrace();
                }
            }
        }finally {
            try{
                logger.info("Closing connection");
                connection.close();
            }catch (SQLException ex)
            {
                logger.info("Closing connetion error");
                ex.printStackTrace();
            }
        }

        return number;
    }

    @Override
    public List<Post> findPosts(int currentPage, int recordsPerPage) {
        List<Post> posts=new ArrayList<>();
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        final String sql="SELECT * FROM post LIMIT ?,?;";
        int start=0;
        if(currentPage!=1)
        {
            start=currentPage*recordsPerPage-recordsPerPage +1;
        }

        try{
            connection=ConnectionFactory.getConnection();
            try{
                statement=connection.prepareStatement(sql);
                statement.setInt(1,start);
                statement.setInt(2,recordsPerPage);
                resultSet=statement.executeQuery();
                while(resultSet.next())
                {
                    posts.add(extractPostFromResultSet(resultSet));
                }
                return posts;
            }catch (SQLException ex)
            {
                ex.printStackTrace();
            }finally {
                try{
                    logger.info("Closing statement");
                    statement.close();
                }catch (SQLException ex)
                {
                    logger.info("Closing statement error");
                    ex.printStackTrace();
                }
            }
        }finally {
            try{
                logger.info("Closing connection");
                connection.close();
            }catch (SQLException ex)
            {
                logger.info("Closing connection error");
                ex.printStackTrace();
            }
        }



        return null;
    }

    @Override
    public List<Post> getAll() {

        List<Post>posts = new ArrayList<>();
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;

        final String sql="SELECT * FROM post;";

            try {
                logger.info("Opening connection!");
                connection=ConnectionFactory.getConnection();
                    try{
                        statement=connection.prepareStatement(sql);
                        statement.execute();
                        resultSet=statement.executeQuery();
                        while(resultSet.next())
                        {
                            posts.add(extractPostFromResultSet(resultSet));
                        }
                        return posts;
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
    public List<Post> getPostByName(String name) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Post>posts= new ArrayList<>();

        final String sql="SELECT * FROM post WHERE post_name LIKE ?;";

        try {
            logger.info("Opening connection!");
            connection=ConnectionFactory.getConnection();
            name="%"+name+"%";
            try{
                statement=connection.prepareStatement(sql);
                statement.setString(1,name);
                statement.execute();
                resultSet=statement.executeQuery();
                while(resultSet.next())
                {
                    posts.add(extractPostFromResultSet(resultSet));
                }
                return posts;
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
    public List<Author> getAuthorsByPostId(int id) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Author>authors= new ArrayList<>();

        final String sql ="SELECT * FROM author INNER " +
                "JOIN publication p on author.author_id = p.author_id WHERE p.post_id =?;";

        try{
            logger.info("Opening connection!");
            connection=ConnectionFactory.getConnection();
            try {
                logger.info("Creating statement!");
                statement=connection.prepareStatement(sql);
                statement.setInt(1,id);
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
            try {
                logger.info("Closing connection!");
                connection.close();
            } catch (SQLException ex)
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
            post.setInformation(rs.getString("information"));
            //post.setDate(rs.getDate("date_of_creation"));
            post.setDate(rs.getTimestamp("date_of_creation"));
            post.setDescription(rs.getString("description"));
            post.setImageSource(rs.getString("image_source"));
            return post;
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
