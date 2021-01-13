package suep.rg.brcode.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import suep.rg.brcode.Entity.PaperMessage;

import java.util.List;

public interface PaperMessageDao extends JpaRepository<PaperMessage, Integer> {

    PaperMessage findPaperMessageByPaperId(Integer paperId);
    Page<PaperMessage> findPaperMessageByUserId(Integer userId, Pageable pageable);
}
