package suep.rg.brcode.Service;

import org.springframework.stereotype.Service;
import suep.rg.brcode.Entity.send.VuePaper;

@Service
public interface EditPaperService {

    /**
     * 根据用户ID和文章ID查出文章内容发送回去
     * @param userId 用户的ID
     * @param paperId 文章的ID
     * @return 根据VuePaper结构打包
     */
    public VuePaper getPaperContent(Integer userId, Integer paperId);

    /**
     * 将文章信息保存下来
     * @param paper VueEditPaper结构有啥就是啥
     * @return 返回一个成功信息即可
     */
    public Boolean savePaper(VuePaper paper, Integer userId);

    /**
     * 后端将文章信息保存下来，并且文章状态更新为已发布
     * @param paper VueEditPaper结构有啥就是啥
     * @return 返回一个成功信息即可
     */
    public Boolean savePaperAndSent(VuePaper paper, Integer userId);

    public Boolean deletePaper(Integer paperId);
}
