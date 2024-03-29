ALTER TABLE items
ADD COLUMN  price decimal;

UPDATE items
SET price = id * 20 ;