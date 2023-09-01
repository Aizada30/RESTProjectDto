package global.service;

import global.dto.SimpleResponse;
import global.dto.request.TaskRequest;
import global.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {

    List<TaskResponse>getAllTask();
    TaskResponse getById(Long taskId);
    SimpleResponse saveTask(Long lessonId, TaskRequest taskRequest);
    SimpleResponse deleteTask(Long taskId);
    SimpleResponse update(Long taskId,TaskRequest taskRequest);


}
