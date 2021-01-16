package suep.rg.brcode.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import suep.rg.brcode.Entity.rev.BaseComment;
import suep.rg.brcode.Entity.rev.Reply;
import suep.rg.brcode.Result.Result;

@Controller
@RequestMapping(value = "/api")
public interface CommentController {

    /**
     * 根据评论的ID，获取回复功能基本需要的信息
     * @param commentId 评论ID
     * @return VueReply打包
     */
    public Result getReply(Integer commentId);

    /**
     * 保存前端发送的评论
     * @param comment 用户评论
     * @return 成功
     */
    public Result saveComment(BaseComment comment);

    /**
     * 保存回复
     * @param reply 用户回复
     * @return 成功
     */
    public Result saveRely(Reply reply);
}
