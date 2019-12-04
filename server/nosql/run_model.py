#!/usr/bin/python

from pymongo import MongoClient

def insert_run(run):
    """ insert a new run into the runs table """
    client = MongoClient()
    db = client["fit_journey"]
    runs = db["runs"]

    result = runs.insert_one(run)

def put_run(run):
    client = MongoClient()
    db = client["fit_journey"]
    runs = db["runs"]

    result = runs.update_one({"run_id":run["run_id"]}, {"$set": run},
                              upsert=False)

def get_run(run_id):
    client = MongoClient()
    db = client["fit_journey"]
    runs = db["runs"]

    result = runs.find({"run_id":run_id})

    for doc in result:
        doc['_id'] = str(doc['_id'])
        return doc

def delete_run(run_id):
    client = MongoClient()
    db = client["fit_journey"]
    runs = db["runs"]

    result = runs.delete_one({"run_id":run_id})
    return result.deleted_count
