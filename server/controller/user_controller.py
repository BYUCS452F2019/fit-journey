import sys
from flask_restful import Resource, reqparse, request

from user_model import *

users = [
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
    },
    {
        "user_id": 2,
        "username": "james123",
        "password": "avatar",
        "first_name": "James",
        "last_name": "Cameron",
        "age": 50,
        "current_weight": 90,
        "goal_weight": 80,
        "height": 180,
        "gender": "M"
    },
    {
        "user_id": 3,
        "username": "ironwoman",
        "password": "tory",
        "first_name": "Magaret",
        "last_name": "Thatcher",
        "age": 65,
        "current_weight": 60,
        "goal_weight": 65,
        "height": 160,
        "gender": "F"
    }
]

class User(Resource):
    def get(self, userID):
        userID = int(userID)
        user = get_user(userID)
        if user == None:
            return "User not found", 404
        else:
            return user, 200

        #for user in users:
        #    if(userID == user["user_id"]):
        #        return user, 200
        #return "User not found", 404

    def post(self, userID):
        request.get_json()
        userID = int(userID)
        print(request)
        parser = reqparse.RequestParser()
        parser.add_argument("username")
        parser.add_argument("password")
        parser.add_argument("first_name")
        parser.add_argument("last_name")
        parser.add_argument("age")
        parser.add_argument("current_weight")
        parser.add_argument("goal_weight")
        parser.add_argument("height")
        parser.add_argument("gender")
        args = parser.parse_args()

        #for user in users:
        #    if(userID == user["user_id"]):
        if(get_user(userID) != None):
            return "User with id {} already exists".format(userID), 400

        user = {
            "user_id": userID,
            "username": args["username"],
            "password": args["password"],
            "first_name": args["first_name"],
            "last_name": args["last_name"],
            "age": args["age"],
            "current_weight": args["current_weight"],
            "goal_weight": args["goal_weight"],
            "height": args["height"],
            "gender": args["gender"]
        }
        
        #users.append(user)
        insert_user(user)
        return user, 201

    def put(self, userID):
        request.get_json()
        userID = int(userID)
        parser = reqparse.RequestParser()
        parser.add_argument("username")
        parser.add_argument("password")
        parser.add_argument("first_name")
        parser.add_argument("last_name")
        parser.add_argument("age")
        parser.add_argument("current_weight")
        parser.add_argument("goal_weight")
        parser.add_argument("height")
        parser.add_argument("gender")
        args = parser.parse_args()

        user = {
            "user_id": userID,
            "username": args["username"],
            "password": args["password"],
            "first_name": args["first_name"],
            "last_name": args["last_name"],
            "age": args["age"],
            "current_weight": args["current_weight"],
            "goal_weight": args["goal_weight"],
            "height": args["height"],
            "gender": args["gender"]
        }
        if(get_user(userID) != None):
            print(user)
            put_user(user)
            return "User with id {} already exists".format(userID), 201
        
        else:
            insert_user(user)
            return user, 201

    def delete(self, userID):
        userID = int(userID)
        row_count = delete_user(userID)
        #global users
        #users = [user for user in users if user["user_id"] != userID]
        return "{} rows deleted.".format(row_count), 200
