package dal;

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
                        statement.execute();
                        resultSet=statement.executeQuery();
                        if((post=extractPostFromResultSet(resultSet))!=null)
                        {
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

        final String sql ="INSERT INTO post (post_id,post_name) " +
                "values(?,?);";

        try {
            logger.info("Opening connection!");
            connection=ConnectionFactory.getConnection();
                try {
                    logger.info("Creating statement");
                    statement=connection.prepareStatement(sql);
                    statement.setInt(1,post.getId());
                    statement.setString(2,post.getNameOfPost());
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

        final String sql ="DELETE FROM post WHERE post_id=?;";

        try {
            logger.info("Opening connection!");
            connection=ConnectionFactory.getConnection();
                try{
                    logger.info("Creating statement!");
                    statement=connection.prepareStatement(sql);
                    statement.setInt(1,id);
                    return statement.executeUpdate()==1?true:false;
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
                return statement.executeUpdate()==1?true:false;
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
