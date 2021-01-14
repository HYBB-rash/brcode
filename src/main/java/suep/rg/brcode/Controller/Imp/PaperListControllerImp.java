package suep.rg.brcode.Controller.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import suep.rg.brcode.Controller.PaperListController;
import suep.rg.brcode.Entity.send.VuePaperItem;
import suep.rg.brcode.Result.Result;
import suep.rg.brcode.Result.ResultFactory;
import suep.rg.brcode.Service.PaperListPageService;

import java.util.List;

@Controller
public class PaperListControllerImp implements PaperListController {

    @Autowired
    PaperListPageService paperListPageService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/PaperList/time")
    @Override
    public Result paperListSortByTime(@RequestParam("index") Integer index,@RequestParam("size") Integer size) {
        List<VuePaperItem> sortByTime = paperListPageService.getPaperListSortByTime(index, size);
        return ResultFactory.buildSuccessResult(sortByTime);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/PaperList/love")
    @Override
    public Result paperListSortByLove(@RequestParam("index") Integer index,@RequestParam("size") Integer size) {
        List<VuePaperItem> sortByLove = paperListPageService.getPaperListSortByLove(index, size);
        return ResultFactory.buildSuccessResult(sortByLove);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/PaperList/watch")
    @Override
    public Result paperListSortByWatch(@RequestParam("index") Integer index,@RequestParam("size") Integer size) {
        List<VuePaperItem> sortByWatch = paperListPageService.getPaperListSortByWatch(index, size);
        return ResultFactory.buildSuccessResult(sortByWatch);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/PaperList/{userId}/time")
    @Override
    public Result paperListSortByTime(@PathVariable Integer userId, @RequestParam("index") Integer index,@RequestParam("size") Integer size) {
        List<VuePaperItem> sortByTime = paperListPageService.getPaperListSortByTime(userId, index, size);
        return ResultFactory.buildSuccessResult(sortByTime);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/PaperList/{userId}/love")
    @Override
    public Result paperListSortByLove(@PathVariable Integer userId, @RequestParam("index") Integer index,@RequestParam("size") Integer size) {
        List<VuePaperItem> sortByLove = paperListPageService.getPaperListSortByLove(userId, index, size);
        return ResultFactory.buildSuccessResult(sortByLove);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/PaperList/{userId}/watch")
    @Override
    public Result paperListSortByWatch(@PathVariable Integer userId, @RequestParam("index") Integer index,@RequestParam("size") Integer size) {
        List<VuePaperItem> sortByWatch = paperListPageService.getPaperListSortByWatch(userId, index, size);
        return ResultFactory.buildSuccessResult(sortByWatch);
    }
}
