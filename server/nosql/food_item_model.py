#!/usr/bin/python

from pymongo import MongoClient

def insert_food_item(food_item):
    """ insert a new food_item into the food_items table """
    client = MongoClient()
    db = client["fit_journey"]
    food_items = db["food_items"]

    result = food_items.insert_one(food_item)

def put_food_item(food_item):
    client = MongoClient()
    db = client["fit_journey"]
    food_items = db["food_items"]

    result = food_items.update_one({"food_item_id":food_item["food_item_id"]}, {"$set": food_item},
                              upsert=False)

def get_food_item(food_item_id):
    client = MongoClient()
    db = client["fit_journey"]
    food_items = db["food_items"]

    result = food_items.find({"food_item_id":food_item_id})

    for doc in result:
        doc['_id'] = str(doc['_id'])
        return doc

def delete_food_item(food_item_id):
    client = MongoClient()
    db = client["fit_journey"]
    food_items = db["food_items"]

    result = food_items.delete_one({"food_item_id":food_item_id})
    return result.deleted_count
