#!/usr/bin/python

from pymongo import MongoClient

def insert_day(day):
    """ insert a new day into the days table """
    client = MongoClient()
    db = client["fit_journey"]
    days = db["days"]

    result = days.insert_one(day)

def put_day(day):
    client = MongoClient()
    db = client["fit_journey"]
    days = db["days"]

    result = days.update_one({"day_id":day["day_id"]}, {"$set": day},
                              upsert=False)

def get_day(day_id):
    client = MongoClient()
    db = client["fit_journey"]
    days = db["days"]

    result = days.find({"day_id":day_id})

    for doc in result:
        doc['_id'] = str(doc['_id'])
        return doc

def delete_day(day_id):
    client = MongoClient()
    db = client["fit_journey"]
    days = db["days"]

    result = days.delete_one({"day_id":day_id})
    return result.deleted_count
