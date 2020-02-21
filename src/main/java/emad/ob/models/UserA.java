package emad.ob.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * The User Model.
 */
@Entity
public class UserA {
	@Id
	@Column(name = "userId")
	private Integer userId;

	private float points;

	/**
	 * Empty User Constructor
	 */
	public UserA() {
	}

	/**
	 * User Constructor
	 * 
	 * @param userId
	 * @param points
	 */
	public UserA(Integer userId, float points) {
		super();
		this.userId = userId;
		this.points = points;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}
}
