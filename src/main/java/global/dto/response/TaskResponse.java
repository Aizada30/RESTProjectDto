package global.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class TaskResponse {
    private Long id;
    private String taskName;
    private String taskText;
    private LocalDate createdAt;
    private LocalDate deadline;

    public TaskResponse(Long id, String taskName, String taskText, LocalDate createdAt, LocalDate deadline) {
        this.id = id;
        this.taskName = taskName;
        this.taskText = taskText;
        this.createdAt = createdAt;
        this.deadline = deadline;
    }
}
