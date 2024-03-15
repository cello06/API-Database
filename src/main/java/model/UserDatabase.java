package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pojo.response.AvatarUrls;
@Data
public class UserDatabase {
    private String accountId;

    private String displayName;

    private String accountType;

    private String self;

    private boolean active;

    private String locale;

    private String timeZone;

    private String emailAddress;

    private String avatarUrls48x48;

    private String avatarUrls24x24;

    private String avatarUrls16x16;

    private String avatarUrls32x32;


    public UserDatabase(String accountId,String displayName, String accountType,
                        String self,boolean active,String locale,String timeZone,
                        String emailAddress,String avatarUrls48x48,String avatarUrls24x24,
                        String avatarUrls16x16,String avatarUrls32x32){
        this.accountId = accountId;
        this.displayName = displayName;
        this.accountType =accountType;
        this.self = self;
        this.active = active;
        this.locale = locale;
        this.timeZone = timeZone;
        this.emailAddress = emailAddress;
        this.avatarUrls48x48 = avatarUrls48x48;
        this.avatarUrls24x24 = avatarUrls24x24;
        this.avatarUrls16x16 = avatarUrls16x16;
        this.avatarUrls32x32 =avatarUrls32x32;

    }
}
