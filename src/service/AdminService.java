package service;

import db.Datacourse;
import entity.User;
import entity.enums.Role;

import java.util.Scanner;

public class AdminService {
    public void addTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ism kiriting :");
        String fullName = scanner.nextLine();
        System.out.println("Email kiriting :");
        String email = scanner.nextLine();
        System.out.println("Password kiriting:");
        String password = scanner.nextLine();
        User teacher = new User(fullName, email, password, Role.TEACHER);

        Datacourse.users.add(teacher);

        System.out.println("Teacher qoshildi");

    }
}