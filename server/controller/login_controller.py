import sys
from flask_restful import Resource, reqparse, request

from login_model import *

class Login(Resource):
    def get(self):
        request.get_json()
        print(request)
        parser.add_argument("username")
        parser.add_argument("password")
        args = parser.parse_args()
        user = get_user(args["username"], args["password"])
        if user == 1:
            return "User not found", 404
        if user == None:
            return "Password incorrect", 403
        else:
            return user, 200
