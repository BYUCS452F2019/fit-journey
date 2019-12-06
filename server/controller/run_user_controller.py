from flask_restful import Resource, reqparse, request
from datetime import datetime

from run_user_model import *

runs = [
    {
        "run_id": 1,
        "user_id": 1,
        "time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "calories": 500
    },
    {
        "run_id": 2,
        "user_id": 1,
        "time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "calories": 1000
    },
    {
        "run_id": 3,
        "user_id": 2,
        "time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "calories": 1200
    }
]

class RunList(Resource):
    def get(self, userID):
        runs = get_run_list(userID)
        if len(runs) == 0:
            return "No runs for user", 404
        else:
            return runs, 200
