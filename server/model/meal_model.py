#!/usr/bin/python

import psycopg2
from config import config

def insert_meal(meal):
    """ insert a new meal into the meals table """
    sql = """INSERT INTO meals(day_id, time, calories) 
             VALUES(%s, %s, %s); """

    conn = None 
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (meal["day_id"], meal["time"], meal["calories"]))
        conn.commit()
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

def put_meal(meal):
    sql = """ UPDATE meals
              SET day_id = %s, time = %s, calories = %s
              WHERE meal_id = %s"""

    conn = None
    uptimed_rows = 0
    print(meal)
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (meal["day_id"], meal["time"], meal["calories"]))
        uptimed_rows = cur.rowcount
        conn.commit()
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return uptimed_rows

def get_meal(meal_id):
    sql = """ SELECT * FROM meals WHERE meal_id = %s"""

    conn = None
    meal = None
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (meal_id,))
        row = cur.fetchone()
        
        if row == None:
            meal = None

        else:
            meal = {
                "meal_id": meal_id,
                "day_id": row[1],
                "time": row[2],
                "calories": row[3]
            }

        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return meal

def delete_meal(meal_id):
    sql = """ DELETE FROM meals WHERE meal_id = %s """

    conn = None
    rows_deleted = 0
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (meal_id,))
        rows_deleted = cur.rowcount

        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return rows_deleted
