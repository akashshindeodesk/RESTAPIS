package egen.io.movieflix.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author anude
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Comment.findAll", query = "SELECT c from Comment c"),
	@NamedQuery(name = "Comment.findByMovie", query = "SELECT c from Comment c where c.movie=:pmovie AND c.user=:puser")
})
public class Comment implements Serializable {

	@Id
	@Column(name = "COMMENT_ID")
	private String id;
	private String message;
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Comment(){
		id = UUID.randomUUID().toString();	
		
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;


	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	


	@ManyToOne(cascade = CascadeType.ALL)
	private Movie movie;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	
}
