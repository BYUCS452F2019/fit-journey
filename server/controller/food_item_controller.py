from flask_restful import Resource, reqparse, request
from datetime import datetime

from food_item_model import *

food_items = [
    {
        "food_item_id": 1,
        "meal_id": 1,
        "food_name": "Apple",
        "portion_size": 300
    },
    {
        "food_item_id": 2,
        "meal_id": 1,
        "food_name": "Banana",
        "portion_size": 200
    },
    {
        "food_item_id": 3,
        "meal_id": 2,
        "food_name": "Orange",
        "portion_size": 150
    }
]

class Food_Item(Resource):
    def get(self, food_itemID):
        food_itemID = int(food_itemID)
        food_item = get_food_item(food_itemID)
        if (food_item != None):
            return food_item, 200
        else:
            return "Food Item not found", 404

    def post(self, food_itemID):
        request.get_json()
        food_itemID = int(food_itemID)
        print(request)
        parser = reqparse.RequestParser()
        parser.add_argument("meal_id")
        parser.add_argument("food_name")
        parser.add_argument("portion_size")
        args = parser.parse_args()

        if(get_food_item(food_itemID) != None):
            return "Food Item with id {} already exists".format(food_itemID), 400

        food_item = {
            "food_item_id": food_itemID,
            "meal_id": args["meal_id"],
            "food_name": args["food_name"],
            "portion_size": args["portion_size"]
        }

        post_food_item(food_item)
        return food_item, 201

    def put(self, food_itemID):
        request.get_json()
        food_itemID = int(food_itemID)
        parser = reqparse.RequestParser()
        parser.add_argument("meal_id")
        parser.add_argument("food_name")
        parser.add_argument("portion_size")
        args = parser.parse_args()

        for food_item in food_items:
            if(food_itemID == food_item["food_item_id"]):
                food_item["meal_id"] = args["meal_id"]
                food_item["food_name"] = args["food_name"]
                food_item["portion_size"] = args["portion_size"]

        food_item = {
            "food_item_id": food_itemID,
            "meal_id": args["meal_id"],
            "food_name": args["food_name"],
            "portion_size": args["portion_size"]
        }

        if (get_food_item(food_itemID) != None):
            put_food_item(food_item)
            return "Food Item with id {} updated".format(food_itemID), 201

        else:
            insert_food_item(food_item)
            return food_item, 201
        food_items.append(food_item)
        return food_item, 201

    def delete(self, food_itemID):
        food_itemID = int(food_itemID)
        rows = delete_food_item(food_itemID)
        return "{} rows deleted.".format(rows), 200
