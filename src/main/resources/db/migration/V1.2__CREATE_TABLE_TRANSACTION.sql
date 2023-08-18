CREATE TABLE IF NOT EXISTS "transaction" (
    id SERIAL NOT NULL PRIMARY KEY,
    amount DECIMAL(11,2) NOT NULL,
    sender_id BIGINT NOT NULL,
    receiver_id BIGINT NOT NULL,
    FOREIGN KEY (sender_id) REFERENCES users(id),
    FOREIGN KEY (receiver_id) REFERENCES users(id),
    time_stamp TIMESTAMP
);