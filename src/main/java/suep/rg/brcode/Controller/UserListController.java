package suep.rg.brcode.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import suep.rg.brcode.Result.Result;

@Controller
@RequestMapping(value = "/api")
public interface UserListController {

    /**
     * 全站用户列表按浏览数排名
     * @param index 页数
     * @param size 页面条数
     * @return 打包
     */
    public Result userListSortByWatch(Integer index, Integer size);

    /**
     * 全站用户列表 按点赞数排名
     * @param index 页数
     * @param size 页面条数
     * @return 打包
     */
    public Result userListSortByLove(Integer index, Integer size);
}
