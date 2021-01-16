package suep.rg.brcode.Service;

import org.springframework.stereotype.Service;
import suep.rg.brcode.Entity.rev.BaseComment;
import suep.rg.brcode.Entity.rev.Reply;
import suep.rg.brcode.Entity.send.VueComment;
import suep.rg.brcode.Entity.send.VueReply;

import java.util.List;

@Service
public interface CommentService {

    public VueReply getReplyByCommentId(Integer commentId);

    public Boolean saveComment(BaseComment comment);

    public Boolean saveRely(Reply reply);

    public List<VueComment> getCommentByUserId(Integer index, Integer size, Integer userId);

    public Boolean deleteCommentById(Integer commentId);
}
