package edu.ccrm.cli;

import edu.ccrm.domain.*;
import edu.ccrm.util.FileUtil;
import java.util.*;
import java.io.IOException;

public class MainMenu {
    private static Scanner sc = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n== Campus Course & Records Manager ==");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Add Course");
            System.out.println("4. List Courses");
            System.out.println("5. Backup Example File");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: listStudents(); break;
                case 3: addCourse(); break;
                case 4: listCourses(); break;
                case 5: tryBackup(); break;
                case 6: System.out.println("Bye!"); break;
                default: System.out.println("Invalid!");
            }
        } while (choice != 6);
    }

    private static void addStudent() {
        System.out.print("Enter id: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter regNo: ");
        String reg = sc.nextLine();

        Student s = new Student(id, name, email, reg);
        students.add(s);
        System.out.println("Student added.");
    }

    private static void listStudents() {
        for (Student s : students) {
            s.printProfile();
        }
    }

    private static void addCourse() {
        System.out.print("Enter code: ");
        String code = sc.nextLine();
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter credits: ");
        int cr = sc.nextInt(); sc.nextLine();
        System.out.print("Enter instructor: ");
        String inst = sc.nextLine();

        Course c = new Course.Builder()
                        .setCode(code)
                        .setTitle(title)
                        .setCredits(cr)
                        .setInstructor(inst)
                        .setSemester(Semester.SPRING)
                        .build();
        courses.add(c);
        System.out.println("Course added.");
    }

    private static void listCourses() {
        courses.forEach(System.out::println);
    }

    private static void tryBackup() {
        try {
            FileUtil.backupFile("sample.txt");
            System.out.println("Backup done.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}