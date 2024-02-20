CREATE TABLE students
(
    id              INTEGER PRIMARY KEY NOT NULL,
    passport_serial VARCHAR(10),
    passport_number VARCHAR(20)
);


CREATE TABLE courses
(
    id     INTEGER PRIMARY KEY NOT NULL,
    course_name VARCHAR(20)
);


CREATE TABLE progress
(
    id         INTEGER PRIMARY KEY              NOT NULL,
    student_id INTEGER REFERENCES students (id) NOT NULL,
    course_id  INTEGER REFERENCES courses (id)  NOT NULL,
    mark       INTEGER CHECK ( mark>=2 AND mark <=5 )
);