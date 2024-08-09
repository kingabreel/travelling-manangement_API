CREATE TABLE destiny (
    id SERIAL PRIMARY KEY,
    name TEXT,
    country TEXT,
    city TEXT,
    time_zone TEXT
);

CREATE TABLE travel (
    id SERIAL PRIMARY KEY,
    name TEXT,
    destiny_id int,
    departure TIMESTAMP,
    arrival TIMESTAMP,
    price NUMERIC
);