package emad.ob.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * 
 * The EXERCISE Model.
 */
@Entity
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int exerciseId;

	@NotNull
	private ExerciseType description;

	private LocalDateTime startTime;

	@NotNull
	private Integer duration;

	@NotNull
	private Integer calories;

	@ManyToOne
	@JoinColumn(name = "user_Id", referencedColumnName = "userId")
	private UserA usera;

	/**
	 * Empty Constructor
	 */
	public Exercise() {
		startTime = LocalDateTime.now();
	}

	/**
	 * Exercise Constructor
	 * 
	 * @param exerciseId
	 * @param description
	 * @param duration
	 * @param calories
	 * @param userId
	 */
	public Exercise(int exerciseId, @NotNull ExerciseType description, @NotNull Integer duration,
			@NotNull Integer calories, Integer userId) {
		super();
		this.exerciseId = exerciseId;
		this.description = description;
		this.duration = duration;
		this.calories = calories;
		this.usera = new UserA(userId, 0);
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int id) {
		this.exerciseId = id;
	}

	public UserA getUsera() {
		return usera;
	}

	public void setUsera(UserA usera) {
		this.usera = usera;
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

}