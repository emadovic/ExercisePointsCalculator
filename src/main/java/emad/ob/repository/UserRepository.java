package emad.ob.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import emad.ob.models.UserA;

public interface UserRepository extends JpaRepository<UserA, Integer> {

	@Query("select u from UserA u order by u.points desc")
	public List<UserA> findAllByOrderByPointsDesc();

}
