from flask_restful import Resource, reqparse, request
from datetime import datetime

from meal_user_model import *

meals = [
    {
        "meal_id": 1,
        "user_id": 1,
        "time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "calories": 500
    },
    {
        "meal_id": 2,
        "user_id": 1,
        "time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "calories": 1000
    },
    {
        "meal_id": 3,
        "user_id": 2,
        "time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "calories": 1200
    }
]

class Meal_List(Resource):
    def get(self, userID):
        meals = get_meal_list(userID)
        if len(meals) == 0:
            return "No meals for user", 404
        else:
            return meals, 200
