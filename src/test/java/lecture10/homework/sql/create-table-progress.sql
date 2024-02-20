CREATE TABLE progress
(
    id         INTEGER PRIMARY KEY NOT NULL,
    student_id INTEGER             NOT NULL,
    course_id  INTEGER             NOT NULL,
    mark       INTEGER
);