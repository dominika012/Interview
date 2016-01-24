package sk.ness.interview.dao;

import java.util.List;
import sk.ness.interview.domain.Comment;

public interface CommentDAO {

  /** Returns {@link Comment} with provided ID */
	Comment findByID(Integer commentId);

  /** Returns all available {@link Comment}s */
  List<Comment> findAll();

  /** Persists {@link Comment} into the DB */
  void persist(Comment comment);
}
