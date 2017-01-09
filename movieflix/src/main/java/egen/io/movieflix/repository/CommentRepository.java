package egen.io.movieflix.repository;

import java.util.List;

import egen.io.movieflix.entity.Comment;
import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.entity.User;

public interface CommentRepository {


	public List<Comment> findAll();

	public Comment findOne(String commentId);

	public void delete(Comment existing);

	public Comment update(Comment comment);

	public Comment create(Comment comment);
	
	public List<Comment> findByMovie(String movieId, String userId);
	
}
