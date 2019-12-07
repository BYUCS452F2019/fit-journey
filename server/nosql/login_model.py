#!/usr/bin/python

from pymongo import MongoClient

def get_user(username, password):
    client = MongoClient()
    db = client["fit_journey"]
    users = db["users"]

    result = users.find({"username":username})
    if len(result) == 0:
        return 1

    for doc in result:
        doc['_id'] = str(doc['_id'])
        if doc['password'] == password:
            return doc
    else: return None
