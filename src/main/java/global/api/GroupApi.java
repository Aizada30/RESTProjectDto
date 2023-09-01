package global.api;

import global.dto.SimpleResponse;
import global.dto.request.GroupRequest;
import global.dto.response.GroupResponse;
import global.service.GroupService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/group")
public class GroupApi {

    private final GroupService groupService;

    @GetMapping
    public List<GroupResponse> getAll(){
        return groupService.getAllGroup();
    }

    @PostMapping
    public SimpleResponse saveGroup(@RequestBody GroupRequest groupRequest){
        return groupService.saveGroup(groupRequest);
    }

    @GetMapping("/getById")
    public GroupResponse getById(@RequestParam Long groupId){
        return groupService.getBuId(groupId);
    }

    @GetMapping("/update")
    public SimpleResponse updateGroup(@RequestParam Long groupId,@RequestBody GroupRequest groupRequest){
        return groupService.updateGroup(groupId,groupRequest);
    }

    @DeleteMapping
    public SimpleResponse deleteGroup(@RequestParam Long groupId){
        return groupService.deleteGroup(groupId);
    }
}
