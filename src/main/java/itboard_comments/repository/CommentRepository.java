package itboard_comments.repository;

import itboard_comments.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    Iterable<Comment> findByPostId(long postId);
}
