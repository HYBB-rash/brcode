package suep.rg.brcode.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import suep.rg.brcode.Dao.PaperDao;
import suep.rg.brcode.Dao.PaperMessageDao;
import suep.rg.brcode.Dao.UserDao;
import suep.rg.brcode.Entity.Paper;
import suep.rg.brcode.Entity.PaperMessage;
import suep.rg.brcode.Entity.send.VuePaperItem;
import suep.rg.brcode.Service.PaperListPageService;
import suep.rg.brcode.Utils.LoadUtils;

import java.util.LinkedList;
import java.util.List;

@Service
public class PaperListPageServiceImp implements PaperListPageService {

    @Autowired
    PaperDao paperDao;
    @Autowired
    PaperMessageDao paperMessageDao;
    @Autowired
    UserDao userDao;


    private Page<PaperMessage> getPaperList(Integer index, Integer size, String order) {
        Pageable pageable = PageRequest.of(index, size, Sort.by(order).descending());
        return paperMessageDao.findPaperMessageByStatusGreaterThanEqual(1 ,pageable);
    }

    private Page<PaperMessage> getPaperList(Integer index, Integer size, String order, Integer userId) {
        Pageable pageable = PageRequest.of(index, size, Sort.by(order).descending());
        return paperMessageDao.findPaperMessageByUserIdAndStatusGreaterThanEqual(userId, 0, pageable);
    }

    private List<VuePaperItem> load(Page<PaperMessage> all) {
        List<VuePaperItem> list = new LinkedList<>();
        for (PaperMessage paperMessage : all) {
            Paper paper = paperDao.findPaperById(paperMessage.getPaperId());
//            System.out.println(paperMessage);
//            System.out.println(paper);
            String username = userDao.findUserById(paperMessage.getUserId()).getUsername();
            VuePaperItem vuePaperItem = LoadUtils.load(paper, paperMessage, username);
            list.add(vuePaperItem);
        };
        return list;
    }

    @Override
    public List<VuePaperItem> getPaperListSortByTime(Integer index, Integer size) {
        Page<PaperMessage> time = getPaperList(index, size, "time");
        return load(time);
    }

    @Override
    public List<VuePaperItem> getPaperListSortByLove(Integer index, Integer size) {
        Page<PaperMessage> love = getPaperList(index, size, "love");
        return load(love);
    }

    @Override
    public List<VuePaperItem> getPaperListSortByWatch(Integer index, Integer size) {
        Page<PaperMessage> watch = getPaperList(index, size, "watch");
        return load(watch);
    }

    @Override
    public List<VuePaperItem> getPaperListSortByTime(Integer userId, Integer index, Integer size) {
        Page<PaperMessage> time = getPaperList(index, size, "time", userId);
        return load(time);
    }

    @Override
    public List<VuePaperItem> getPaperListSortByLove(Integer userId, Integer index, Integer size) {
        Page<PaperMessage> love = getPaperList(index, size, "love", userId);
        return load(love);
    }

    @Override
    public List<VuePaperItem> getPaperListSortByWatch(Integer userId, Integer index, Integer size) {
        Page<PaperMessage> watch = getPaperList(index, size, "watch", userId);
        return load(watch);
    }
}
