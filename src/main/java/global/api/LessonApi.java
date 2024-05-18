package global.api;

import global.dto.SimpleResponse;
import global.dto.request.LessonRequest;
import global.dto.response.LessonResponse;
import global.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/lesson")
@RestController
@RequiredArgsConstructor
public class LessonApi {

    private final LessonService lessonService;

    @GetMapping
    public List<LessonResponse> getAll(){
        return lessonService.getAllLessons();
    }

    @PostMapping
    public SimpleResponse saveLesson(@RequestParam Long courseId,@RequestBody LessonRequest lessonRequest){
        return lessonService.saveLesson(courseId,lessonRequest);
    }

    @GetMapping("/getById")
    public LessonResponse getById(@RequestParam Long lessonId){
        return lessonService.getLessonById(lessonId);
    }

    @DeleteMapping
    public SimpleResponse deleteLesson(@RequestParam Long lessonId){
        return lessonService.deleteLesson(lessonId);
    }

    @PostMapping("/update")
    public SimpleResponse update(@RequestParam Long lessonId,@RequestBody LessonRequest lessonRequest){
        return lessonService.updateLesson(lessonId,lessonRequest);
    }
}