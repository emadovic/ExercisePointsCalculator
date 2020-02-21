package emad.ob.helper;

import emad.ob.models.UserA;

/**
 * Helper for mapping the User
 */
public class UserMappingHelper {

	private Integer userId;
	private float points;
	private UserA usera;
	private int exerciseId;

	public int getId() {
		return exerciseId;
	}

	public void setId(int id) {
		this.exerciseId = id;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}

	public UserA getUsera() {
		return usera;
	}

	public void setUsera(UserA usera) {
		this.usera = usera;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}