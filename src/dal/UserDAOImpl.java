package dal;

import com.mysql.jdbc.Statement;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserDAOImpl implements UserDAO{

    private static Logger logger=Logger.getLogger(UserDAOImpl.class.toString());

    private ConnectionFactory connectionFactory=ConnectionFactory.getInstance();

    @Override
    public User getUserById(int Id){
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;

        final String sql ="SELECT * FROM user where user_id =?;";
            try {
                logger.info("Opening connection!");
                connection=ConnectionFactory.getConnection();
                    try{
                        logger.info("Creating statement!");
                        statement=connection.prepareStatement(sql);
                        statement.setInt(1,Id);
                        statement.execute();
                        resultSet=statement.executeQuery();
                        if(resultSet.next())
                        {
                            return extractUserFromResultSet(resultSet);
                        }
                    }
                        catch (SQLException ex)
                            {
                                logger.info("Creating statement error!");
                                ex.printStackTrace();
                            }
                    finally {
                              try {
                                    logger.info("Closing statement!");
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
                    logger.info("Closing conection!");
                    connection.close();

                }catch (SQLException ex)
                {
                    logger.info("Connection close error!");
                    ex.printStackTrace();
                }
            }
        return null;
    }

    @Override
    public User getUserByNickname(String nickname) {

        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet =null;
        User user = null;

        final String sql="SELECT  * FROM  user WHERE nickname=?;";
            try{
                logger.info("Opening connection");
                connection=ConnectionFactory.getConnection();
                try {
                    logger.info("Creating statement");
                    statement=connection.prepareStatement(sql);
                    statement.setString(1,nickname);
                    resultSet=statement.executeQuery();
                    if(resultSet.next())
                    {
                        user=extractUserFromResultSet(resultSet);
                        if(user!=null&&user.getNickname().equals(nickname))
                        {
                            return user;
                        }
                    }
                }catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
                finally {
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
                    logger.info("Closing connection error!");
                    ex.printStackTrace();
                }
            }

            return null;
    }

    @Override
    public List<User> getAllUsers() {

        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        final String sql = "SELECT * FROM user";
        List<User> users=new ArrayList<>();

        try{
            logger.info("Opening connection");
            connection=ConnectionFactory.getConnection();
                try{
                    logger.info("Creating statement!");
                    statement=connection.prepareStatement(sql);
                    resultSet=statement.executeQuery();
                    while(resultSet.next())
                    {
                        users.add(extractUserFromResultSet(resultSet));
                    }
                    return users;
                }
                catch (SQLException ex)
                {
                    logger.info("Creating statement error!");
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

        }finally {
            try {
                logger.info("Closing conection!");
                connection.close();

            }catch (SQLException ex)
            {
                logger.info("Connection close error!");
                ex.printStackTrace();
            }
        }


        return null;
    }

    @Override
    public User getUserByUserEmailAndPassword(String email,String password) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        User user=null;
        final String sql = "SELECT * FROM user WHERE email=?  and password=? ;";

        try{
                logger.info("Creating connection getUserByEmail!");
                connection =ConnectionFactory.getConnection();

                    try {
                        logger.info("Creating statement getUserByEmail!");
                        statement= connection.prepareStatement(sql);
                        statement.setString(1,email);
                        statement.setString(2,password);
                        resultSet=statement.executeQuery();
                        if(resultSet.next())
                        {
                            user=extractUserFromResultSet(resultSet);
                            return user;
                        }
                    }
                    catch (SQLException ex)
                    {
                        logger.info("Creating statement error getUserByEmail!");
                        ex.printStackTrace();
                    }
                    finally {
                        try{
                            statement.close();
                            logger.info("Closing statement getUserByEmail!");
                        }
                            catch (SQLException exc)
                            {
                                logger.info("Closing statement error getUserByEmail!");
                                exc.printStackTrace();
                            }
                    }
        } finally {
            try {
                logger.info("Closing conection getUserByEmail!");
                connection.close();

            }catch (SQLException ex)
            {
                logger.info("Connection close error! getUserByEmail");
                ex.printStackTrace();
            }
        }


        return null;
    }

    @Override
    public boolean addUser(User user) {
        final String sqlFirst = "INSERT INTO user (email,is_active,nickname,password)" +
                "VALUES (?,?,?,?);";

       // String sqlSecond="INSERT INTO user_roles (user)";
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;

        try{
            logger.info("Open connection!");
            connection=ConnectionFactory.getConnection();
                try
                {   logger.info("Creating prepared statement!");
                    statement= connection.prepareStatement(sqlFirst,Statement.RETURN_GENERATED_KEYS);
                    statement.setString(1,user.getEmail());
                    statement.setBoolean(2,user.getActive());
                    statement.setString(3,user.getNickname());
                    statement.setString(4,user.getPassword());
                    int result =statement.executeUpdate();
                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            user.setId(generatedKeys.getInt(1));
                            logger.warning("USER ID == "+user.getId());
                        }
                        else {
                            throw new SQLException("Creating user failed, no ID obtained.");
                        }
                    }
                    if(result==1)
                    {
                        return true;
                    }
                    logger.info("Get result set!");
                    logger.info("User with email "+user.getEmail()+" is" +
                            "created!");

                        }
                    catch (SQLException ex) {
                            ex.printStackTrace();
                    }
                    finally {
                            try {
                                if (resultSet != null) {
                                    resultSet.close();
                                    logger.info("Result set is closed!");
                                }
                            }catch (SQLException ex)
                            {
                                ex.printStackTrace();
                            }
                        }

        }finally {
                try {
                    logger.info("Closing conection!");
                    connection.close();

                }catch (SQLException ex)
                {
                    logger.info("Connection close error!");
                    ex.printStackTrace();
                }
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        final String sql ="UPDATE user SET email=?,is_active=?, nickname=?, password=?" +
                "WHERE user_id=?;";
        Connection connection=null;
        PreparedStatement statement=null;
        try{
             logger.info("Open connection");
             connection=ConnectionFactory.getConnection();
             try{
                 statement=connection.prepareStatement(sql);
                 statement.setString(1,user.getEmail());
                 statement.setBoolean(2,user.getActive());
                 statement.setString(3,user.getNickname());
                 statement.setString(4,user.getPassword());
                 statement.setInt(5,user.getId());
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
    public boolean deleteUser(int id) {

//        final String sql1="DELETE user,author FROM user INNER " +
//                "JOIN author ON author.user_id=user.user_id WHERE user.user_id=?;";

        final String sql="DELETE FROM user WHERE user.user_id=?;";

        Connection connection=null;
        PreparedStatement statement=null;

        try{
            logger.info("Opening connection");
            connection=ConnectionFactory.getConnection();
                try{
                    logger.info("Creating statement!");
                    statement=connection.prepareStatement(sql);
                    statement.setInt(1,id);
                    int result=statement.executeUpdate();
                    if(result==1)
                    {
                        return true;
                    }
                }
                catch (SQLException exc){
                    exc.printStackTrace();
                }finally {
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
    public boolean isExist(String email,String nickname) {
        Connection connection=null;
        PreparedStatement statement =null;
        ResultSet resultSet=null;
        User user=null;

        final String sql ="SELECT * FROM user WHERE email=? AND nickname=?;";

            try{
                logger.info("Opening connection isExist!");
                connection=ConnectionFactory.getConnection();
                    try{
                        logger.info("Creating statement isExist!");
                        statement=connection.prepareStatement(sql);
                        statement.setString(1,email);
                        statement.setString(2,nickname);
                        statement.execute();
                        resultSet=statement.executeQuery();
                        while(resultSet.next())
                        {
                            user=extractUserFromResultSet(resultSet);
                        }
                        if(user!=null)
                        {
                            return true;
                        }
                    }catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }finally {
                        try{
                            logger.info("Closing statement isExist");
                            statement.close();
                        }catch (SQLException ex) {
                            logger.info("Closing statement error isExist!");
                            ex.printStackTrace();
                        }
                    }
            }
            finally {
                try{
                    logger.info("Closing connection isExist!");
                    connection.close();
                }catch (SQLException ex)
                {
                    logger.info("Closing connection error isExist!");
                    ex.printStackTrace();
                }
            }

        return false;
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {

        try {
            logger.info("getting result from ResultSet");
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setEmail(rs.getString("email"));
            user.setActive(rs.getBoolean("is_active"));
            user.setNickname(rs.getString("nickname"));
            user.setPassword(rs.getString("password"));
            return user;
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
