DO $$
    DECLARE
        counter INTEGER := 1;
    BEGIN
        WHILE counter <= 40 LOOP
                INSERT INTO items (val, version) VALUES (0,0);
                counter := counter + 1;
            END LOOP;
    END $$;