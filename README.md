# FitJourney

## Project Description

Don’t you hate having to use three or more different apps to keep track of your workouts, diet, and cadio? I know I do. The goal of this app is to provide a full suite of fitness tools, including but not limited to:

- Tracking diet with macros and calorie intake
- Tracking workouts, with reps, sets, weights, excercises, RPE, etc.
- Tracking run times, mile paces, distance, etc.
- Sharing your workouts with other users

## Team

I’m looking for two to three software engineers, especially those with experience in front end.

## SQL

Leaning towards using PostgreSQL for the relational database, although I’m open to suggestions.

## NoSQL

A good NoSQL database works better for a high volume of posts and data, and fitness people tend to generate a high volume of data because they track everything about their lives. As such, a NoSQL database could be useful after a certain point.

## Project Architecture

I’m thinking of going with a headless server for the backend and a webapp front end written in something like Vue, React, etc. That way there’s room to grow and expand to Android and iOS, and it’s platform agnostic.

## Business Plan

With social media elements, this has the chance to really explode and make some money.

I’d like to keep the app free to use, otherwise no one will ever switch off of their deeply entrenched excel sheets, myfitnesspal, etc.

Revenue source would come from ads, but we've gotta keep them small and innocuous so they don't distract from the actual usage of the app.

Move fast and break things.

## Priorities

1. Pick a better name
2. Decide on front-end architecture
3. Get off the ground and deploy to production as fast as possible
4. Test-driven development

## Legal Details

If we get far enough, make an LLC


# Installation and Usage

## Backend Installation

* Clone the repo
* Ensure you have all needed python dependencies (flask_restful, psycopg2, sys)
* Install PostgreSQL
* Create a fitjourney database and user with correct permissions
* Give it password fit
* For more db information see `server/model/database.ini`

## Backend Usage

* Run `python /model/init.py`
* Run `python server.py`
* Connect to the proper host/port
* Make API calls

## Frontend Installation

## Frontend Usage

