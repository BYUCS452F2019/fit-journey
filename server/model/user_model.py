#!/usr/bin/python

import psycopg2
from config import config

def insert_user(user):
    """ insert a new user into the users table """
    sql = """INSERT INTO users(username, password, first_name,
             last_name, age, current_weight, goal_weight, height, gender)
             VALUES(%s, %s, %s, %s, %s, %s, %s, %s , %s); """

    conn = None 
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (user["username"], user["password"], user["first_name"],
                          user["last_name"], user["age"],
                          user["current_weight"], user["goal_weight"],
                          user["height"], user["gender"]))
        conn.commit()
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

def put_user(user):
    sql = """ UPDATE users
              SET username = %s, password = %s, first_name = %s, last_name =
              %s, age = %s, current_weight = %s, goal_weight = %s, height = %s,
              gender = %s
              WHERE user_id = %s"""

    conn = None
    updated_rows = 0
    print(user)
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (user["username"], user["password"], user["first_name"],
                          user["last_name"], user["age"],
                          user["current_weight"], user["goal_weight"],
                          user["height"], user["gender"], user["user_id"]))
        updated_rows = cur.rowcount
        conn.commit()
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return updated_rows

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
