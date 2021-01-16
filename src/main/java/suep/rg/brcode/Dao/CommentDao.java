package suep.rg.brcode.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import suep.rg.brcode.Entity.Comment;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer> {

    List<Comment> findCommentsByPaperId(Integer paperId);
    Comment findCommentById(Integer id);
    Page<Comment> findCommentsByUserId(Integer userId, Pageable pageable);
    List<Comment> getCommentsByUserId(Integer userId);
}
