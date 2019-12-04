#!/usr/bin/python

from pymongo import MongoClient

def insert_user(user):
    """ insert a new user into the users table """
    client = MongoClient()
    db = client["fit_journey"]
    users = db["users"]

    result = users.insert_one(user)

def put_user(user):
    client = MongoClient()
    db = client["fit_journey"]
    users = db["users"]

    result = users.update_one({"user_id":user["user_id"]}, {"$set": user},
                              upsert=False)

def get_user(user_id):
    client = MongoClient()
    db = client["fit_journey"]
    users = db["users"]

    result = users.find({"user_id":user_id})

    for doc in result:
        doc['_id'] = str(doc['_id'])
        return doc

def delete_user(user_id):
    client = MongoClient()
    db = client["fit_journey"]
    users = db["users"]

    result = users.delete_one({"user_id":user_id})
    return result.deleted_count
