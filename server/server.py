import sys

from flask import Flask
from flask_restful import Api, Resource, reqparse

sys.path.insert(1, "./controller")
sys.path.insert(1, "./nosql")

import user_controller
import run_controller
import day_controller
import meal_controller
import meal_user_controller
import run_user_controller
import food_item_controller

app = Flask(__name__)
api = Api(app)

api.add_resource(user_controller.User, "/user/<string:userID>")
api.add_resource(run_controller.Run, "/run/<string:runID>")
api.add_resource(day_controller.Day, "/day/<string:dayID>")
api.add_resource(meal_controller.Meal, "/meal/<string:mealID>")
api.add_resource(food_item_controller.Food_Item, "/food_item/<string:food_itemID>")

api.add_resource(meal_user_controller.Meal_List, "/meals_user/<string:userID>")
api.add_resource(run_user_controller.Run_List, "/run_user/<string:userID>")

app.run(debug=True,host='0.0.0.0')
