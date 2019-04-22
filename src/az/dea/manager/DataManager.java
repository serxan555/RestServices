package az.dea.manager;

import az.dea.model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DataManager {

    protected Connection connection;
    protected PreparedStatement statement;
    protected ResultSet resultSet;

    protected void connect() throws SQLException, IOException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        String filePath = "az/dea/manager/config.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream in = loader.getResourceAsStream(filePath);

        Properties properties = new Properties();
        properties.load(in);

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        connection = DriverManager.getConnection(url, user, password);
        if (connection != null) {
            System.out.println("***Success***");
        }
    }

    protected void disconnect() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
