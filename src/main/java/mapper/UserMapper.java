package mapper;

import model.UserDatabase;
import pojo.response.AvatarUrls;
import utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserDatabase> {

    //self_url, account_id, account_type, email, avatar_url_48x48, avatar_url_24x24, avatar_url_16x16, avatar_url_32x32, display_name, active, locale
    private String accountId;
    private String displayName;
    private String accountType;
    private String self;
    private boolean active;
    private String locale;
    private String timeZone;
    private String emailAddress;
    private String avatarUrls48x48;
    private String avatarUrls24x24;private String avatarUrls16x16;private String avatarUrls32x32;
    @Override
    public UserDatabase mapRow(ResultSet rs) throws SQLException {
        return new UserDatabase(rs.getString("account_id"),
                rs.getString("display_name"),
                rs.getString("account_type"),
                rs.getString("self"),
                rs.getBoolean("active"),
                rs.getString("locale"),
                rs.getString("time_zone"),
                rs.getString("email"),
                rs.getString("avatar_url_48x48"),
                rs.getString("avatar_url_24x24"),
                rs.getString("avatar_url_16x16"),
                rs.getString("avatar_url_32x32"));
    }
}

