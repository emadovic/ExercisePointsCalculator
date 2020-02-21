package emad.ob.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class HttpHelper {

	// ********* For All Controllers, to response with needed HTTP Status *********

	public static ResponseEntity<?> getHttpResponseEntity(HttpStatus status) {
		return new ResponseEntity<>(status);
	}

	public static ResponseEntity<?> getHttpResponseEntity(String message, HttpStatus status) {
		return new ResponseEntity<>(message, status);
	}

	public static ResponseEntity<?> getHttpResponseEntity(Object obj, HttpStatus status) {
		return new ResponseEntity<>(obj, status);
	}

	public static ResponseEntity<?> getHttpResponseEntity(List<?> exerciseList, HttpStatus status) {
		return new ResponseEntity<>(exerciseList, status);
	}

}
