package suep.rg.brcode.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import suep.rg.brcode.Entity.PaperMessage;

import java.util.List;

public interface PaperMessageDao extends JpaRepository<PaperMessage, Integer> {

    PaperMessage findPaperMessageByPaperId(Integer paperId);
    Page<PaperMessage> findPaperMessageByUserIdAndStatusGreaterThanEqual(Integer userId, Integer status, Pageable pageable);
    List<PaperMessage> getPaperMessageByUserIdAndStatusGreaterThanEqual(Integer userId, Integer status);
    List<PaperMessage> getPaperMessagesByStatusGreaterThanEqual(Integer status);
    Page<PaperMessage> findPaperMessageByStatusGreaterThanEqual(Integer status, Pageable pageable);
}
