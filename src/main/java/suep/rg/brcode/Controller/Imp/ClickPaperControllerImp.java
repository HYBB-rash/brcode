package suep.rg.brcode.Controller.Imp;

import org.springframework.web.bind.annotation.*;
import suep.rg.brcode.Controller.ClickPaperController;
import suep.rg.brcode.Entity.rev.IPV4;
import suep.rg.brcode.Result.Result;

public class ClickPaperControllerImp implements ClickPaperController {


    @Override
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/{paperId}", method = RequestMethod.POST)
    public Result watchPaper(@PathVariable Integer paperId, IPV4 ipv4) {
        return null;
    }

    @Override
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/love/{paperId}", method = RequestMethod.GET)
    public Result getLove(@PathVariable Integer paperId) {
        return null;
    }

    @Override
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/love/{paperId}/{userId}", method = RequestMethod.GET)
    public Result ensureHaveLove(@PathVariable Integer paperId, @PathVariable Integer userId) {
        return null;
    }

    @Override
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/love/like/{paperId}/{userId}")
    public Result loveThisPaper(@PathVariable Integer paperId,@PathVariable Integer userId) {
        return null;
    }

    @Override
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/comment/{paperId}")
    public Result getPaperComment(@PathVariable Integer paperId) {
        return null;
    }
}
