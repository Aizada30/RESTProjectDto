package global.api;

import global.dto.SimpleResponse;
import global.dto.request.TaskRequest;
import global.dto.response.TaskResponse;
import global.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/task")
public class TaskApi {

    private final TaskService taskService;

    @GetMapping
    public List<TaskResponse> getAll(){
        return taskService.getAllTask();
    }

    @PostMapping
    public SimpleResponse saveTask(@RequestParam Long lessonId,@RequestBody TaskRequest taskRequest){
        return taskService.saveTask(lessonId,taskRequest);
    }

    @DeleteMapping
    public SimpleResponse deleteTask(@RequestParam Long taskId){
        return taskService.deleteTask(taskId);
    }

    @PostMapping("/update")
    public SimpleResponse updateTask(@RequestParam Long taskId,@RequestBody TaskRequest request){
        return taskService.update(taskId,request);
    }

    @GetMapping("/getById")
    public TaskResponse getById(@RequestParam Long taskId){
        return taskService.getById(taskId);
    }
}