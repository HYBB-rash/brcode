package suep.rg.brcode.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suep.rg.brcode.Dao.PaperMessageDao;
import suep.rg.brcode.Dao.UserMessageDao;
import suep.rg.brcode.Service.PageCountService;

@Service
public class PageCountServiceImp implements PageCountService {

    @Autowired
    PaperMessageDao paperMessageDao;
    @Autowired
    UserMessageDao userMessageDao;

    @Override
    public Integer getPaperCount() {
        return Math.toIntExact(paperMessageDao.count());
    }

    @Override
    public Integer getPaperCountByUserId(Integer userId) {
        return paperMessageDao.getPaperMessageByUserId(userId).size();
    }

    @Override
    public Integer getUserCount() {
        return Math.toIntExact(userMessageDao.count());
    }
}
