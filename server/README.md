# API Documentation

## REST Endpoints

* These urls can be hit with GET, POST, PUT, or DELETE requests, and they manipulate the objects as expected.
* The JSON below each one is an example of that object

* Users
  * URL - http://host:port/user/<userID>
  * Example:
      {
          "user_id": 1,
          "username": "nick12",
          "password": "nick",
          "first_name": "Nicholas",
          "last_name": "Cage",
          "age": 42,
          "current_weight": 100,
          "goal_weight": 90,
          "height": 200,
          "gender": "M"
      }

* Runs
  * URL - http://host:port/run/<runID>
  * Example:
      {
          "run_id": 1,
          "user_id": 1,
          "distance": 40,
          "start_time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
          "end_time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
          "pace": 100,
          "calories_burned": 300,
          "route": "TODO"
      }

* Meals
  * URL - http://host:port/meal/<mealID>
  * Example:
      {
          "meal_id": 1,
          "user_id": 1,
          "time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
          "calories": 500
      }

* Food_Items
  * URL - http://host:port/food_item/<foodItemID>
  * Example:
    {
        "food_item_id": 1,
        "meal_id": 1,
        "food_name": "Apple",
        "portion_size": 300
    }


## Other Endpoints

* Get all meals for a user
  * URL - http://host:port/meals_user/<userID>

* Get all runs for a user
  * URL - http://host:port/runs_user/<userID>
