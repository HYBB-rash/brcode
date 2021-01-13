package suep.rg.brcode.Service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import suep.rg.brcode.Entity.send.VuePaperItem;

import java.awt.print.Pageable;
import java.util.List;

@Service
public interface PaperListPageService {

    // 具有分页功能的接口

    /**
     * 全站博客文章列表，根据时间排序
     * @return 打包成List<VuePaperItem>返回
     */
    public List<VuePaperItem> getPaperListSortByTime(Integer index, Integer size);

    /**
     * 全站博客文章列表，根据点赞排序
     * @return 打包成List<VuePaperItem>返回
     */
    public List<VuePaperItem> getPaperListSortByLove(Integer index, Integer size);

    /**
     * 全站博客文章列表，根据浏览量排序
     * @return 打包成List<VuePaperItem>返回
     */
    public List<VuePaperItem> getPaperListSortByWatch(Integer index, Integer size);

    /**
     * 博主的全部文章列表，根据时间排序
     * @param userId 博主的ID号
     * @return 打包成List<VuePaperItem>返回
     */
    public List<VuePaperItem> getPaperListSortByTime(Integer userId, Integer index, Integer size);

    /**
     * 博主的全部文章列表，根据点赞排序
     * @param userId 博主的ID号
     * @return 打包成List<VuePaperItem>返回
     */
    public List<VuePaperItem> getPaperListSortByLove(Integer userId, Integer index, Integer size);

    /**
     * 博主的全部文章列表，根据浏览量排序
     * @param userId 博主的ID号
     * @return 打包成List<VuePaperItem>返回
     */
    public List<VuePaperItem> getPaperListSortByWatch(Integer userId, Integer index, Integer size);
}
