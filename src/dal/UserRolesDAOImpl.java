package dal;

import entities.Roles;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserRolesDAOImpl implements UserRolesDAO {

    private static Logger logger=Logger.getLogger(UserRolesDAOImpl.class.toString());

    private ConnectionFactory connectionFactory=ConnectionFactory.getInstance();

    @Override
    public List<Roles> getUserRolesById(int id) {

        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Roles>roles=new ArrayList<>();

        final String sql ="SELECT * FROM user_roles where user_id=?;";

        try{
            logger.info("Open connection");
            connection=ConnectionFactory.getConnection();

            try{
                logger.info("Creating statement!");
                statement=connection.prepareStatement(sql);
                statement.setInt(1,id);
                statement.execute();
                resultSet=statement.executeQuery();
                roles=extractRolesFromResultSet(resultSet);
                if(roles!=null)
                {
                    return roles;
                }
            }catch (SQLException ex)
            {
                logger.info("Creating statement error!");
                ex.printStackTrace();
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
    public List<Roles> getUserRolesByUser(User user) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Roles> roles=new ArrayList<>();

        final String sql="SELECT * FROM user_roles where user_id=?;";

            try{
                logger.info("Opening connection!");
                connection=ConnectionFactory.getConnection();
                try
                {   logger.info("Creating prepared statement!");
                    statement= connection.prepareStatement(sql);
                    statement.setInt(1,user.getId());
                    statement.execute();
                    resultSet=statement.executeQuery();
                    roles=extractRolesFromResultSet(resultSet);
                    if(roles!=null)
                    {
                        return roles;
                    }
                }catch (SQLException ex)
                {
                    logger.info("Prepared statement error!");
                    ex.printStackTrace();
                }
            }
            finally {
                try{
                    logger.info("Closing connection!");
                    connection.close();
                }catch (SQLException ex)
                {
                    logger.info("Connection closing error!");
                    ex.printStackTrace();
                }
            }

            return null;
    }

    @Override
    public void addRole(User user ,Roles roles) {

        Connection connection=null;
        PreparedStatement statement=null;
       // ResultSet resultSet=null;

        final String sql ="INSERT INTO user_roles (user_id,roles) VALUES (?,?);";

        try{
            logger.info("Open connection!");
            connection=ConnectionFactory.getConnection();
            try
            {   logger.info("Creating prepared statement!");
                statement= connection.prepareStatement(sql);
                statement.setInt(1,user.getId());
                statement.setString(2,roles.name());
                statement.execute();
                logger.info("User with role "+roles.name()+" is" +
                            "added!");
            }catch (SQLException ex)
            {
                logger.info("Prepared statement error!");
                ex.printStackTrace();
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

    }

    @Override
    public void deleteRole(User user,Roles role) {
        final String sql="DELETE  FROM user_roles WHERE user_id=? AND roles=?;";

        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;

        try{
            logger.info("Opening connection");
            connection=ConnectionFactory.getConnection();
            try{
                logger.info("Creating statement!");
                statement=connection.prepareStatement(sql);
                statement.setInt(1,user.getId());
                statement.setString(2,role.name());
                statement.execute();
            }
            catch (SQLException exc){
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
    }

    private List<Roles> extractRolesFromResultSet(ResultSet rs) throws SQLException {

        List<Roles> roles = new ArrayList<>();
        try {
            List<String> role=new ArrayList<>();
            while(rs.next()) {
                role.add(rs.getString(2));
            }
            for (String str:role) {
                if(str.equals("ADMIN")||str.equals("USER"))
                {
                    roles.add(Roles.valueOf(str));
                }

            }
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return roles;
    }
}
