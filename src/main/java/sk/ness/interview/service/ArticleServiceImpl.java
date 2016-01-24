package sk.ness.interview.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sk.ness.interview.dao.ArticleDAO;
import sk.ness.interview.domain.Article;

/**
 * Service should be used as a gateway to {@link Article} world and handle all article related manipulation.
 *
 * @author michal.kmetka
 *
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

  @Resource
  private ArticleDAO articleDAO;

  @Override
  public Article findByID(final Integer articleId) {
    return this.articleDAO.findByID(articleId);
  }

  @Override
  public List<Article> findAll() {
    return this.articleDAO.findAll();
  }

  @Override
  public void createArticle(final Article article) {
    this.articleDAO.persist(article);
  }

  @Override
  public void ingestArticles(final Article[] jsonArticles) {
  	for(Article article : jsonArticles){
  		createArticle(article);
  	}
  }
  
  @Override
  public List<Article> containsString(final String string){
	  List<Article> articles = findAll();
	  List<Article> articlesToBeReturned = new ArrayList<Article>();
	  for(Article article : articles){
		  if(article.toString().contains(string))
			  articlesToBeReturned.add(article);
	  }
	  return articlesToBeReturned;
  }

}
