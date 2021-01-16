package suep.rg.brcode.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suep.rg.brcode.Dao.CommentDao;
import suep.rg.brcode.Dao.UserDao;
import suep.rg.brcode.Entity.Comment;
import suep.rg.brcode.Entity.rev.BaseComment;
import suep.rg.brcode.Entity.rev.Reply;
import suep.rg.brcode.Entity.send.VueReply;
import suep.rg.brcode.Service.CommentService;
import suep.rg.brcode.Utils.LoadUtils;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    CommentDao commentDao;
    @Autowired
    UserDao userDao;

    @Override
    public VueReply getReplyByCommentId(Integer commentId) {
        Comment comment = commentDao.findCommentById(commentId);
        String username = userDao.findUserById(comment.getUserId()).getUsername();
        return LoadUtils.load(username, comment);
    }

    @Override
    public Boolean saveComment(BaseComment comment) {
        Comment init = LoadUtils.init(comment);
        commentDao.save(init);
        return true;
    }

    @Override
    public Boolean saveRely(Reply reply) {
        Comment init = LoadUtils.init(reply);
        commentDao.save(init);
        return true;
    }
}
