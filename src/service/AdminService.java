package service;

import entity.User;
import entity.enums.Role;

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
    }
}
