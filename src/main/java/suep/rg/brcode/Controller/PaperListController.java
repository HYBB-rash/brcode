package suep.rg.brcode.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import suep.rg.brcode.Entity.rev.UserId;
import suep.rg.brcode.Result.Result;

@Controller
@RequestMapping(value = "/api")
public interface PaperListController {

    /**
     * 全站博客文章列表，根据时间排序
     * @return 打包成List<VuePaperItem>返回
     */

    public Result paperListSortByTime(Integer index, Integer size);

    /**
     * 全站博客文章列表，根据点赞排序
     * @return 打包成List<VuePaperItem>返回
     */

    public Result paperListSortByLove(Integer index, Integer size);

    /**
     * 全站博客文章列表，根据浏览量排序
     * @return 打包成List<VuePaperItem>返回
     */

    public Result paperListSortByWatch(Integer index, Integer size);

    /**
     * 博主的全部文章列表，根据时间排序
     * @param userId 博主的ID号
     * @return 打包成List<VuePaperItem>返回
     */

    public Result paperListSortByTime(@PathVariable Integer userId, Integer index, Integer size);

    /**
     * 博主的全部文章列表，根据点赞排序
     * @param userId 博主的ID号
     * @return 打包成List<VuePaperItem>返回
     */

    public Result paperListSortByLove(@PathVariable Integer userId, Integer index, Integer size);

    /**
     * 博主的全部文章列表，根据浏览量排序
     * @param userId 博主的ID号
     * @return 打包成List<VuePaperItem>返回
     */

    public Result paperListSortByWatch(@PathVariable Integer userId, Integer index, Integer size);
}
