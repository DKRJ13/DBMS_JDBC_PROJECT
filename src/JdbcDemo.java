//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;

public class JdbcDemo {

   // Set JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost:3306/companydb?useSSL=false";
//    String url = "jdbc:mysql://localhost:3306/companydb?allowPublicKeyRetrieval=true&useSSL=false";
// Connection conn = null;
// try {
//     conn = DriverManager.getConnection(url, daksh, root);
// } catch (SQLException e) {
//     e.printStackTrace();
// }
//    // Database credentials
   static final String USER = "daksh";// add your user
   static final String PASSWORD = "root";// add password

   public static void main(String[] args){
    //System.out.println(System.getProperty("java.class.path"));
    String url = "jdbc:mysql://localhost:3306/companydb?allowPublicKeyRetrieval=true&useSSL=false";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, USER, PASSWORD);
            // Now you can use the connection object 'conn' for database operations
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection in the finally block to ensure it gets closed even if an exception occurs
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
  
    //Connection conn = null;
      Statement stmt = null;
// STEP 2. Connecting to the Database
      try {
         // STEP 2a: Register JDBC driver
         Class.forName(JDBC_DRIVER);
         // STEP 2b: Open a connection
         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         stmt = conn.createStatement();

         // STEP 2c: Execute a query
         System.out.println("Creating statement...");
         // Execute the SQL queries to create the tables

         // stmt.executeUpdate(createCollegeTable);
         // stmt.executeUpdate(createStudentTable);
         // stmt.executeUpdate(createCoursesTable);
         // stmt.executeUpdate(createCollegeCoursesTable);


         //  STEP 3: Query to database
         // String query = "SELECT fname, lname, dno, bdate from employee";
         // ResultSet rs = stmt.executeQuery(query);

         // // STEP 4: Extract data from result set
         // while (rs.next()) {

         // // Retrieve by column name
         // String fname = rs.getString("fname");
         // String lname = rs.getString("lname");
         // Date birthDate = rs.getDate("bdate", null);
         // Integer dno = rs.getInt("dno");

         // // Display values
         // System.out.print("fname: " + fname);
         // System.out.print(", lname: " + lname);
         // System.out.print(", birth date: " + birthDate.toString());
         // System.out.println(", department number: " + dno);
         // }
        conn.setAutoCommit(false);
         while(true){   
            System.out.println("Enter 1 to add a Student to database");
            System.out.println("Enter 2 to add a College to the database");
            System.out.println("Enter 3 to add a Course to the database");
            System.out.println("Enter 4 to add a Student to a College");
            System.out.println("ENter 5 to update the college choice for a Student");
            System.out.println("Enter 6 to delete a Student from the College");
            System.out.println("Enter 7 to delete a Course from the database");
            System.out.println("Enter 8 to delete a Student from the database");
            System.out.println("Enter 9 to delete College from the database");
            System.out.println("Enter 10 to update the fee of a College");
            System.out.println("Enter 11 to print all the students of a College");
            System.out.println("Enter 12 to print all the courses offered by the College");
            System.out.println("Enter 13 to change the college preference of an exixsting student to a new college");
            System.out.println("Enter 14 to add a particular course to a College's pffered courses");
            System.out.println("Enter 15 to commit changes");
            System.out.println("Enter 16 to roll back to last commit");
            System.out.println("Enter any other number to exit the program");
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

           if (choice == 1) {
               System.out.println("Enter student details...");
               addStudent(conn, stmt);                                                                                                                                                                                                                                                                                                                        
           } else if (choice == 2) {
               System.out.println("Enter college details...");
               addCollege(conn, stmt);
           } else if (choice == 3) {
               System.out.println("Enter course details...");
               addCourse(conn, stmt);
           } else if (choice == 4) {
               System.out.println("Enter student-college details...");
               addStudentToCollege(conn, stmt);
           } else if (choice == 5) {
               System.out.println("Enter student and college details...");
               updateCollegeChoice(conn, stmt);
           } else if (choice == 6) {
               System.out.println("Enter student details...");
               deleteStudentFromCollege(conn, stmt);
           } else if (choice == 7) {
               System.out.println("Enter course details...");
               deleteCourse(conn, stmt);
           } else if (choice == 8) {
               System.out.println("Enter student details...");
               deleteStudent(conn, stmt);
           } else if (choice == 9) {
               System.out.println("Enter college details...");
               deleteCollege(conn, stmt);
           } else if (choice == 10) {
               System.out.println("Enter college details...");
               updateCollegeFee(conn, stmt);
           } else if (choice == 11) {
               System.out.println("Enter college details...");
               printAllStudentsOfCollege(conn, stmt);
           } else if (choice == 12) {
               System.out.println("Enter college details...");
               printAllCoursesOfCollege(conn, stmt);
           } 
           else if (choice == 12) {
               System.out.println("Enter college details...");
               printAllCoursesOfCollege(conn, stmt);
           }
           else if (choice == 13) {
            System.out.println("Enter college details...");
            addNewCollegeAndUpdateStudentChoice(conn, stmt);
           }
          
         else if (choice == 14) {
         System.out.println("Enter college details...");
         addCourseToCollege(conn, stmt);
         }
         else if (choice == 15) {
            System.out.println("Commiting changes till now");
            conn.commit();
        } 
        else if (choice == 16) {
         System.out.println("Rolling back to the last commit");
            conn.rollback();
         }  
        else {
               System.out.println("Exiting program...");
               break;
           }

         // STEP 5: Clean-up environment
         }
         stmt.close();
         conn.close();
      } 
      catch (SQLException se) { // Handle errors for JDBC
         se.printStackTrace();
      } catch (Exception e) { // Handle errors for Class.forName
         e.printStackTrace();
      } finally { // finally block used to close resources regardless of whether an exception was
                  // thrown or not
         try {
            if (stmt != null)
               stmt.close();
         } catch (SQLException se2) {
         }
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            se.printStackTrace();
         } // end finally try
      } // end try
      System.out.println("End of Code");
   } // end main

   static void addStudent(Connection conn, Statement stmt) throws SQLException {
      System.out.println("Enter student details...");
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter student ID: ");
      int studentId = sc.nextInt();
      System.out.print("Enter student name: ");
      String studentName = sc.next();
      System.out.print("Enter student age: ");
      int studentAge = sc.nextInt();
      System.out.print("Enter college choice ID: ");
      int collegeIdChoice = sc.nextInt();

      String query = "INSERT INTO Student VALUES (" + studentId + ", '" + studentName + "', " + studentAge + ", " + collegeIdChoice + ")";
      stmt.executeUpdate(query);
      System.out.println("Student added successfully!");
  }

  static void addCollege(Connection conn, Statement stmt) throws SQLException {
      System.out.println("Enter college details...");
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter college ID: ");
      int collegeId = sc.nextInt();
      System.out.print("Enter college name: ");
      String collegeName = sc.next();
      System.out.print("Enter college fees: ");
      int collegeFees = sc.nextInt();

      String query = "INSERT INTO College VALUES (" + collegeId + ", '" + collegeName + "', " + collegeFees + ")";
      stmt.executeUpdate(query);
      System.out.println("College added successfully!");
  }

  static void addCourse(Connection conn, Statement stmt) throws SQLException {
      System.out.println("Enter course details...");
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter course ID: ");
      int courseId = sc.nextInt();
      System.out.print("Enter course name: ");
      String courseName = sc.next();
      System.out.print("Enter course duration: ");
      int courseDuration = sc.nextInt();

      String query = "INSERT INTO Courses VALUES (" + courseId + ", '" + courseName + "', " + courseDuration + ")";
      stmt.executeUpdate(query);

      System.out.println("Course added successfully!");
  }

  static void addStudentToCollege(Connection conn, Statement stmt) throws SQLException {
      System.out.println("Enter student to college details...");
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter student ID: ");
      int studentId = sc.nextInt();
      System.out.print("Enter college ID: ");
      int collegeId = sc.nextInt();

      String query = "UPDATE Student SET college_id_choice = " + collegeId + " WHERE student_id = " + studentId;
      int rowsAffected = stmt.executeUpdate(query);
      //System.out.print(rowsAffected);
   
   
      if (rowsAffected == 0) {
          System.out.println("No student found with ID " + studentId + ". Query invalid");
      } else {
          System.out.println("Student's college choice updated successfully!");
      }
  }

  static void updateCollegeChoice(Connection conn, Statement stmt) throws SQLException {
      System.out.println("Enter student and new college details...");
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter student ID: ");
      int studentId = sc.nextInt();
      System.out.print("Enter new college ID: ");
      int collegeId = sc.nextInt();

      String query = "UPDATE Student SET college_id_choice = " + collegeId + " WHERE student_id = " + studentId;
      int rowsAffected = stmt.executeUpdate(query);
      //System.out.print(rowsAffected);
   
   
      if (rowsAffected == 0) {
          System.out.println("No student found with ID " + studentId + ". Student's college choice not updated.");
      } else {
          System.out.println("Student's college choice updated successfully!");
      }
  }

  static void deleteStudentFromCollege(Connection conn, Statement stmt) throws SQLException {
      System.out.println("Enter student details to delete from college...");
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter student ID: ");
      int studentId = sc.nextInt();

      String query = "UPDATE Student SET college_id_choice = NULL WHERE student_id = " + studentId;
      int rowsAffected = stmt.executeUpdate(query);
      //System.out.print(rowsAffected);
   
   
      if (rowsAffected == 0) {
          System.out.println("No student found with ID " + studentId + ". Delete invalid");
      } else {
          System.out.println("Student deleted from college");
      }
  }

  static void deleteCourse(Connection conn, Statement stmt) throws SQLException {
      System.out.println("Enter course details to delete...");
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter course ID: ");
      int courseId = sc.nextInt();

      String query = "DELETE FROM Courses WHERE course_id = " + courseId;
      int rowsAffected = stmt.executeUpdate(query);
      if (rowsAffected == 0) {
        System.out.println("No course found with ID " + courseId + ". Delete invalid");
    } else {
        System.out.println("Course successfully deleted from database");
    }
  }

  static void deleteStudent(Connection conn, Statement stmt) throws SQLException {
      System.out.println("Enter student details to delete...");
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter student ID: ");
      int studentId = sc.nextInt();

      String query = "DELETE FROM Student WHERE student_id = " + studentId;
      int rowsAffected = stmt.executeUpdate(query);

      if (rowsAffected == 0) {
        System.out.println("No student found with ID " + studentId + ". Delete invalid");
    } else {
        System.out.println("Student deleted successfully from database");
    }
  }

  static void deleteCollege(Connection conn, Statement stmt) throws SQLException {
      System.out.println("Enter college details to delete...");
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter college ID: ");
      int collegeId = sc.nextInt();

      String query = "DELETE FROM College WHERE college_id = " + collegeId;
      int rowsAffected = stmt.executeUpdate(query);

      if (rowsAffected == 0) {
        System.out.println("No college found with ID " + collegeId + ". Delete invalid");
    } else {
        System.out.println("College successfully deleted from database");
    }
  }

  static void updateCollegeFee(Connection conn, Statement stmt) throws SQLException {
      System.out.println("Enter college details to update fees...");
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter college ID: ");
      int collegeId = sc.nextInt();
      System.out.print("Enter new fees: ");
      int newFees = sc.nextInt();

      String query = "UPDATE College SET college_fees = " + newFees + " WHERE college_id = " + collegeId;
      int rowsAffected = stmt.executeUpdate(query);

      if (rowsAffected == 0) {
        System.out.println("No college found with ID " + collegeId + ". Update invalid");
    } else {
        System.out.println("College fee updated");
    }
  }

  static void printAllStudentsOfCollege(Connection conn, Statement stmt) throws SQLException {
      System.out.println("Enter college ID to print all students...");
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter college ID: ");
      int collegeId = sc.nextInt();

      String query = "SELECT * FROM Student WHERE college_id_choice = " + collegeId;
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
          System.out.println("Student ID: " + rs.getInt("student_id") + ", Name: " + rs.getString("student_name") + ", Age: " + rs.getInt("student_age"));
      }
      rs.close();
  }

  static void printAllCoursesOfCollege(Connection conn, Statement stmt) throws SQLException {
      System.out.println("Enter college ID to print all courses...");
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter college ID: ");
      int collegeId = sc.nextInt();

      String query = "SELECT c.course_id, c.course_name, c.course_duration FROM CollegeCourses cc JOIN Courses c ON cc.course_id = c.course_id WHERE cc.college_id = " + collegeId;
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
          System.out.println("Course ID: " + rs.getInt("course_id") + ", Name: " + rs.getString("course_name") + ", Duration: " + rs.getInt("course_duration"));
      }
      rs.close();
  }

  static void addNewCollegeAndUpdateStudentChoice(Connection conn, Statement stmt) throws SQLException {
   // Add new college
   //addCollege(conn, stmt);
   System.out.println("Enter college details...");
   Scanner sc = new Scanner(System.in);
   System.out.print("Enter college ID: ");
   int collegeId = sc.nextInt();
   System.out.print("Enter college name: ");
   String collegeName = sc.next();
   System.out.print("Enter college fees: ");
   int collegeFees = sc.nextInt();

   String query = "INSERT INTO College VALUES (" + collegeId + ", '" + collegeName + "', " + collegeFees + ")";
   stmt.executeUpdate(query);


   // Update a student's college choice to the newly added college
   System.out.print("Enter the ID of the student to update: ");
   int studentId = sc.nextInt();

   String updateQuery = "UPDATE Student SET college_id_choice = " + collegeId + " WHERE student_id = " + studentId;
   int rowsAffected = stmt.executeUpdate(updateQuery);
   //System.out.print(rowsAffected);


   if (rowsAffected == 0) {
       System.out.println("No student found with ID " + studentId + ". Student's college choice not updated.");
   } else {
       System.out.println("Student's college choice updated successfully!");
   }

   }

   static void addCourseToCollege(Connection conn, Statement stmt) throws SQLException {
      System.out.println("Enter course details to add to a college...");
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter college ID: ");
      int collegeId = sc.nextInt();
      System.out.print("Enter course ID: ");
      int courseId = sc.nextInt();
  
      // Check if the course already exists in the Courses table
      String checkQuery = "SELECT * FROM Courses WHERE course_id = " + courseId;
      ResultSet checkResult = stmt.executeQuery(checkQuery);
      if (!checkResult.next()) {
          System.out.println("Course with ID " + courseId + " does not exist in the Courses table. Please add the course first.");
          return;
      }
  
      // Insert the course into the CollegeCourses table
      String insertQuery = "INSERT INTO CollegeCourses VALUES (" + collegeId + ", " + courseId + ")";
      stmt.executeUpdate(insertQuery);
      System.out.println("Course added to the college's offered courses successfully!");
  }
  

}
// end class

// Note : By default autocommit is on. you can set to false using
// con.setAutoCommit(false)
