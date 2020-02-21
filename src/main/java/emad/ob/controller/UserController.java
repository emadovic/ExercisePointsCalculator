package emad.ob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import emad.ob.helper.Helper;
import emad.ob.helper.HttpHelper;
import emad.ob.helper.StringHelper;
import emad.ob.helper.UserMappingHelper;
import emad.ob.models.UserA;
import emad.ob.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @return all existing Users in DB
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public ResponseEntity<?> GetAllUSers() {
		try {
			List<UserA> userList = userService.getAllUsers();

			return HttpHelper.getHttpResponseEntity(userList, HttpStatus.OK);

		} catch (Exception e) {
			return HttpHelper.getHttpResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * 
	 * @param userMappingHelper
	 * @return Inserts new Exercise in DB.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public ResponseEntity<?> addUser(@RequestBody UserMappingHelper userMappingHelper) {
		try {
			if (!Helper.isNullOrEmpty(userMappingHelper)) {
				UserA userList = new UserA(userMappingHelper.getUserId(), userMappingHelper.getPoints());
				userService.insertUser(userList);
				return HttpHelper.getHttpResponseEntity(userList, HttpStatus.CREATED);
			} else
				return HttpHelper.getHttpResponseEntity(StringHelper.FIELD_NAME_NULL_OR_EMPTY, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return HttpHelper.getHttpResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * 
	 * @return the Ranking List, where the users are sorted depending on the points
	 *         they got.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/ranking")
	public List<UserA> sortByPoints() {
		userService.calculateRankings();
		return userService.orderByPointsDesc();
	}
}
