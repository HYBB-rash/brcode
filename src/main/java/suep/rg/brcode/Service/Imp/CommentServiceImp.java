package suep.rg.brcode.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import suep.rg.brcode.Dao.CommentDao;
import suep.rg.brcode.Dao.UserDao;
import suep.rg.brcode.Entity.Comment;
import suep.rg.brcode.Entity.rev.BaseComment;
import suep.rg.brcode.Entity.rev.Reply;
import suep.rg.brcode.Entity.send.VueComment;
import suep.rg.brcode.Entity.send.VueReply;
import suep.rg.brcode.Service.CommentService;
import suep.rg.brcode.Utils.LoadUtils;

import java.util.LinkedList;
import java.util.List;

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

    private List<VueComment> load(Page<Comment> all) {
        List<VueComment> list = new LinkedList<>();
        for (Comment comment : all) {
            VueComment vueComment = new VueComment();
            vueComment.setId(comment.getId());
            vueComment.setCommentId(comment.getCommentId());
            vueComment.setStatus(comment.getStatus());
            vueComment.setTime(comment.getTime());
            vueComment.setUserId(comment.getUserId());
            vueComment.setContent(comment.getContent());
            list.add(vueComment);
        }
        return list;
    }

    @Override
    public List<VueComment> getCommentByUserId(Integer index, Integer size, Integer userId) {
        Pageable pageable = PageRequest.of(index, size, Sort.by("time").descending());
        Page<Comment> comments = commentDao.findCommentsByUserId(userId, pageable);
        return load(comments);
    }

    @Override
    public Boolean deleteCommentById(Integer commentId) {
        Comment comment = commentDao.findCommentById(commentId);
        comment.setStatus(0);
        commentDao.save(comment);
        return true;
    }
}
