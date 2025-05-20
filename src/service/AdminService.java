package service;

import db.Datacourse.*;
import entity.User;
import entity.enums.Role;
import java.util.Scanner;

import static db.Datacourse.users;
import static tools.Util.*;

import entity.enums.Role;

import java.util.Objects;

import static tools.Util.*;
import static db.Datacourse.*;

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
        User user = new User();
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
    public void service() {
        editStudent();
    }


    private void addStudent() {
        User user=new User();
        System.out.println("Enter fullName:");
        user.setFullName(strScanner.nextLine());
        System.out.println("Enter email:");
        user.setEmail(strScanner.nextLine());
        System.out.println("Enter password");
        user.setPassword(strScanner.nextLine());
        user.setRole(Role.STUDENT);
        users.add(user);
        System.out.println("Successfully added!");


    private void editStudent() {
        for (int i = 0; i < users.size(); i++) {
            if (Objects.equals(users.get(i).getRole(), Role.STUDENT))
                System.out.println(users.get(i));
        }
        System.out.println("Enter Student id");
        String id = Strscanner.nextLine();
        for (int i = 0; i < users.size(); i++) {
            if (Objects.equals(users.get(i).getId(), id) && Objects.equals(users.get(i).getRole(), Role.STUDENT)) {
                while (true) {
                    System.out.println("""
                            0 exit
                            1 Change fullname
                            2 Change email
                            3 Chnage password
                            """);
                    switch (scanner.nextInt()) {
                        case 0 -> {
                            return;
                        }
                        case 1 -> {
                            System.out.println("Enter new name");
                            users.get(i).setFullName(Strscanner.nextLine());
                            System.out.println("name successfully changed");
                            return;
                        }
                        case 2 -> {
                            System.out.println("Enter new email");
                            users.get(i).setEmail(Strscanner.nextLine());
                            System.out.println("email successfully changed");
                            return;
                        }
                        case 3 -> {
                            System.out.println("Enter name password");
                            users.get(i).setPassword(Strscanner.nextLine());
                            System.out.println("password successfully changed");
                            return;
                        }
                    }
                }
            }
        }
    }

}
