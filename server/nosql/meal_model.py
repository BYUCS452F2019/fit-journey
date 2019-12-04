#!/usr/bin/python

from pymongo import MongoClient

def insert_meal(meal):
    """ insert a new meal into the meals table """
    client = MongoClient()
    db = client["fit_journey"]
    meals = db["meals"]

    result = meals.insert_one(meal)

def put_meal(meal):
    client = MongoClient()
    db = client["fit_journey"]
    meals = db["meals"]

    result = meals.update_one({"meal_id":meal["meal_id"]}, {"$set": meal},
                              upsert=False)

def get_meal(meal_id):
    client = MongoClient()
    db = client["fit_journey"]
    meals = db["meals"]

    result = meals.find({"meal_id":meal_id})

    for doc in result:
        doc['_id'] = str(doc['_id'])
        return doc

def delete_meal(meal_id):
    client = MongoClient()
    db = client["fit_journey"]
    meals = db["meals"]

    result = meals.delete_one({"meal_id":meal_id})
    return result.deleted_count
