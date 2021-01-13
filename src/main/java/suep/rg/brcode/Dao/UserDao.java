package suep.rg.brcode.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import suep.rg.brcode.Entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    User getByUsernameAndPassword(String username, String password);

}
