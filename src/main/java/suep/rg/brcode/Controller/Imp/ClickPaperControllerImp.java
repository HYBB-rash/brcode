package suep.rg.brcode.Controller.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import suep.rg.brcode.Controller.ClickPaperController;
import suep.rg.brcode.Entity.rev.IPV4;
import suep.rg.brcode.Entity.send.VueComment;
import suep.rg.brcode.Entity.send.VuePaper;
import suep.rg.brcode.Result.Result;
import suep.rg.brcode.Result.ResultFactory;
import suep.rg.brcode.Service.ClickPaperService;

import java.util.List;

@Controller
public class ClickPaperControllerImp implements ClickPaperController {

    @Autowired
    ClickPaperService clickPaperService;

    @Override
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/paper/{paperId}")
    public Result watchPaper(@RequestBody IPV4 ipv4, @PathVariable Integer paperId) {
        clickPaperService.recordWatch(ipv4, paperId);
        VuePaper paper = clickPaperService.getPaper(paperId);
        return ResultFactory.buildSuccessResult(paper);
    }

    @Override
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/love/{paperId}", method = RequestMethod.GET)
    public Result getLove(@PathVariable Integer paperId) {
        Integer loveCount = clickPaperService.getLoveCount(paperId);
        return ResultFactory.buildSuccessResult(loveCount);
    }

    @Override
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/love/{paperId}/{userId}", method = RequestMethod.GET)
    public Result ensureHaveLove(@PathVariable Integer paperId, @PathVariable Integer userId) {
        Boolean ensureHaveLove = clickPaperService.ensureHaveLove(paperId, userId);
        return ResultFactory.buildSuccessResult(ensureHaveLove);
    }

    @Override
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/love/like/{paperId}/{userId}")
    public Result loveThisPaper(@PathVariable Integer paperId,@PathVariable Integer userId) {
        Boolean loveThisPaper = clickPaperService.loveThisPaper(paperId, userId);
        return ResultFactory.buildSuccessResult(loveThisPaper);
    }

    @Override
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/comment/{paperId}")
    public Result getPaperComment(@PathVariable Integer paperId) {
        List<VueComment> paperComments = clickPaperService.getPaperComments(paperId);
        return ResultFactory.buildSuccessResult(paperComments);
    }
}
