package suep.rg.brcode.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import suep.rg.brcode.Entity.Love;

public interface LoveDao extends JpaRepository<Love, Integer> {

    Love findLoveByUserIdAndPaperId(Integer userId, Integer paperId);
}
