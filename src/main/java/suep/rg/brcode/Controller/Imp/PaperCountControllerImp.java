package suep.rg.brcode.Controller.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
}
