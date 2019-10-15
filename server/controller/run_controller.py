from flask_restful import Resource
from datetime import datetime

runs = [
    {
        "run_id": 1,
        "user_id": 1,
        "distance": 40,
        "start_time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "end_time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "pace": 100,
        "calories_burned": 300,
        "route": "TODO"
    },
    {
        "run_id": 2,
        "user_id": 1,
        "distance": 50,
        "start_time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "end_time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "pace": 10,
        "calories_burned": 400,
        "route": "TODO"
    },
    {
        "run_id": 3,
        "user_id": 2,
        "distance": 90,
        "start_time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "end_time": datetime.now().strftime('%Y-%m-%dT%H:%M:%S.%f'),
        "pace": 50,
        "calories_burned": 500,
        "route": "TODO"
    }
]

class Run(Resource):
    def get(self, runID):
        runID = int(runID)
        for run in runs:
            if(runID == run["run_id"]):
                return run, 200
        return "Run not found", 404

    def post(self, runID):
        runID = int(runID)
        parser = reqparse.RequestParser()
        parser.add_argument("user_id")
        parser.add_argument("distance")
        parser.add_argument("start_time")
        parser.add_argument("end_time")
        parser.add_argument("pace")
        parser.add_argument("calories_burned")
        parser.add_argument("route")
        args = parser.parse_args()

        for run in runs:
            if(runID == run["run_id"]):
                return "Run with id {} already exists".format(runID), 400
        
        run = {
            "run_id": runID,
            "user_id": args["user_id"],
            "distance": args["distance"],
            "start_time": args["start_time"],
            "end_time": args["end_time"],
            "pace": args["pace"],
            "calories_burned": args["calories_burned"],
            "route": args["route"]
        }
        runs.append(run)
        return run, 201

    def put(self, runID):
        runID = int(runID)
        parser = reqparse.RequestParser()
        parser.add_argument("user_id")
        parser.add_argument("distance")
        parser.add_argument("start_time")
        parser.add_argument("end_time")
        parser.add_argument("pace")
        parser.add_argument("calories_burned")
        parser.add_argument("route")
        args = parser.parse_args()

        for run in runs:
            if(runID == run["run_id"]):
                run["user_id"] = args["user_id"],
                run["distance"] = args["distance"],
                run["start_time"] = args["start_time"],
                run["end_time"] = args["end_time"],
                run["pace"] = args["pace"],
                run["calories_burned"] = args["calories_burned"],
                run["route"] = args["route"]
                return "Run with id {} updated".format(runID), 201
        
        run = {
            "run_id": runID,
            "user_id": args["user_id"],
            "distance": args["distance"],
            "start_time": args["start_time"],
            "end_time": args["end_time"],
            "pace": args["pace"],
            "calories_burned": args["calories_burned"],
            "route": args["route"]
        }
        runs.append(run)
        return run, 201

    def delete(self, runID):
        runID = int(runID)
        global runs
        runs = [run for run in runs if run["run_id"] != runID]
        return "{} is deleted.".format(runID), 200
