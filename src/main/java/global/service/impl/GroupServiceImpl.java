package global.service.impl;

import global.dto.SimpleResponse;
import global.dto.request.GroupRequest;
import global.dto.response.GroupResponse;
import global.entity.Group;
import global.repo.GroupRepo;
import global.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupRepo groupRepo;
    private GroupResponse group;

    @Override
    public List<GroupResponse> getAllGroup() {
        return groupRepo.getAllGroup();
    }

    @Override
    public GroupResponse getBuId(Long groupId) {
        return group = groupRepo.getGroupById(groupId).orElseThrow(() -> new NoSuchElementException("Not found"));
    }

    @Override
    public SimpleResponse saveGroup(GroupRequest groupRequest) {
        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setImageLink(groupRequest.getImageLink());
        group.setDescription(groupRequest.getDescription());
        group.setCreatedAt(LocalDate.now());
        groupRepo.save(group);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Group with id:%s successfully saved", group.getId()));
    }

    @Override
    public SimpleResponse updateGroup(Long groupId, GroupRequest groupRequest) {
        Group group = groupRepo.findGroup(groupId);
        group.setGroupName(groupRequest.getGroupName());
        group.setImageLink(groupRequest.getImageLink());
        group.setDescription(groupRequest.getDescription());
        groupRepo.save(group);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Group with id:%s successfully updated", groupId)
        );
    }

    @Override
    public SimpleResponse deleteGroup(Long groupId) {
        groupRepo.deleteById(groupId);
        return new SimpleResponse(
                HttpStatus.OK,
                String.format("Group with id:%s successfully deleted", groupId)
        );
    }

    public Integer count(Long groupId) {
       return groupRepo.countStudent(groupId);
    }
}

