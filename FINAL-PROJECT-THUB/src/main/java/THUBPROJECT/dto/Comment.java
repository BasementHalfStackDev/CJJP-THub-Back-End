/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;

	@ManyToOne
	@JoinColumn(name = "comment_by")
	private User comment_by;

	@ManyToOne
	@JoinColumn(name = "in_post")
	private Post in_post;

	// Constructors

	public Comment() {
	}

	public Comment(Long id, String content, User comment_by, Post in_post) {
		this.id = id;
		this.content = content;
		this.comment_by = comment_by;
		this.in_post = in_post;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public User getComment_by() {
		return comment_by;
	}

	public Post getIn_post() {
		return in_post;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setComment_by(User comment_by) {
		this.comment_by = comment_by;
	}

	public void setIn_post(Post in_post) {
		this.in_post = in_post;
	}

}
