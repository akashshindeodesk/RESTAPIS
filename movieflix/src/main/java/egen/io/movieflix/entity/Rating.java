package egen.io.movieflix.entity;



import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author anude
 */
@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Rating.findAll", query = "SELECT r from Rating r"),
	@NamedQuery(name = "Rating.findByRanking", query = "SELECT r from Rating r where r.movieRanking=:pmovieRanking ORDER BY r.movieRanking")
	})
public class Rating implements Serializable {

@Id
@Column(name = "RATING_ID")
private String id; 
private double userRating;

private double averageRating;
@Column(unique = true, nullable = false)
private int movieRanking;


public double getAverageRating() {
	return averageRating;
}

@ManyToOne
private User user;

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public void setAverageRating(double averageRating) {
	this.averageRating = averageRating;
}

public Rating(){
	id = UUID.randomUUID().toString();
}

public double getUserRating() {
	return userRating;
}

public void setUserRating(double userRating) {
	this.userRating = userRating;
}

public String getId() {
	return id;
}

public int getMovieRanking() {
	return movieRanking;
}
public void setMovieRanking(int movieRanking) {
	this.movieRanking = movieRanking;
}
public void setId(String id) {
	this.id = id;
}

@Override
public String toString() {
	return "Rating [id=" + id + ", averageRating=" + averageRating + ", movieRanking="
			+ movieRanking + "]";
}
}