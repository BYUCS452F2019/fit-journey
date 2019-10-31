#!/usr/bin/python
import psycopg2
from config import config

def connect():
    """ Connect to the PostgreSQL database server """
    conn = None
    try:
        # read connection parameters
        params = config()

        # connect to the PostgreSQL server
        print('Connecting to the PostgreSQL database...')
        conn = psycopg2.connect(**params)
        
        cur = conn.cursor()

        # execute a statement

        print('PostgreSQL database version:')
        cur.execute('SELECT version()')

        # display the PostgreSQL database server verison
        db_version = cur.fetchone()
        print(db_version)

        # close the connection
        cur.close()
        
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()
            print('Database connection closed.')

def create_tables():
    """ create tables in the PostgreSQL database"""
    commands = (
        """
        DROP TABLE IF EXISTS users, runs, days, meals, food_items
        """,
        """
        CREATE TABLE users (
            user_id INTEGER PRIMARY KEY,
            username VARCHAR(15) NOT NULL,
            password VARCHAR(25) NOT NULL,
            first_name VARCHAR(15) NOT NULL,
            last_name VARCHAR(15) NOT NULL,
            age INTEGER NOT NULL,
            current_weight REAL NOT NULL,
            goal_weight REAL NOT NULL,
            height REAL NOT NULL,
            gender VARCHAR(1)
        )
        """,
        """ CREATE TABLE runs (
                run_id INTEGER PRIMARY KEY,
                user_id INTEGER NOT NULL,
                distance REAL NOT NULL,
                start_time VARCHAR(128),
                end_time VARCHAR(128),
                pace REAL NOT NULL,
                calories_burned INTEGER NOT NULL
                )
        """,
        """
        CREATE TABLE days (
                day_id INTEGER PRIMARY KEY,
                date VARCHAR(128) NOT NULL,
                user_id INTEGER NOT NULL
        )
        """,
        """
        CREATE TABLE meals (
                meal_id INTEGER NOT NULL,
                day_id INTEGER NOT NULL,
                time VARCHAR(128) NOT NULL,
                calories INTEGER NOT NULL
        )
        """,
        """
        CREATE TABLE food_items (
                food_item_id INTEGER PRIMARY KEY,
                meal_id INTEGER NOT NULL,
                food_name VARCHAR(25) NOT NULL,
                portion_size INTEGER NOT NULL
        )
        """)
    conn = None
    try:
        # read the connection parameters
        params = config()
        # connect to the PostgreSQL server
        conn = psycopg2.connect(**params)
        cur = conn.cursor()
        # create table one by one
        for command in commands:
            cur.execute(command)
        # close communication with the PostgreSQL database server
        cur.close()
        # commit the changes
        conn.commit()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()

if __name__ == '__main__':
    connect()
    create_tables()
