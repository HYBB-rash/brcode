package suep.rg.brcode.Service;

import org.springframework.stereotype.Service;
import suep.rg.brcode.Entity.rev.IPV4;
import suep.rg.brcode.Entity.send.VueComment;
import suep.rg.brcode.Entity.send.VuePaper;

import java.util.List;

@Service
public interface ClickPaperService {

    /**
     * 纪录该IP的用户已经浏览过文章
     * @param ipv4 IP地址
     * @param paperId 文章ID
     */
    public void recordWatch(IPV4 ipv4, Integer paperId);

    /**
     * 打包文章内容
     * @param paperId 文章ID
     * @return 打包文章的内容
     */
    public VuePaper getPaper(Integer paperId);

    /**
     * 获取点赞数
     * @param paperId 文章的ID
     * @return 一个数字，文章的点赞数即可
     */
    public Integer getLoveCount(Integer paperId);

    /**
     * 确认这个用户有没有给这个用户点赞
     * @param paperId 文章的ID
     * @param userId 用户的ID
     * @return 一个bool值，true是点赞了，false是没点赞
     */
    public Boolean ensureHaveLove(Integer paperId, Integer userId);

    /**
     * 点赞该文章
     * @param paperId 文章的ID
     * @param userId 用户的ID
     * @return 一个bool值，true是点赞成功了，false是没点赞成功
     */
    public Boolean loveThisPaper(Integer paperId, Integer userId);

    /**
     * 返回该文章的所有评论
     * @param paperId 文章的ID
     * @return 根据VueComment进行打包
     */
    public List<VueComment> getPaperComments(Integer paperId);
}
