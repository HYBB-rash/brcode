package suep.rg.brcode.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import suep.rg.brcode.Entity.rev.UserId;
import suep.rg.brcode.Result.Result;

@Controller
public interface PaperListController {

    /**
     * 全站博客文章列表，根据时间排序
     * @return 打包成List<VuePaperItem>返回
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/PaperList/time")
    public Result paperListSortByTime();

    /**
     * 全站博客文章列表，根据点赞排序
     * @return 打包成List<VuePaperItem>返回
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/PaperList/love")
    public Result paperListSortByLove();

    /**
     * 全站博客文章列表，根据浏览量排序
     * @return 打包成List<VuePaperItem>返回
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/PaperList/watch")
    public Result paperListSortByWatch();

    /**
     * 博主的全部文章列表，根据时间排序
     * @param userId 博主的ID号
     * @return 打包成List<VuePaperItem>返回
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/PaperList/{userId}/time")
    public Result paperListSortByTime(@PathVariable Integer userId);

    /**
     * 博主的全部文章列表，根据点赞排序
     * @param userId 博主的ID号
     * @return 打包成List<VuePaperItem>返回
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/PaperList/{userId}/love")
    public Result paperListSortByLove(@PathVariable Integer userId);

    /**
     * 博主的全部文章列表，根据浏览量排序
     * @param userId 博主的ID号
     * @return 打包成List<VuePaperItem>返回
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/PaperList/{userId}/watch")
    public Result paperListSortByWatch(@PathVariable Integer userId);
}
