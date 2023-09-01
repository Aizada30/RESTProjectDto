package global.service;

import global.dto.SimpleResponse;
import global.dto.request.GroupRequest;
import global.dto.response.GroupResponse;

import java.util.List;

public interface GroupService {

    List<GroupResponse> getAllGroup();
    GroupResponse getBuId(Long groupId);
    SimpleResponse saveGroup(GroupRequest groupRequest);
    SimpleResponse updateGroup(Long groupId,GroupRequest groupRequest);
    SimpleResponse deleteGroup(Long groupId);
}
