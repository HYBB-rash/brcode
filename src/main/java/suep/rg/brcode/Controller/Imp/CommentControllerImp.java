package suep.rg.brcode.Controller.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import suep.rg.brcode.Controller.CommentController;
import suep.rg.brcode.Entity.rev.BaseComment;
import suep.rg.brcode.Entity.rev.Reply;
import suep.rg.brcode.Entity.send.VueComment;
import suep.rg.brcode.Entity.send.VueReply;
import suep.rg.brcode.Result.Result;
import suep.rg.brcode.Result.ResultFactory;
import suep.rg.brcode.Service.CommentService;

import java.util.List;

@Controller
public class CommentControllerImp implements CommentController {

    @Autowired
    CommentService commentService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/comment/reply/{commentId}")
    @Override
    public Result getReply(@PathVariable Integer commentId) {
        VueReply reply = commentService.getReplyByCommentId(commentId);
        return ResultFactory.buildSuccessResult(reply);
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("/comment/save")
    @Override
    public Result saveComment(@RequestBody BaseComment comment) {
        Boolean saveComment = commentService.saveComment(comment);
        return ResultFactory.buildSuccessResult(saveComment);
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("/reply/save")
    @Override
    public Result saveRely(@RequestBody Reply reply) {
        Boolean saveRely = commentService.saveRely(reply);
        return ResultFactory.buildSuccessResult(saveRely);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/comment/all")
    @Override
    public Result getComments(
            @RequestParam("userId") Integer userId,
            @RequestParam("index") Integer index,
            @RequestParam("size") Integer size) {
        List<VueComment> comments = commentService.getCommentByUserId(index, size, userId);
        return ResultFactory.buildSuccessResult(comments);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/comment/delete/{commentId}")
    @Override
    public Result deleteCommentId(@PathVariable Integer commentId) {
        Boolean result = commentService.deleteCommentById(commentId);
        return ResultFactory.buildSuccessResult(result);
    }
}
