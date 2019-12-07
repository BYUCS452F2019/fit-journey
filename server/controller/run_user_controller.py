from flask_restful import Resource, reqparse, request
from datetime import datetime

from run_user_model import *

class Run_List(Resource):
    def get(self, userID):
        runs = get_run_list(userID)
        if len(runs) == 0:
            return "No runs for user", 404
        else:
            return runs, 200
