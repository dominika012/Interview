package sk.ness.interview.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "articles")
@SequenceGenerator(name = "articles_seq_store", sequenceName = "article_seq", allocationSize = 1)
public class Article {

	@Id
	@Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articles_seq_store")
	private Integer article_id;

	@Column(name = "title", length = 250)
	private String title;

	@Column(name = "text", length = 2000)
	private String text;

	@Column(name = "author", length = 250)
	private String author;

	@Column(name = "create_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTimestamp;
/*
	//@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> comments;
*/
	public Article() {
		this.createTimestamp = new Date();
	}

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getText() {
		return this.text;
	}

	public void setText(final String text) {
		this.text = text;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public Date getCreateTimestamp() {
		return this.createTimestamp;
	}

	/*
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	*/
}
