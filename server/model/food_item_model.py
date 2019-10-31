
#!/usr/bin/python

import psycopg2
from config import config

def insert_food_item(food_item):
    """ insert a new food_item into the food_items table """
    sql = """INSERT INTO food_items(meal_id, food_name, portion_size) 
             VALUES(%s, %s, %s); """

    conn = None 
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (food_item["meal_id"], food_item["food_name"], food_item["portion_size"]))
        conn.commit()
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

def put_food_item(food_item):
    sql = """ UPDATE food_items
              SET meal_id = %s, food_name = %s, portion_size = %s
              WHERE food_item_id = %s"""

    conn = None
    upfood_named_rows = 0
    print(food_item)
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (food_item["meal_id"], food_item["food_name"], food_item["portion_size"]))
        upfood_named_rows = cur.rowcount
        conn.commit()
        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return upfood_named_rows

def get_food_item(food_item_id):
    sql = """ SELECT * FROM food_items WHERE food_item_id = %s"""

    conn = None
    food_item = None
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (food_item_id,))
        row = cur.fetchone()
        
        if row == None:
            food_item = None

        else:
            food_item = {
                "food_item_id": food_item_id,
                "meal_id": row[1],
                "food_name": row[2],
                "portion_size": row[3]
            }

        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return food_item

def delete_food_item(food_item_id):
    sql = """ DELETE FROM food_items WHERE food_item_id = %s """

    conn = None
    rows_deleted = 0
    try:
        params = config()
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        cur.execute(sql, (food_item_id,))
        rows_deleted = cur.rowcount

        cur.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

    return rows_deleted
