#!/usr/bin/python

from pymongo import MongoClient

def get_run_list(user_id):
    client = MongoClient()
    db = client["fit_journey"]
    runs = db["runs"]

    result = runs.find({"user_id":user_id})
    result_list = []

    for doc in result:
        doc['_id'] = str(doc['_id'])
        result_list.append(doc)

    return result_list
