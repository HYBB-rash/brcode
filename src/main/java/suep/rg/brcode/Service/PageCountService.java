package suep.rg.brcode.Service;

import org.springframework.stereotype.Service;

@Service
public interface PageCountService {

    public Integer getPaperCount();

    public Integer getPaperCountByUserId(Integer userId);

    public Integer getUserCount();
}
