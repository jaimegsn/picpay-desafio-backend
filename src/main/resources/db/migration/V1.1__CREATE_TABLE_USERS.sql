CREATE TABLE IF NOT EXISTS "users" (
    id SERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    document VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    password VARCHAR(20) NOT NULL,
    balance DECIMAL(11,2) NOT NULL,
    user_type VARCHAR(11) NOT NULL
);