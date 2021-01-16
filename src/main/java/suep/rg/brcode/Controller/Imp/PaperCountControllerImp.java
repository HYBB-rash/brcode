package suep.rg.brcode.Controller.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import suep.rg.brcode.Controller.PageCountController;
import suep.rg.brcode.Result.Result;
import suep.rg.brcode.Result.ResultFactory;
import suep.rg.brcode.Service.PageCountService;

@Controller
public class PaperCountControllerImp implements PageCountController {

    @Autowired
    PageCountService pageCountService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/Page/count")
    @Override
    public Result getPaperCount() {
        return ResultFactory.buildSuccessResult(pageCountService.getPaperCount());
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/Page/count/{userId}")
    @Override
    public Result getPaperCount(@PathVariable Integer userId) {
        Integer count = pageCountService.getPaperCountByUserId(userId);
        return ResultFactory.buildSuccessResult(count);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/Page/count/user")
    @Override
    public Result getUserCount() {
        Integer count = pageCountService.getUserCount();
        return ResultFactory.buildSuccessResult(count);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/Page/count/comment")
    @Override
    public Result getCommentCount(@RequestParam("userId") Integer userId) {
        Integer count = pageCountService.getCommentsCountByUserId(userId);
        return ResultFactory.buildSuccessResult(count);
    }
}
