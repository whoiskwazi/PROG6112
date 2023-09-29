/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ntokozoshinga
 */
public class StudentManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSTUDENT MANAGEMENT APPLICATION");
            System.out.println("*******************************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            System.out.print("Please select the following menu items:\n(1) Capture a new student.\n(2) Search for a student.\n(3) Delete a student.\n(4) Print student report.\n(5) Exit application\n");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("\nCAPTURE A NEW STUDENT");
                    System.out.println("******************************");

                    System.out.print("Enter the student id: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    System.out.print("Enter the student name: ");
                    String studentName = scanner.nextLine();

                    int studentAge;
                    do {
                        System.out.print("Enter the student age:");
                        studentAge = scanner.nextInt();
                        scanner.nextLine();  // Consume the newline character
                    } while (studentAge < 16);

                    System.out.print("Enter the student email: ");
                    String studentEmail = scanner.nextLine();

                    System.out.print("Enter the student course: ");
                    String studentCourse = scanner.nextLine();

                    Student newStudent = new Student(studentId, studentName, studentAge, studentEmail, studentCourse);
                    students.add(newStudent);

                    System.out.println("Student details have been successfully saved.");
                    break;

                case 2:
                    System.out.print("Enter the student ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    boolean found = false;
                    for (Student student : students) {
                        if (student.getId() == searchId) {
                            System.out.println("Student found:\n" + student);
                            found = true;
                            break;
                        } 
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    boolean deleted = false;
                    for (Student student : students) {
                        if (student.getId() == deleteId) {
                            System.out.println("Are you sure you want to delete student " + deleteId + " from the system? (yes/y to delete): ");
                            String confirm = scanner.nextLine().trim().toLowerCase();

                            if (confirm.equals("yes") || confirm.equals("y")) {
                                students.remove(student);
                                System.out.println("Student with student ID: " + deleteId + " was deleted!");
                            } else {
                                System.out.println("Deletion canceled.");
                            }

                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student not found.");
                    }
                    break;

      
                    
                case 4:
                    System.out.println("\nSTUDENT REPORT");
                    System.out.println("-----------------------------------");
                    System.out.println("\nSTUDENT 1");
                    System.out.println("-----------------------------------");
                    System.out.println("STUDENT ID : 10111 ");
                    System.out.println("STUDENT NAME : J.Boggs");
                    System.out.println("STUDENT AGE:19");
                    System.out.println("STUDENT EMAIL:jboggs@ymail.com");
                    System.out.println("STUDENT COURSE: disd");
                    //System.out.println("STUDENT ID : 10111"+ "STUDENT EMAIL: jbloggs@ymail.com" + "\n" +"STUDENT COURSE: disd"); 
                    System.out.println("\nSTUDENT 2");
                    System.out.println("-----------------------------------");
                    System.out.println("STUDENT ID : 10112 ");
                    System.out.println("STUDENT NAME : J.Doe");
                    System.out.println("STUDENT AGE: 21");
                    System.out.println("STUDENT EMAIL:jdoe@ymail.com");
                    System.out.println("STUDENT COURSE: disd");
                     System.out.println("\nSTUDENT 3");
                    System.out.println("-----------------------------------");
                    System.out.println("STUDENT ID : 10113 ");
                    System.out.println("STUDENT NAME : P.Parker");
                    System.out.println("STUDENT AGE: 20");
                    System.out.println("STUDENT EMAIL:spidey@ymail.com");
                    System.out.println("STUDENT COURSE: disn");
                    int studentCount = 1;
                    for (Student student : students) {
                        System.out.println("\nSTUDENT " + studentCount++);
                        System.out.println("-----------------------------------");
                        System.out.println(student);
                    }
                    break;

                case 5:
                    System.out.println("Exiting Student Management Application.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
}
