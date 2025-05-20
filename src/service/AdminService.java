package service;


import java.util.Objects;

import static db.Datacourse.*;
import static db.Datacourse.users;
import static entity.enums.Role.STUDENT;
import static entity.enums.Role.TEACHER;
import static tools.Util.*;
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
                case "8"->{EditGroup();}
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
         Datacourse.users.add(teacher);
       users.add(teacher);
        System.out.println("Teacher qoshildi");
        }
     
  
    public void EditGroup(){
        System.out.println("Enter which want to edit group id");
        String id = Strscanner.nextLine();
        for (int i = 0; i < groups.size(); i++) {
            if(Objects.equals(groups.get(i).getId(), id)) {
                System.out.println("""
                        what want to edit 
                        0 Exit
                        1 group name;
                        2 maxLessonInMonth;
                        3 teacher;
                        4 Set<User> students""");
                switch (Strscanner.nextLine()) {
                    case "0" -> {
                        return;
                    }
                    case "1" -> {
                        System.out.println("new group name");
                        String name = Strscanner.nextLine();
                        while (name.isBlank()) {
                            System.out.println("new group name");
                            String name1 = Strscanner.nextLine();
                            name = name1;
                        }
                        groups.get(i).setName(name);
                    }
                    case "2" -> {
                        System.out.println("Enter max lessons in Month");
                        String lessons = Strscanner.nextLine();
                        try {
                            int lesson1 = Integer.parseInt(lessons);
                            if (lesson1 < 0 || lesson1 < 12) {
                                System.out.println("error lessons number");
                                return;
                            } else {
                                groups.get(i).setMaxLessonInMonth(lesson1);
                                System.out.println("Sucsessfuly edited");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("please enter number");
                            return;
                        }
                    }
                    case "3" -> {
                        System.out.println("Enter new teacher");
                        String idt = Strscanner.nextLine();
                        for (int j = 0; j < users.size(); j++) {
                            if (Objects.equals(idt, users.get(j).getId()) && Objects.equals(TEACHER, users.get(j).getRole())) {
                                groups.get(i).setTeacher(users.get(j));
                                System.out.println("Sucsessfuly edited ");
                                return;
                            }
                        }
                    }
                    case "4" -> {
                        System.out.println("Enter which student id want to edit ");
                        String ids = Strscanner.nextLine();
                        for (int j = 0; j < users.size(); j++) {
                            if (Objects.equals(ids, users.get(i).getId()) && Objects.equals(users.get(i).getRole(), STUDENT)) {
                                System.out.println("""
                                        what want to edit 
                                        0 Exit 
                                        1 fullName;
                                        2 email;
                                        3 password""");
                                switch (Strscanner.nextLine()) {
                                    case "0" -> {
                                        return;
                                    }
                                    case "1" -> {
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }
                    default -> {
                        System.out.println("Invalid input");
                    }
                }
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
