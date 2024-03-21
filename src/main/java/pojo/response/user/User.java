package pojo.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
	private String accountId;
	private String expand;
	private AvatarUrls avatarUrls;
	private String displayName;
	private String accountType;
	private String emailAddress;
	private String self;
	private boolean active;
	private String timeZone;
	private Groups groups;
	private String locale;
	private ApplicationRoles applicationRoles;
}
