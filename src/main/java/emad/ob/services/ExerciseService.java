package emad.ob.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import emad.ob.repository.ExerciseRepository;
import emad.ob.models.Exercise;

@Service
public class ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;

	/**
	 * 
	 * The method needed to get all exercises available in DB.
	 * 
	 */
	public List<Exercise> getAllExercises() {

		List<Exercise> exer = new ArrayList<>();

		exerciseRepository.findAll().forEach(exer::add);
		return exer;
	}

	/**
	 * 
	 * The method needed to insert new exercise in DB.
	 * 
	 */
	public void insertExercise(Exercise exercise) {

		exerciseRepository.save(exercise);

	}

	/**
	 * 
	 * The method needed to update specified exercise available in DB.
	 * 
	 */
	public void updateExercise(int id, Exercise exercise) {

		exerciseRepository.save(exercise);
	}

	/**
	 * 
	 * The method needed to get specific exercise available in DB.
	 * 
	 */
	public Exercise getExercise(int id) {

		Optional<Exercise> getexer = exerciseRepository.findById(id);
		Exercise getExercise = getexer.get();
		return getExercise;

	}

	/**
	 * 
	 * The method needed to calculate the exercises that began with specific period
	 * of time (28 days in our project).
	 * 
	 */
	public List<Exercise> findAllWithStartTimeAfter(LocalDateTime startTime) {
		return exerciseRepository.findAllWithStartTimeAfter(startTime);
	}

}
