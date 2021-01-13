package suep.rg.brcode.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suep.rg.brcode.Entity.Paper;

import java.awt.print.Pageable;
import java.util.List;

public interface PaperDao extends JpaRepository<Paper, Integer> {

    Paper findPaperById(Integer paperId);
}
