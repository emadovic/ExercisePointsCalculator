# ExercisePointsCalculator
Api that calculates points from exercises,  and then sort users depending on their points.

I built this RestFul API using Java Spring Boot and JPA & H2 as Database.

**API Documentation**
This App allows you to preform CRUD operations for Users, and Exercises. From each exercise points can be calculated and sum up for each user, then sort the users depending on their points.

**Entities:**

- Exercise - exerciseId, descreption, startTime, calories, userId(foriegn key).
- User - userId, points.
- ExerciseType ENUM {
  - RUNNING, 
  - SWIMMING, 
  - STRENGTH_TRAINING, 
  - CIRCTUT_TRAINING 
 }

**_Routes:_**

**Exercise Routes:**

- Route URL: http://localhost:8080/exercises on this route you can preform GET and POST request, so you can GET all exercuses in the database and add new (POST) exercise.
- Route URL: http://localhost:8080/exercises/{id} on this route you preform GET,and PUT request, so you can update and get the exercise by its id.

**User Routes:**

- Route URL: http://localhost:8080/users on this route you can preform GET and POST requests , so you can GET all users in the database and add new (POST) user.
- Route URL: http://localhost:8080/ranking on this route you can preform GET the list in which all users are ranked depending on their points.

**Points Calculation and Constrains:**
- The points are counted only in the past 28 days
  - Example: if today is 30/01/2020, then points for users are counted from 02/01/2020 only.
- A user gets one point per started minute of the duration of the exercise plus the burnt calories.
  - Example: One exercise lasting 80 seconds plus 80 calories burnt will result in 82 points. 
- Each exercise type has a multiplication factor for the point calculation:
  - `RUNNING` - 2
  - `SWIMMING` - 3
  - `STRENGTH_TRAINING` - 3
  - `CIRCUIT_TRAINING` - 4


NOTE:
- The database will be dropped and get created each time you run the server(the database has initial data so you can start testing).
- Example of the put request of the exercise
  ``` 
    {
        "description": "SWIMMING",
        "duration": 80,
        "calories": 500,
        "userId":1
    }
- exerciseId and startTime is automatically created. startTime is created according to the current time so dont bother puting it in post body.
- However startTime can be updated by you but it should be in the correct format yyyy-MM-ddThh:mm:ss.SSS.
