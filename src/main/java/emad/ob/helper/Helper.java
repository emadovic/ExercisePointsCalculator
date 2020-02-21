package emad.ob.helper;

import org.springframework.util.StringUtils;

public class Helper {

	/**
	 * This function is checking if all the instances of exerciseMappingHelper are
	 * not null or empty
	 *
	 * @param exeriseMappingHelper
	 * @return true or false
	 */
	public static boolean isNullOrEmpty(ExerciseMappingHelper exerciseMappingHelper) {

		// checking if the ExerciseHelper has empty or null values
		if (exerciseMappingHelper.getDescription() == null || exerciseMappingHelper.getDuration() == 0
				|| exerciseMappingHelper.getCalories() == 0) {
			return true;
		} else
			return false;
	}

	public static boolean isNullOrEmpty(UserMappingHelper usereMappingHelper) {

		// checking if the ExerciseHelper has empty or null values
		if (usereMappingHelper.getPoints() == 0 || usereMappingHelper.getUserId() == 0) {
			return true;
		} else
			return false;
	}

	/**
	 * This function tests if the string is null or empty
	 *
	 * @param arg
	 * @return true or false
	 */
	public static boolean isNullOrEmpty(String arg) {
		if (StringUtils.isEmpty(arg))
			return true;
		else
			return false;
	}
}
