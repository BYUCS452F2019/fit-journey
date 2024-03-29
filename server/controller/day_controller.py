from flask_restful import Resource, reqparse, request
from datetime import datetime

from day_model import *

days = [
    {
        "day_id": 1,
        "user_id": 1,
        "date": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "total_calories": 2000
    },
    {
        "day_id": 2,
        "user_id": 2,
        "date": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "total_calories": 3000
    },
    {
        "day_id": 3,
        "user_id": 3,
        "date": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "total_calories": 2500
    }
]

class Day(Resource):
    def get(self, dayID):
        dayID = int(dayID)
        for day in days:
            if(dayID == day["day_id"]):
                return day, 200
        return "Day not found", 404

    def post(self, dayID):
        request.get_json()
        dayID = int(dayID)
        print(request)
        parser = reqparse.RequestParser()
        parser.add_argument("user_id")
        parser.add_argument("date")
        parser.add_argument("total_calories")
        args = parser.parse_args()

        if (get_day(dayID) != None):
            return "Day with id {} already exists".format(dayID), 400

        day = {
            "day_id": dayID,
            "user_id": args["user_id"],
            "date": args["date"],
            "total_calories": args["total_calories"]
        }
        
        #days.append(day)
        insert_day(day)
        return day, 201

    def put(self, dayID):
        request.get_json()
        dayID = int(dayID)
        parser = reqparse.RequestParser()
        parser.add_argument("user_id")
        parser.add_argument("date")
        parser.add_argument("total_calories")
        args = parser.parse_args()

        day = {
            "day_id": dayID,
            "user_id": args["user_id"],
            "date": args["date"],
            "total_calories": args["total_calories"]
        }
        if (get_day(dayID) != None):
            return "Day with id {} updated".format(dayID), 201

        else:
            insert_day(day)
            return day, 201

    def delete(self, dayID):
        dayID = int(dayID)
        rows = delete_day(dayID)
        return "{} rows deleted.".format(rows), 200
