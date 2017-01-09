package egen.io.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.entity.Rating;
import egen.io.movieflix.entity.User;

@Repository
public class RatingRepositoryImpl implements RatingRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Rating> findAll() {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findAll", Rating.class);
		return query.getResultList();
	}

	@Override
	public Rating findOne(String ratingId) {
		return em.find(Rating.class, ratingId);
	}

	@Override
	public Rating create(Rating rating) {
		em.persist(rating); 
		return rating;
	}

	@Override
	public Rating update(Rating rating) {
		return em.merge(rating);
	}

	@Override
	public void delete(Rating existing) {
		em.remove(existing);
	}

	@Override
	public Rating findByRanking(int movieRanking) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findByRanking", Rating.class);
		query.setParameter("pmovieRanking", movieRanking);
		List<Rating> ratings = query.getResultList();
		if (ratings.size() == 1) {
			return ratings.get(0);
		} else {
			return null;
		}
	}

}
