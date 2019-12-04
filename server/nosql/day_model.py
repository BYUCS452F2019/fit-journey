#!/usr/bin/python

import psycopg2
from config import config

def insert_day(day):
    """ insert a new day into the days table """
    sql = """INSERT INTO days(day_id, user_id, date, total_calories) 
             VALUES(%s, %s, %s, %s); """

    conn = None 
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (day["day_id"], day["user_id"], day["date"], day["total_calories"]))
        conn.commit()
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

def put_day(day):
    sql = """ UPDATE days
              SET user_id = %s, date = %s, total_calories = %s
              WHERE day_id = %s"""

    conn = None
    updated_rows = 0
    print(day)
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (day["user_id"], day["date"], day["total_calories"]))
        updated_rows = cur.rowcount
        conn.commit()
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return updated_rows

def get_day(day_id):
    sql = """ SELECT * FROM days WHERE day_id = %s"""

    conn = None
    day = None
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (day_id,))
        row = cur.fetchone()
        
        if row == None:
            day = None

        else:
            day = {
                "day_id": day_id,
                "user_id": row[1],
                "date": row[2],
                "total_calories": row[3]
            }

        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return day

def delete_day(day_id):
    sql = """ DELETE FROM days WHERE day_id = %s """

    conn = None
    rows_deleted = 0
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (day_id,))
        rows_deleted = cur.rowcount

        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return rows_deleted
