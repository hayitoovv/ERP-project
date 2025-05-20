package service;

import entity.enums.Role;

import java.util.Objects;

import static tools.Util.*;
import static db.Datacourse.*;

public class AdminService {
    public void service() {
        editStudent();
    }

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
