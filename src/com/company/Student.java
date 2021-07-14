package com.company;

import java.util.*;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private List<Courses> courses;
    private int tuitionBalance = 0;

    private static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor: prompt user to enter student's name and year

    public Student() {
        createName();
        checkGradeValidity();
        setStudentID();
        courses = new ArrayList<>();
    }

    private void createName (){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = in.nextLine();
        System.out.println("Enter student last name: ");
        this.lastName = in.nextLine();
    }


    private boolean checkGradeValidity () {
        boolean trueInput = true;

        System.out.println("1 - Freshman\n2 - for Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");


        while (trueInput) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt() && in.nextInt() < 5) {
                this.gradeYear = in.nextInt();
                in.nextLine();
                trueInput = false;
            } else {
                System.out.println("Invalid number, please try again.");
            }
        }

        return false;
    }


    // Generate an ID
    private void setStudentID(){
        // Grade level + ID
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll(){
        // Get inside a loop, user hits 0
        do {
            System.out.print("Enter course to enroll (Q to quit)");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equalsIgnoreCase("Q")) {
                    courses.add(new Courses(course));
                    tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break;
            }
        } while (1 != 0);
    }

    // View balance
    public void viewBalance(){
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    // Pay Tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();

        while(payment > tuitionBalance){
            System.out.println("Error: Your payment is higher than your balance of: " + tuitionBalance);
            System.out.print("Enter your payment: $");
            payment = in.nextInt();
        }
            tuitionBalance = tuitionBalance - payment;
            System.out.println("Thank you for your payment of $" + payment);
            viewBalance();
    }

    // Remove a course
    public void removeACourse(){

        boolean trueInput = true;


        System.out.println("Enter the course number to remove ");
        System.out.println(getCourses());

        while(trueInput){
            Scanner in = new Scanner(System.in);
            if(in.hasNextInt() && in.nextInt() < courses.size()){
                int input = in.nextInt();
                in.nextLine();
                courses.remove(input);
                trueInput = false;
            }  else {
                System.out.println("Please try again.");
            }
        }




        System.out.println("Remaining Courses" + getCourses());

    }


    public Map getCourses() {
        Map<Integer, Courses> map = new HashMap<>();

        for (Courses k : courses){
            map.put(courses.indexOf(k), k);
        }
        return map;
    }

    // Show status
    public String toString(){
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled:" + courses+
                "\nBalance: $" + tuitionBalance;
    }
}
