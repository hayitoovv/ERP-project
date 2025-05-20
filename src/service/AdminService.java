package service;

import entity.User;
import entity.enums.Role;

import static db.Datacourse.users;
import static tools.Util.*;
public class AdminService {
    public void service(){
        addStudent();
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
