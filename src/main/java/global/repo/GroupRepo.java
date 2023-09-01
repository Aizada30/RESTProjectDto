package global.repo;

import global.dto.response.GroupResponse;
import global.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GroupRepo extends JpaRepository<Group, Long> {

    @Query("SELECT NEW global.dto.response.GroupResponse(g.id,g.groupName,g.imageLink,g.description,g.createdAt)FROM Group g")
    List<GroupResponse> getAllGroup();

    @Query("SELECT NEW global.dto.response.GroupResponse(g.id,g.groupName,g.imageLink,g.description,g.createdAt)FROM Group g WHERE g.id=:groupId")
    Optional<GroupResponse> getGroupById(Long groupId);

    @Query("SELECT g FROM Group g WHERE g.id=:groupId")
    Group findGroup (Long groupId);

    @Query("SELECT COUNT(g) FROM Group g")
    Integer countStudent(Long groupID);

}
