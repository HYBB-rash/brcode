package suep.rg.brcode.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suep.rg.brcode.Entity.UserMessage;

@Repository
public interface UserMessageDao extends JpaRepository<UserMessage, Integer> {

    UserMessage findUserMessageById(Integer id);
}
