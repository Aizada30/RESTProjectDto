package global.repo;

import global.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Abdyrazakova Aizada
 */
public interface UserRepo extends JpaRepository<User,Long>  {

        Optional<User> getUserByEmail(String email);

        Boolean existsByEmail(String email);

}
