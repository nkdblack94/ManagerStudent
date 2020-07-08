package main;

import student.Student;
import student.StudentManager;

import java.io.Serializable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentManager studentManager = new StudentManager();
        int choose;

        System.out.println("Student list");
        studentManager.readFile();

        do {
            System.out.println("List of student");
            System.out.println("1. Show student list");
            System.out.println("2. Add new student and Write student file");
            System.out.println("3. Edit student by id");
            System.out.println("4. Delete student by id");
            System.out.println("5. Search by student name");
            System.out.println("6. Read and print student file");
            System.out.println("0. Exit!");

            Scanner scanner = new Scanner(System.in);
            try{
                choose = scanner.nextInt();
            }catch (Exception e) {
                System.out.println("Invalid input must be a number");
                choose = -1;
            }

            switch (choose) {
                case 1:
                    studentManager.showStudentList();
                    break;
                case 2:
                    add(studentManager);
                    break;
                case 3:
                    try {
                        edit(studentManager);
                    } catch (Exception e) {
                        System.out.println("ID not found");
                    }
                    break;
                case 4:
                    try {
                        delete(studentManager);
                        System.out.println("Delete successful");
                    } catch (Exception e) {
                        System.out.println("ID not found");
                    }
                    break;
                case 5:
                    try {
                       search(studentManager);
                    } catch (Exception e) {
                        System.out.println("No name found");
                    }
                    break;
                case 6:
                    studentManager.readFile();

            }
        } while (choose != 0);
    }

    public static void edit(StudentManager studentManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter edit id");
        String id = scanner.next();
        if (studentManager.isExistID(id)){
            scanner.nextLine();
            System.out.println("Enter edit full name");
            String fullName = scanner.nextLine();
            System.out.println("Enter edit age");
            int age = scanner.nextInt();
            System.out.println("Enter edit student year");
            int studentYear = scanner.nextInt();
            System.out.println("Enter edit phone number");
            String phoneNumber = scanner.next();
            System.out.println("Enter edit address");
            String address = scanner.next();
            System.out.println("Edit successful");
            studentManager.editStudentByID(id, fullName, age, studentYear, phoneNumber, address);
            System.out.println("Edit successful");
            studentManager.writeFile();
        }
    }

    public static void add(StudentManager studentManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id");
        String id = scanner.next();
        scanner.nextLine();
        System.out.println("Enter full name");
        String fullName = scanner.nextLine();
        System.out.println("Enter age");
        int age = scanner.nextInt();
        System.out.println("Enter student year");
        int studentYear = scanner.nextInt();
        System.out.println("Enter phone number");
        String phoneNumber = scanner.next();
        scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();
        studentManager.addNewStudent(id, fullName, age, studentYear, phoneNumber, address);
        studentManager.writeFile();
    }

    public static void delete(StudentManager studentManager){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id to delete");
        String ID = scanner.next();
        studentManager.deleteStudentByID(ID);
        studentManager.writeFile();
    }

    public static void search(StudentManager studentManager){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name to search");
        String name = scanner.next();
        studentManager.searchName(name);
    }
}
