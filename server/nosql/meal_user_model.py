#!/usr/bin/python

from pymongo import MongoClient

def get_meal_list(user_id):
    client = MongoClient()
    db = client["fit_journey"]
    meals = db["meals"]

    result = meals.find({"user_id":user_id})
    result_list = []

    for doc in result:
        doc['_id'] = str(doc['_id'])
        result_list.append(doc)

    return result_list
