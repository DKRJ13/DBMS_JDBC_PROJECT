CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(255),
    student_age INT,
    college_id_choice INT,
    FOREIGN KEY (college_id_choice) REFERENCES College(college_id) ON DELETE SET NULL
);

CREATE TABLE College (
    college_id INT PRIMARY KEY,
    college_name VARCHAR(255),
    college_fees INT
);

CREATE TABLE Courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(255),
    course_duration INT
);

-- CREATE TABLE StudentCollege (
--     student_id INT,
--     college_id INT,
--     PRIMARY KEY (student_id, college_id),
--     FOREIGN KEY (student_id) REFERENCES Student(student_id) ON DELETE CASCADE,
--     FOREIGN KEY (college_id) REFERENCES College(college_id) ON DELETE CASCADE
-- );

CREATE TABLE CollegeCourses (
    college_id INT,   
    course_id INT,
    PRIMARY KEY (college_id, course_id),
    FOREIGN KEY (college_id) REFERENCES College(college_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) ON DELETE CASCADE
);

-- Sample Data Insertion
INSERT INTO Student VALUES (1, 'Raman', 18, NULL);
INSERT INTO Student VALUES (2, 'Ayush', 18, NULL);
INSERT INTO Student VALUES (3, 'Aditya', 19, NULL);
INSERT INTO Student VALUES (4, 'Sarthak', 19, NULL);
INSERT INTO Student VALUES (5, 'Rashmi', 18, NULL);
INSERT INTO Student VALUES (6, 'Arjun', 18, NULL);
INSERT INTO Student VALUES (7, 'Kunal', 19, NULL);
INSERT INTO Student VALUES (8, 'Yash', 19, NULL);

INSERT INTO College VALUES (1, 'IITD', 1000000);
INSERT INTO College VALUES (2, 'IIITD', 3000000);
INSERT INTO College VALUES (3, 'NIFTB', 1500000);
INSERT INTO College VALUES (4, 'JNU', 800000);

INSERT INTO Courses VALUES (1, 'CSAI', 5);
INSERT INTO Courses VALUES (2, 'MECH', 4);
INSERT INTO Courses VALUES (3, 'ELEC', 4);
INSERT INTO Courses VALUES (4, 'EVLSI', 5);
INSERT INTO Courses VALUES (5, 'DESIGN', 3);
INSERT INTO Courses VALUES (6, 'POLSCIE', 3);
INSERT INTO Courses VALUES (7, 'CSBS', 4);

-- INSERT INTO StudentCollege VALUES (1, 1);
-- INSERT INTO StudentCollege VALUES (2, 1);
-- INSERT INTO StudentCollege VALUES (3, 2);
-- INSERT INTO StudentCollege VALUES (4, 2);
-- INSERT INTO StudentCollege VALUES (5, 4);
-- INSERT INTO StudentCollege VALUES (6, 3);
-- INSERT INTO StudentCollege VALUES (7, 4);
-- INSERT INTO StudentCollege VALUES (8, 4);

Update Student set college_id_choice = 1 where student_id = 1;
Update Student set college_id_choice = 4 where student_id = 2;
Update Student set college_id_choice = 6 where student_id = 3;
Update Student set college_id_choice = 2 where student_id = 4;
Update Student set college_id_choice = 2 where student_id = 5;
Update Student set college_id_choice = 1 where student_id = 6;
Update Student set college_id_choice = 6 where student_id = 7;
Update Student set college_id_choice = 4 where student_id = 8;

INSERT INTO CollegeCourses VALUES (1, 1);
INSERT INTO CollegeCourses VALUES (2, 4);
INSERT INTO CollegeCourses VALUES (1, 2);
INSERT INTO CollegeCourses VALUES (4, 6);
INSERT INTO CollegeCourses VALUES (2, 1);
INSERT INTO CollegeCourses VALUES (2, 7);
INSERT INTO CollegeCourses VALUES (1, 3);
INSERT INTO CollegeCourses VALUES (3, 5);
