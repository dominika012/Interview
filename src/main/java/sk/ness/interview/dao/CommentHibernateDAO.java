package sk.ness.interview.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import sk.ness.interview.domain.Comment;

/**
 * DAO for {@link Comment} related DB operations
 *
 * @author dominika.sedlakova
 *
 */
@Repository
public class CommentHibernateDAO implements CommentDAO {

  @Resource(name = "sessionFactory")
  private SessionFactory sessionFactory;

  @Override
  public Comment findByID(final Integer commentId) {
    return (Comment) this.sessionFactory.getCurrentSession().get(Comment.class, commentId);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Comment> findAll() {
    return this.sessionFactory.getCurrentSession().createSQLQuery("select * from comments").addEntity(Comment.class).list();
  }

  @Override
  public void persist(final Comment comment) {
    this.sessionFactory.getCurrentSession().saveOrUpdate(comment);
  }

}
