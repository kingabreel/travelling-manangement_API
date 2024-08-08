CREATE TABLE destiny (
    id UUID,
    name TEXT,
    country TEXT,
    city TEXT,
    time_zone TEXT
);

CREATE TABLE travel (
    id UUID,
    name TEXT,
    destiny_id int,
    departure TIMESTAMP,
    arrival TIMESTAMP,
    price NUMERIC
);