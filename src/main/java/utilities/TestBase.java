package utilities;

import org.junit.BeforeClass;

import java.sql.*;

public class TestBase {

    public static ResultSet resultSet;
    public static Statement statement;
    public static void dbconnection() throws SQLException {

        String db_url = ConfigReader.getProperty("db_url");
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        Connection connection = DriverManager.getConnection(db_url, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

    }



}
