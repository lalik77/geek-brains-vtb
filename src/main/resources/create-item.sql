
DROP TABLE items;

CREATE TABLE items (
    id int GENERATED ALWAYS AS IDENTITY ,
    val int,
    version BIGINT
);

