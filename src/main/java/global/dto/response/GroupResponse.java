package global.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class GroupResponse {
    private Long id;
    private String groupName;
    private String imageLink;
    private String description;
    private LocalDate createdAt;

    public GroupResponse(Long id, String groupName, String imageLink, String description, LocalDate createdAt) {
        this.id = id;
        this.groupName = groupName;
        this.imageLink = imageLink;
        this.description = description;
        this.createdAt = createdAt;
    }
}
