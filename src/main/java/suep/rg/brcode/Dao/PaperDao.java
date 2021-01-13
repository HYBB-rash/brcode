package suep.rg.brcode.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import suep.rg.brcode.Entity.Paper;

public interface PaperDao extends JpaRepository<Paper, Integer> {

    Paper findPaperById(Integer paperId);
}
