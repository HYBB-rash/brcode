package suep.rg.brcode.Service;

import org.springframework.stereotype.Service;
import suep.rg.brcode.Entity.send.VuePaperItem;

import java.util.List;

@Service
public interface PaperListService {

    /**
     * 全站博客文章列表，根据时间排序
     * @return 打包成List<VuePaperItem>返回
     */
    public List<VuePaperItem> getPaperListSortByTime();

    /**
     * 全站博客文章列表，根据点赞排序
     * @return 打包成List<VuePaperItem>返回
     */
    public List<VuePaperItem> getPaperListSortByLove();

    /**
     * 全站博客文章列表，根据浏览量排序
     * @return 打包成List<VuePaperItem>返回
     */
    public List<VuePaperItem> getPaperListSortByWatch();

    /**
     * 博主的全部文章列表，根据时间排序
     * @param userId 博主的ID号
     * @return 打包成List<VuePaperItem>返回
     */
    public List<VuePaperItem> getPaperListSortByTime(Integer userId);

    /**
     * 博主的全部文章列表，根据点赞排序
     * @param userId 博主的ID号
     * @return 打包成List<VuePaperItem>返回
     */
    public List<VuePaperItem> getPaperListSortByLove(Integer userId);

    /**
     * 博主的全部文章列表，根据浏览量排序
     * @param userId 博主的ID号
     * @return 打包成List<VuePaperItem>返回
     */
    public List<VuePaperItem> getPaperListSortByWatch(Integer userId);
}
