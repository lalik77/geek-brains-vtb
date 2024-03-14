
DROP TABLE purchases;

CREATE TABLE purchases (

    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    customer_id INTEGER,
    item_id     INTEGER,
    purchase_price DECIMAL(10,2),
    purchase_date TIMESTAMP
);
