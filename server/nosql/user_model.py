#!/usr/bin/python

from pymongo import MongoClient

def insert_user(user):
    """ insert a new user into the users table """
    client = MongoClient()
    db = client["fit_journey"]
    users = db["users"]

    result = users.insert_one(user)
    print('One post: {0}'.format(result.inserted_id))

def put_user(user):
    client = MongoClient()
    db = client["fit_journey"]
    users = db["users"]

    result = users.update_one({"user_id":user["user_id"]}, {"$set": user},
                              upsert=False)

    print('One update: {0}'.format(result))

def get_user(user_id):
    sql = """ SELECT * FROM users WHERE user_id = %s"""

    conn = None
    user = None
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (user_id,))
        row = cur.fetchone()
        
        if row == None:
            user = None

        else:
            user = {
                "user_id": user_id,
                "username": row[1],
                "password": row[2],
                "first_name": row[3],
                "last_name": row[4],
                "age": row[5],
                "current_weight": row[6],
                "goal_weight": row[7],
                "height": row[8],
                "gender": row[9]
            }

        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return user

def delete_user(user_id):
    sql = """ DELETE FROM users WHERE user_id = %s """

    conn = None
    rows_deleted = 0
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (user_id,))
        rows_deleted = cur.rowcount

        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return rows_deleted
