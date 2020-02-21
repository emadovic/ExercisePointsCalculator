package emad.ob.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import emad.ob.models.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

	@Query("select a from Exercise a where a.startTime >= :startTime")
	List<Exercise> findAllWithStartTimeAfter(@Param("startTime") LocalDateTime creationDateTime);

}
