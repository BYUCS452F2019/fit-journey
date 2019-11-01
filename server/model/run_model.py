#!/usr/bin/python

import psycopg2
from config import config

def insert_run(run):
    """ insert a new run into the runs table """
    sql = """INSERT INTO runs(run_id, user_id, distance, start_time, end_time,
             pace, calories_burned, route) 
             VALUES(%s, %s, %s, %s, %s, %s, %s, %s); """

    conn = None 
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (run["run_id"], run["user_id"], run["distance"], run["start_time"],
                          run["end_time"], run["pace"],
                          run["calories_burned"], run["route"]))
        conn.commit()
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

def put_run(run):
    sql = """ UPDATE runs
              SET user_id = %s, distance = %s, start_time = %s, end_time =
              %s, pace = %s, calories_burned = %s, route = %s
              WHERE run_id = %s"""

    conn = None
    updated_rows = 0
    print(run)
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (run["user_id"], run["distance"], run["start_time"],
                          run["end_time"], run["pace"],
                          run["calories_burned"], run["route"]))
        updated_rows = cur.rowcount
        conn.commit()
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return updated_rows

def get_run(run_id):
    sql = """ SELECT * FROM runs WHERE run_id = %s"""

    conn = None
    run = None
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (run_id,))
        row = cur.fetchone()
        
        if row == None:
            run = None

        else:
            run = {
                "run_id": run_id,
                "user_id": row[1],
                "distance": row[2],
                "start_time": row[3],
                "end_time": row[4],
                "pace": row[5],
                "calories_burned": row[6],
                "route": row[7]
            }

        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return run

def delete_run(run_id):
    sql = """ DELETE FROM runs WHERE run_id = %s """

    conn = None
    rows_deleted = 0
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (run_id,))
        rows_deleted = cur.rowcount

        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return rows_deleted
