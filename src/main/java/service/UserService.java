package service;

import mapper.UserMapper;
import model.UserDatabase;
import utils.DBUtils;

import java.util.List;

public class UserService {
    public static List<UserDatabase> getListOfAllUsers(){
        String query = "SELECT * FROM user_jira";

        return DBUtils.executeQuery(query,new UserMapper());
    }
}
