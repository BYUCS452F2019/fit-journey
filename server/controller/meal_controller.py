from flask_restful import Resource, reqparse, request
from datetime import datetime

meals = [
    {
        "meal_id": 1,
        "day_id": 1,
        "time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "calories": 500
    },
    {
        "meal_id": 2,
        "day_id": 1,
        "time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "calories": 1000
    },
    {
        "meal_id": 3,
        "day_id": 2,
        "time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "calories": 1200
    }
]

class Meal(Resource):
    def get(self, mealID):
        mealID = int(mealID)
        for meal in meals:
            if(mealID == meal["meal_id"]):
                return meal, 200
        return "Meal not found", 404

    def post(self, mealID):
        request.get_json()
        mealID = int(mealID)
        print(request)
        parser = reqparse.RequestParser()
        parser.add_argument("day_id")
        parser.add_argument("time")
        parser.add_argument("calories")
        args = parser.parse_args()

        for meal in meals:
            if(mealID == meal["meal_id"]):
                return "Food Item with id {} already exists".format(mealID), 400

        meal = {
            "meal_id": mealID,
            "day_id": args["day_id"],
            "time": args["time"],
            "calories": args["calories"]
        }
        
        meals.append(meal)
        return meal, 201

    def put(self, mealID):
        request.get_json()
        mealID = int(mealID)
        parser = reqparse.RequestParser()
        parser.add_argument("day_id")
        parser.add_argument("time")
        parser.add_argument("calories")
        args = parser.parse_args()

        for meal in meals:
            if(mealID == meal["meal_id"]):
                meal["day_id"] = args["day_id"]
                meal["time"] = args["time"]
                meal["calories"] = args["calories"]
                return "Meal with id {} already exists".format(mealID), 201

        meal = {
            "meal_id": 3,
            "day_id": args["day_id"],
            "time": args["time"],
            "calories": args["calories"]
        }
        meals.append(meal)
        return meal, 201

    def delete(self, mealID):
        mealID = int(mealID)
        global meals
        meals = [meal for meal in meals if meal["meal_id"] != mealID]
        return "{} is deleted.".format(mealID), 200
