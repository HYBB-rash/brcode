package suep.rg.brcode.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import suep.rg.brcode.Entity.Watch;

public interface WatchDao extends JpaRepository<Watch, Integer> {

    Watch findWatchByIpv4AndPaperId(String ipv4, Integer paperId);
}
