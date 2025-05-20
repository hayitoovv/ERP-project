package service;

import entity.enums.Role;

import java.util.Objects;
import java.util.SortedMap;

import static db.Datacourse.*;
import static tools.Util.*;

public class AuthService {
    public void authService() {
        while (true) {
            System.out.println("""
                    sigin In
                    """);
            switch (scanner.nextInt()) {
                case 1 -> {
                    siginIn();
                }
            }
        }
    }

    private void siginIn() {
        System.out.println("Enter email");
        String email = strScanner.nextLine();
        System.out.println("Enter password");
        String pass = strScanner.nextLine();
        for (int i = 0; i < users.size(); i++) {
            if (Objects.equals(users.get(i).getEmail(), email) && Objects.equals(users.get(i).getRole(), Role.ADMIN)) {
                AdminService adminService = new AdminService();
                adminService.sevice();
            }
            if (Objects.equals(users.get(i).getEmail(), email) && Objects.equals(users.get(i).getPassword(), pass) && Objects.equals(users.get(i).getRole(), Role.STUDENT)) {
                StudenService studenService = new StudenService();

            }
            if (Objects.equals(users.get(i).getEmail(), email) && Objects.equals(users.get(i).getRole(), Role.TEACHER)) {
                TeacherService teacherService = new TeacherService();
                teacherService.service();
            }
        }

    }
}
