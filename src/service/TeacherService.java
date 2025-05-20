package service;

import

import entity.enums.Role;

import java.util.Scanner;

import static db.Datacourse.*;

public class TeacherService {
    static Scanner sc = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);
    public void addStudent (String groupId){
        int count = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRole().equals(Role.STUDENT)){
                System.out.println(count + ". "+ users.get(i).getFullName());
                count++;
            }
        }
        try {
            System.out.println(" Select the student you want to add to the group: ");
            int studentIndex = sc.nextInt();

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
        }
    }
}
