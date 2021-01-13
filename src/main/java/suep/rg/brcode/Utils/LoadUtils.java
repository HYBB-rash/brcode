package suep.rg.brcode.Utils;

import suep.rg.brcode.Entity.Comment;
import suep.rg.brcode.Entity.Love;
import suep.rg.brcode.Entity.Paper;
import suep.rg.brcode.Entity.Watch;
import suep.rg.brcode.Entity.rev.IPV4;
import suep.rg.brcode.Entity.send.VueComment;
import suep.rg.brcode.Entity.send.VuePaper;

import java.util.ArrayList;
import java.util.List;

public class LoadUtils {

    public static Watch load(IPV4 ipv4, Integer paperId) {
        Watch watch = new Watch();
        watch.setPaperId(paperId);
        watch.setIpv4(ipv4.getIp());
        watch.setTime(TimeUtils.getNowTime());
        return watch;
    }

    public static VuePaper load(Paper paper) {
        VuePaper vuePaper = new VuePaper();
        vuePaper.setPaperId(paper.getId());
        vuePaper.setContent(paper.getContent());
        vuePaper.setTitle(paper.getTitle());
        return vuePaper;
    }

    public static Love load(Integer paperId, Integer userId) {
        Love love = new Love();
        love.setPaperId(paperId);
        love.setUserId(userId);
        love.setTime(TimeUtils.getNowTime());
        return love;
    }

    public static VueComment load(Comment comment) {
        VueComment vueComment = new VueComment();
        vueComment.setCommentId(comment.getCommentId());
        vueComment.setContent(comment.getContent());
        vueComment.setId(comment.getId());
        vueComment.setTime(comment.getTime());
        vueComment.setUserId(comment.getUserId());
        vueComment.setStatus(comment.getStatus());
        return vueComment;
    }

    public static List<VueComment> load(List<Comment> comments) {
        List<VueComment> vueComments = new ArrayList<>();
        for (Comment comment : comments) {
            vueComments.add(load(comment));
        }
        return vueComments;
    }
}
