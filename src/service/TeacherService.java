package service;
import entity.enums.Role;
import tools.Util;
import static db.Datacourse.*;

import db.Datacourse;
import entity.User;
import entity.enums.Role;

import java.util.Scanner;

public class TeacherService {
    public void addStudent (String groupId){
        int count = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRole().equals(Role.STUDENT)){
                System.out.println(count + ". "+ users.get(i).getFullName());
                count++;
            }
        }
        try {
            System.out.print(" Select the student you want to add to the group: ");
            int studentIndex = Util.scanner.nextInt();


            if(studentIndex > users.size() || studentIndex < 0){
                System.out.println(" Invalid command. Try again ");
                addStudent(groupId);
            }

        int indexGroup = 0;
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId().equals(groupId)){
                indexGroup = i;
            }
        }
        groups.get(indexGroup).getStudents().add(users.get(studentIndex));
        System.out.println(" Student successfully added! ");
        }catch (Exception e){
            System.out.println(" Invalid command! try again");
            addStudent(groupId);
        }
    }
    public void removeStudent (String groupId){
        int indexGroup = 0;
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId().equals(groupId)){
                indexGroup = i;
            }
        }
        for (int i = 0; i < groups.get(indexGroup).getStudents().size(); i++) {
            System.out.println(i + ". " + groups.get(indexGroup).getStudents());
        }

        try {
            System.out.println(" Who will we eliminate: ");
            int studentIndex = Util.scanner.nextInt();
            if(studentIndex > users.size() || studentIndex < 0){
                System.out.println(" Invalid command. Try again ");
                addStudent(groupId);
            }

            groups.get(indexGroup).getStudents().remove(studentIndex);
            System.out.println(" Student is removed successfully! ");
        }catch (Exception e){
            System.out.println(" Invalid command. Try again ");
            removeStudent(groupId);
        }
    }
}
