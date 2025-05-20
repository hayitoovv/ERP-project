package service;


import db.Datacourse;
import entity.User;
import entity.enums.Role;

import java.util.Scanner;


import static db.Datacourse.users;
import static tools.Util.*;

public class AdminService {
    public void sevice(){
        while(true){
            System.out.println("""
                    0 exit
                    1 add teacher
                    2 add student
                    3 edit teacher
                    4 edit student
                    5 delete student
                    6 delete teacher
                    7 create group
                    8 edit group
                    """);
            switch (scanner.nextLine()){
                case "1"->{
                    return;
                }
                case "2"->{}
                case "3"->{
                }
                case "4"->{}
                case "5"->{}
                case "6"->{}
                case "7"->{}
                case "8"->{}
            }
        }
    }

    public void addTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ism kiriting :");
        String fullName = scanner.nextLine();
        System.out.println("Email kiriting :");
        String email = scanner.nextLine();
        System.out.println("Password kiriting:");
        String password = scanner.nextLine();
        User teacher = new User(fullName, email, password, Role.TEACHER);

        users.add(teacher);

        System.out.println("Teacher qoshildi");

    }

    private void addStudent() {
        User user=new User();
        System.out.println("Enter fullName:");
        user.setFullName(Strscanner.nextLine());
        System.out.println("Enter email:");
        user.setEmail(Strscanner.nextLine());
        System.out.println("Enter password");
        user.setPassword(Strscanner.nextLine());
        user.setRole(Role.STUDENT);
        users.add(user);
        System.out.println("Successfully added!");

    }
}
