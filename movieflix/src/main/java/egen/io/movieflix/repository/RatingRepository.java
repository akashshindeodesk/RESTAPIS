package egen.io.movieflix.repository;

import java.util.List;

import egen.io.movieflix.entity.Rating;
import egen.io.movieflix.entity.User;

public interface RatingRepository {


	public Rating findOne(String ratingId);

	public Rating findByRanking(int movieRanking);

	public Rating create(Rating rating);

	public Rating update(Rating rating);

	public void delete(Rating existing);

	public List<Rating> findAll();

}
