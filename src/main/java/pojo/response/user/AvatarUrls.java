package pojo.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvatarUrls{
	@JsonProperty("48x48")
	private String jsonMember48x48;
	@JsonProperty("24x24")
	private String jsonMember24x24;
	@JsonProperty("16x16")
	private String jsonMember16x16;
	@JsonProperty("32x32")
	private String jsonMember32x32;
}
