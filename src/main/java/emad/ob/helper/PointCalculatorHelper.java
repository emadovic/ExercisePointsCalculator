package emad.ob.helper;

import emad.ob.models.ExerciseType;

public class PointCalculatorHelper {

	/**
	 * 
	 * @param exerciseType
	 * @return Points earned depending on the Description (Exercise Type)
	 */
	public static float getPointsByExerciseType(ExerciseType exerciseType) {

		switch (exerciseType) {
		case RUNNING:
			return 2;
		case SWIMMING:
			return 3;
		case STRENGTH_TRAINING:
			return 3;
		case CIRCUT_TRAINING:
			return 4;
		default:
			return 0;
		}

	}

	/**
	 * 
	 * @param time
	 * @return points, depending on the Duration
	 */
	public static float getPointsByDuration(int time) {
		if (time > 60) {
			if (time % 60 != 0) {
				return (time / 60) + 1;
			} else {
				return time / 60;
			}
		} else
			return 1;
	}

}
