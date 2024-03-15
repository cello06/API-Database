package pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String accountId;
	private AvatarUrls avatarUrls;
	private String displayName;
	private String accountType;
	private String self;
	private boolean active;
	private String locale;
	private String timeZone;
	private String emailAddress;
}
