package suep.rg.brcode.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import suep.rg.brcode.Entity.Comment;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer> {

    List<Comment> findCommentsByPaperId(Integer paperId);
}
