package global.dto.request;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class GroupRequest {

    private String groupName;
    private String imageLink;
    private String description;

}
