package suep.rg.brcode.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suep.rg.brcode.Dao.PaperDao;
import suep.rg.brcode.Dao.PaperMessageDao;
import suep.rg.brcode.Entity.Paper;
import suep.rg.brcode.Entity.PaperMessage;
import suep.rg.brcode.Entity.send.VuePaper;
import suep.rg.brcode.Service.EditPaperService;
import suep.rg.brcode.Utils.LoadUtils;
import suep.rg.brcode.Utils.TimeUtils;

@Service
public class EditPaperServiceImp implements EditPaperService {

    @Autowired
    PaperMessageDao paperMessageDao;
    @Autowired
    PaperDao paperDao;

    @Override
    public VuePaper getPaperContent(Integer userId, Integer paperId) {
        PaperMessage paperMessage = paperMessageDao.findPaperMessageByPaperId(paperId);
        if (!paperMessage.getUserId().equals(userId)) return null;
        Paper paper = paperDao.findPaperById(paperId);
        return LoadUtils.load(paper);
    }

    @Override
    public Boolean savePaper(VuePaper paper, Integer userId) {
        Paper save = paperDao.save(LoadUtils.load(paper));
        PaperMessage paperMessage;
        if (paper.getPaperId() == null) {
            paperMessage = LoadUtils.initPaperMessage(userId, save.getId());
        } else {
            paperMessage = paperMessageDao.findPaperMessageByPaperId(paper.getPaperId());
            paperMessage.setTime(TimeUtils.getNowTime());
        }
        PaperMessage message = paperMessageDao.save(paperMessage);
        paper.setPaperId(message.getPaperId());
        return true;
    }

    @Override
    public Boolean savePaperAndSent(VuePaper paper, Integer userId) {
        savePaper(paper, userId);
        PaperMessage paperMessage = paperMessageDao.findPaperMessageByPaperId(paper.getPaperId());
        paperMessage.setStatus(1);
        paperMessageDao.save(paperMessage);
        return null;
    }
}
