package global.repo;

import global.dto.response.TaskResponse;
import global.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    @Query("SELECT NEW global.dto.response.TaskResponse(t.id,t.taskName,t.taskText,t.createdAt,t.deadline)FROM Task t")
    List<TaskResponse> getAllTask();

    @Query("SELECT NEW global.dto.response.TaskResponse(t.id,t.taskName,t.taskText,t.createdAt,t.deadline)FROM Task t WHERE t.id=:taskId")
    TaskResponse getTasById(Long taskId);

}
