package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.jsoup.select.Evaluator;
import pojo.response.User;

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
        } catch (ClassNotFoundException e) {
            LOGGER.error("Sql error");
        }
    }

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            LOGGER.info("Connection is successfully handled!");
            return connection;
        } catch (SQLException e) {
            LOGGER.error("Connection problem occurred!");
            throw new RuntimeException();
        }
    }

    public static <T> List<T> executeQuery(String query, RowMapper<T> rowMapper) {
        List<T> resultList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);

             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                resultList.add(rowMapper.mapRow(resultSet));
            }

        } catch (Exception e) {
            LOGGER.error("Error occurred in executeQuery method");
        }
        return resultList;
    }

    public static void addUserToDatabase(User user) throws SQLException {
        String query = "INSERT INTO user_jira (self_url, account_id, account_type, email, avatar_url_48x48, avatar_url_24x24, avatar_url_16x16, avatar_url_32x32, display_name, active, locale,time_zone)"
                + " VALUES (?, ?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = getConnection();

            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setString(1, user.getSelf());
            preparedStatement.setString(2, user.getAccountId());
            preparedStatement.setString(3, user.getAccountType());
            preparedStatement.setString(4, user.getEmailAddress());
            preparedStatement.setString(5, user.getAvatarUrls().getJsonMember48x48());
            preparedStatement.setString(6, user.getAvatarUrls().getJsonMember24x24());
            preparedStatement.setString(7, user.getAvatarUrls().getJsonMember16x16());
            preparedStatement.setString(8, user.getAvatarUrls().getJsonMember32x32());
            preparedStatement.setString(9, user.getDisplayName());
            preparedStatement.setBoolean(10, user.isActive());
            preparedStatement.setString(11, user.getLocale());
            preparedStatement.setString(12, user.getTimeZone());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Database write process is not successful!");
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }

    }
}