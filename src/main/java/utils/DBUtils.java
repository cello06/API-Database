package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    private static final Logger LOGGER = LogManager.getLogger(DBUtils.class);
    private static final String URL = ConfigManager.getProperty("URL");

    private static final String USERNAME = ConfigManager.getProperty("username");

    private static final String PASSWORD = System.getenv("db_password");


    static {
        try {
            Class.forName("org.postgresql.Driver");
            LOGGER.info("PostgreSql JDBC Driver loaded");
        } catch (ClassNotFoundException e) {
            LOGGER.error("PostgreSql JDBC Driver not found");
        }
    }

    public static Connection getConnection(){
        Connection connection;
        try {
          connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static   <T> List<T> executeQuery(String query,RowMapper<T> rowMapper){
        List<T> resultList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()){
                resultList.add(rowMapper.mapRow(resultSet));
            }
            LOGGER.info("Table from database converted to specific object!");
        }catch(SQLException e) {
           LOGGER.error("Database connection error!");
        }
        return resultList;
    }

}
