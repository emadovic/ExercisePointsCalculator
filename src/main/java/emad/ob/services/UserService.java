package emad.ob.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import emad.ob.helper.PointCalculatorHelper;
import emad.ob.models.Exercise;
import emad.ob.models.UserA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import emad.ob.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ExerciseService exerciseService;

	/**
	 * 
	 * The method needed to get all users available in DB.
	 * 
	 */
	public List<UserA> getAllUsers() {

		List<UserA> usr = new ArrayList<>();

		userRepository.findAll().forEach(usr::add);
		return usr;
	}

	/**
	 * 
	 * The method needed to insert new exercise available in DB.
	 * 
	 */
	public void insertUser(UserA usr) {

		userRepository.save(usr);

	}

	/**
	 * 
	 * The method needed to sort all users depending on their points available in
	 * DB.
	 * 
	 */

	public List<UserA> orderByPointsDesc() { // sort users
		return userRepository.findAllByOrderByPointsDesc();
	}

	/**
	 * 
	 * The method needed to calculate the points earned by one exercise.
	 * 
	 */
	private void calculatePoints(List<Exercise> exercises) {
		float result;
		for (Exercise exercise : exercises) {
			result = (exercise.getCalories() + PointCalculatorHelper.getPointsByDuration(exercise.getDuration()))
					* PointCalculatorHelper.getPointsByExerciseType(exercise.getDescription());
			UserA user = userRepository.getOne(exercise.getUsera().getUserId());
			user.setPoints(user.getPoints() + result);
			userRepository.save(user);
		}
	}

	/**
	 * 
	 * The method needed calculate the ranking of the users depending on the points
	 * they earned from each exercise in the past 28 days.
	 * 
	 */
	public void calculateRankings() {
		List<Exercise> exercises = exerciseService.findAllWithStartTimeAfter(LocalDateTime.now().minusDays(28));
		List<UserA> users = userRepository.findAll();
		users.forEach(user -> user.setPoints(0));
		userRepository.saveAll(users);
		calculatePoints(exercises);Ï
	}
}
