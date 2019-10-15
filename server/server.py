import sys

from flask import Flask
from flask_restful import Api, Resource, reqparse

sys.path.insert(1, "./controller")

import user_controller
import run_controller

app = Flask(__name__)
api = Api(app)

api.add_resource(user_controller.User, "/user/<string:userID>")
api.add_resource(run_controller.Run, "/run/<string:runID>")

app.run(debug=True)
