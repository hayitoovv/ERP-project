package service;

import entity.User;
import entity.enums.Role;

import static db.Datacourse.*;
import static tools.Util.*;

public class AuthService {
    public void service() {
        while (true) {
            System.out.println("""
                    0 exit
                    1 Sign In 
                    """);
            switch (strScanner.nextLine()) {
                case "0" -> {
                    return;
                }
                case "1" -> {
                    signIn();
                }
            }
        }
    }

    private void signIn() {
        System.out.println("enter email");
        String email = strScanner.nextLine();
        System.out.println("enter password");
        String password = strScanner.nextLine();
        for (int i = 0; i < users.size(); i++) {
            User user= users.get(i);
            if(user.getEmail().equals(email)&& user.getPassword().equals(password)){

                if(user.getRole().equals(Role.TEACHER)){
                    new TeacherService().service();
                }
                if (user.getRole().equals(Role.STUDENT)){
                    new StudenService().service();
                }

            }
        }

    }


}
