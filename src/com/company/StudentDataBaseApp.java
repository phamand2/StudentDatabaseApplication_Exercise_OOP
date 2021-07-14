package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDataBaseApp {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        int numOfStudents=0;
        boolean trueInput = true;


	    // Ask how many new students we want to add

        while(trueInput){
            System.out.println("Enter number of new students to enroll: ");
            Scanner in = new Scanner(System.in);

            if (in.hasNextInt()){
                numOfStudents = in.nextInt();
                trueInput = false;
            } else {
                System.out.println("Invalid number, please try again.");
            }

        }



        // Create n number of new students
        for(int n = 0; n < numOfStudents; n++){
            students.add(new Student());
            students.get(n).enroll();
            students.get(n).payTuition();
        }
        System.out.println("=================");

        students.forEach(student -> System.out.println(student + "\n"));

        System.out.println("=================");
        students.get(0).removeACourse();

    }
}
