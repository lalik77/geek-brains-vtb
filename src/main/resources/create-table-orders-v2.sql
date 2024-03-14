
DROP TABLE orders;

CREATE TABLE orders
(
    order_id          INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    customer_id INTEGER,
    item_id     INTEGER,
    FOREIGN KEY (customer_id) REFERENCES customers (id) ON DELETE SET NULL,
    FOREIGN KEY (item_id) REFERENCES items (id) ON DELETE SET NULL
);