package global.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
public class LessonResponse {
    private Long id;
    private String lessonName;
    private LocalDate createdAt;

    public LessonResponse(Long id, String lessonName, LocalDate createdAt) {
        this.id = id;
        this.lessonName = lessonName;
        this.createdAt = createdAt;
    }
}