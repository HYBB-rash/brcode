package suep.rg.brcode.Service.Imp;

import org.springframework.stereotype.Service;
import suep.rg.brcode.Entity.rev.IPV4;
import suep.rg.brcode.Entity.send.VueComment;
import suep.rg.brcode.Entity.send.VuePaper;
import suep.rg.brcode.Service.ClickPaperService;

import java.util.List;

@Service
public class ClickPaperServiceImp implements ClickPaperService {
    @Override
    public void recordWatch(IPV4 ipv4, Integer paperId) {

    }

    @Override
    public VuePaper getPaper(Integer paperId) {
        return null;
    }

    @Override
    public Integer getLoveCount(Integer paperId) {
        return null;
    }

    @Override
    public Boolean ensureHaveLove(Integer paperId, Integer userId) {
        return null;
    }

    @Override
    public Boolean loveThisPaper(Integer paperId, Integer userId) {
        return null;
    }

    @Override
    public List<VueComment> getPaperComments(Integer paperId) {
        return null;
    }
}
