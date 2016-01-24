package sk.ness.interview.service;

import java.util.List;

import sk.ness.interview.domain.Comment;

/**
 * Service should be used as a gateway to {@link Comment} world and handle all comments related manipulation.
 *
 * @author dominika.sedlakova
 *
 */
public interface CommentService {

  /** Returns {@link Comment} with provided ID */
	Comment findByID(Integer commentId);

  /** Returns all available {@link Article}s */
  List<Comment> findAll();

  /** Creates new {@link Comment} */
  void createComment(Comment comment);
}
