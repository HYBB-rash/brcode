package suep.rg.brcode.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import suep.rg.brcode.Entity.PaperMessage;

public interface PaperMessageDao extends JpaRepository<PaperMessage, Integer> {

    PaperMessage findPaperMessageByPaperID(Integer paperId);
}
