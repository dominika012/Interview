package sk.ness.interview.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sk.ness.interview.dao.CommentDAO;
import sk.ness.interview.domain.Comment;

/**
 * Service should be used as a gateway to {@link Comment} world and handle all
 * comments related manipulation.
 *
 * @author dominika.sedlakova
 *
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentDAO commentDAO;

	@Override
	public Comment findByID(final Integer commentId) {
		return this.commentDAO.findByID(commentId);
	}

	@Override
	public List<Comment> findAll() {
		return this.commentDAO.findAll();
	}

	@Override
	public void createComment(final Comment comment) {
		this.commentDAO.persist(comment);
	}
}
