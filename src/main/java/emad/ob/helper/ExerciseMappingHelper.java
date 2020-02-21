package emad.ob.helper;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import emad.ob.models.ExerciseType;

/**
 * 
 * This is a Helper for mapping the Exercises.
 */
public class ExerciseMappingHelper {
	private int exerciseId;
	private ExerciseType description;
	private LocalDateTime startTime;
	@NotNull
	private Integer duration;
	@NotNull
	private Integer calories;
//	private float points;
	private Integer userId;

	public int getId() {
		return exerciseId;
	}

	public void setId(int id) {
		this.exerciseId = id;
	}

	public ExerciseType getDescription() {
		return description;
	}

	public void setDescription(ExerciseType description) {
		this.description = description;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}
/*
	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}
*/
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}