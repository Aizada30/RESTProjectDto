package global.service.impl;

import global.dto.SimpleResponse;
import global.dto.request.TaskRequest;
import global.dto.response.TaskResponse;
import global.entity.Lesson;
import global.entity.Task;
import global.repo.LessonRepo;
import global.repo.TaskRepo;
import global.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskServiceImpl implements TaskService {
    private final LessonRepo lessonRepo;
    private final TaskRepo taskRepo;
    @Override
    public List<TaskResponse> getAllTask() {
        return taskRepo.getAllTask();
    }

    @Override
    public TaskResponse getById(Long taskId) {
        return taskRepo.getTasById(taskId);

    }

    @Override
    public SimpleResponse saveTask(Long lessonId, TaskRequest taskRequest) {
        Lesson lesson = lessonRepo.getReferenceById(lessonId);
        Task task=new Task();
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setCreatedAt(LocalDate.now());
        task.setDeadline(taskRequest.getDeadline());
        lesson.getTasks().add(task);
        task.setLesson(lesson);
        taskRepo.save(task);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Task with id:%s successfully saved ",task.getId())
        );
    }

    @Override
    public SimpleResponse deleteTask(Long taskId) {
        taskRepo.deleteById(taskId);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Task with id:%s successfully deleted",taskId)
        );
    }

    @Override
    public SimpleResponse update(Long taskId, TaskRequest taskRequest) {
        Task task = taskRepo.getReferenceById(taskId);
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadline(taskRequest.getDeadline());
        taskRepo.save(task);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Task with id:%s successfully updated",task.getId())
        );
    }
}