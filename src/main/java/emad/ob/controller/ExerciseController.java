package emad.ob.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import emad.ob.helper.ExerciseMappingHelper;
import emad.ob.helper.Helper;
import emad.ob.helper.HttpHelper;
import emad.ob.helper.StringHelper;
import emad.ob.models.*;
import emad.ob.repository.ExerciseRepository;
import emad.ob.services.ExerciseService;

@RestController
public class ExerciseController {

	@Autowired
	private ExerciseRepository exerciseRepository;

	@Autowired
	private ExerciseService exerciseService;

	/**
	 * This function returns all exercises
	 * 
	 * @return list of all exercises in DB.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/exercises")
	public ResponseEntity<?> GetAllExercises() {
		try {
			List<Exercise> exerList = exerciseRepository.findAll();
			if (!exerList.isEmpty())

				return HttpHelper.getHttpResponseEntity(exerList, HttpStatus.OK);

			return HttpHelper.getHttpResponseEntity(StringHelper.NO_EXERCISE_IN_DATABASE, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return HttpHelper.getHttpResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * 
	 * @param exerciseMappingHelper
	 * @return the added exercise
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/exercises")
	public ResponseEntity<?> addExercise(@RequestBody ExerciseMappingHelper exerciseMappingHelper) {

		try {

			if (!Helper.isNullOrEmpty(exerciseMappingHelper)) {
				Exercise exer = new Exercise(exerciseMappingHelper.getId(), exerciseMappingHelper.getDescription(),
						exerciseMappingHelper.getDuration(), exerciseMappingHelper.getCalories(),
						exerciseMappingHelper.getUserId());

				exer.setStartTime(LocalDateTime.now());
				exerciseService.insertExercise(exer);
				return HttpHelper.getHttpResponseEntity(exer, HttpStatus.CREATED);
			} else
				return HttpHelper.getHttpResponseEntity(StringHelper.FIELD_NAME_NULL_OR_EMPTY, HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			return HttpHelper.getHttpResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 
	 * @param exerciseMappingHelper
	 * @param id
	 * @return Update specified Exercise{id}
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/exercises/{id}")
	public ResponseEntity<?> updateExercise(@RequestBody ExerciseMappingHelper exerciseMappingHelper,
			@PathVariable int id) {
		try {
			Exercise exer = exerciseService.getExercise(id);

			exer.setStartTime(exerciseMappingHelper.getStartTime());
			exer.setDuration(exerciseMappingHelper.getDuration());
			exer.setCalories(exerciseMappingHelper.getCalories());
			exerciseRepository.save(exer);
			return HttpHelper.getHttpResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return HttpHelper.getHttpResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 
	 * @param id
	 * @return find specified exercise by it's ID
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/exercise/{id}")
	public ResponseEntity<?> getExercise(@PathVariable int id) {
		try {
			Optional<Exercise> exercise = exerciseRepository.findById(id);
			return new ResponseEntity<>(exercise, HttpStatus.OK);
		} catch (Exception e) {
			return HttpHelper.getHttpResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}