package suep.rg.brcode.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suep.rg.brcode.Dao.*;
import suep.rg.brcode.Entity.Paper;
import suep.rg.brcode.Entity.PaperMessage;
import suep.rg.brcode.Entity.UserMessage;
import suep.rg.brcode.Entity.rev.IPV4;
import suep.rg.brcode.Entity.send.VueComment;
import suep.rg.brcode.Entity.send.VuePaper;
import suep.rg.brcode.Service.ClickPaperService;
import suep.rg.brcode.Utils.LoadUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ClickPaperServiceImp implements ClickPaperService {

    @Autowired
    WatchDao watchDao;
    @Autowired
    PaperDao paperDao;
    @Autowired
    PaperMessageDao paperMessageDao;
    @Autowired
    LoveDao loveDao;
    @Autowired
    CommentDao commentDao;
    @Autowired
    UserMessageDao userMessageDao;

    private void refreshPaperWatchMessage(Integer paperId) {
        PaperMessage paperMessage = paperMessageDao.findPaperMessageByPaperId(paperId);
        paperMessage.setWatch(paperMessage.getWatch() + 1);
        paperMessageDao.save(paperMessage);
        UserMessage userMessage = userMessageDao.findUserMessageById(paperMessage.getUserId());
        userMessage.setWatch(userMessage.getWatch() + 1);
        userMessageDao.save(userMessage);
    }

    @Override
    public void recordWatch(IPV4 ipv4, Integer paperId) {
        if (watchDao.findWatchByIpv4AndPaperId(ipv4.getIp(), paperId) == null) {
            watchDao.save(LoadUtils.load(ipv4, paperId));
            refreshPaperWatchMessage(paperId);
        }
    }

    @Override
    public VuePaper getPaper(Integer paperId) {
        Paper paper = paperDao.findPaperById(paperId);
        return LoadUtils.load(paper);
    }

    @Override
    public Integer getLoveCount(Integer paperId) {
        PaperMessage paperMessage = paperMessageDao.findPaperMessageByPaperId(paperId);
        return paperMessage.getLove();
    }

    private Boolean loveExist(Integer paperId, Integer userId) {
        return null != loveDao.findLoveByUserIdAndPaperId(userId, paperId);
    }

    @Override
    public Boolean ensureHaveLove(Integer paperId, Integer userId) {
        return loveExist(paperId, userId);
    }

    private void refreshPaperLoveMessage(Integer paperId) {
        PaperMessage paperMessage = paperMessageDao.findPaperMessageByPaperId(paperId);
        paperMessage.setLove(paperMessage.getLove() + 1);
        paperMessageDao.save(paperMessage);
        UserMessage userMessage = userMessageDao.findUserMessageById(paperMessage.getUserId());
        userMessage.setLove(userMessage.getLove() + 1);
        userMessageDao.save(userMessage);
    }
    @Override
    public Boolean loveThisPaper(Integer paperId, Integer userId) {
        if (loveExist(paperId, userId)) return false;
        loveDao.save(LoadUtils.load(paperId, userId));
        refreshPaperLoveMessage(paperId);
        return true;
    }

    @Override
    public List<VueComment> getPaperComments(Integer paperId) {
        return LoadUtils.load(commentDao.findCommentsByPaperId(paperId));
    }
}
