package nbcc.hotelmanagement.repositories;

import nbcc.hotelmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
    default User findUser(String username){
        return findByUsername(username);
    }

   // User findByUsername(String username);

}
