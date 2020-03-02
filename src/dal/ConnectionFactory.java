package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class ConnectionFactory {


    private final static String dbName = "root";

    private final static String dbUrl = "jdbc:mysql://localhost:3306/servlet_db";

    private final static String dbPwd = "root";

    public static ConnectionFactory getInstance()
    {
        return new ConnectionFactory() ;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    dbUrl, dbName, dbPwd);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

}
