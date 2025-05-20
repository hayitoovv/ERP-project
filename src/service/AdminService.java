package service;

import java.util.Objects;

import static db.Datacourse.groups;
import static db.Datacourse.users;
import static entity.enums.Role.STUDENT;
import static entity.enums.Role.TEACHER;
import static tools.Util.*;

public class AdminService {
    public void service(){
        
        
    }
    public void EditGroup(){
        System.out.println("Enter which want to edit group id");
        String id = Strscanner.nextLine();
        for (int i = 0; i < groups.size(); i++) {
            if(Objects.equals(groups.get(i).getId(), id)){
                System.out.println("""
                        what want to edit 
                        0 Exit
                        1 group name;
                        2 maxLessonInMonth;
                        3 teacher;
                        4 Set<User> students""");
                switch (Strscanner.nextLine()){
                    case "0" ->{
                        return;
                    }
                    case "1" ->{
                        System.out.println("new group name");
                        String name = Strscanner.nextLine();
                        while (name.isBlank()){
                            System.out.println("new group name");
                            String name1 = Strscanner.nextLine();
                            name = name1;
                        }
                        groups.get(i).setName(name);
                    }
                    case "2" ->{
                        System.out.println("Enter max lessons in Month");
                        String lessons = Strscanner.nextLine();
                        try{
                            int lesson1 = Integer.parseInt(lessons);

                            if(lesson1 < 0 || lesson1 < 12){
                                System.out.println("error lessons number");
                                return;
                            }
                            else{
                                groups.get(i).setMaxLessonInMonth(lesson1);
                                System.out.println("Sucsessfuly edited");
                            }
                        }
                        catch (NumberFormatException e){
                            System.out.println("please enter number");
                            return;
                        }
                    }
                    case "3" ->{
                        System.out.println("Enter new teacher");
                        String idt = Strscanner.nextLine();
                        for (int j = 0; j < users.size(); j++) {
                            if(Objects.equals(idt, users.get(j).getId()) && Objects.equals(TEACHER,users.get(j).getRole())){
                                groups.get(i).setTeacher(users.get(j));
                                System.out.println("Sucsessfuly edited ");
                                return;
                            }
                        }
                    }
                    case "4" ->{
                        System.out.println("Enter which student id want to edit ");
                        String ids = Strscanner.nextLine();
                        for (int j = 0; j < users.size(); j++) {
                            if(Objects.equals(ids, users.get(i).getId()) && Objects.equals(users.get(i).getRole(),STUDENT)){
                                System.out.println("""
                                        what want to edit 
                                        0 Exit 
                                        1 fullName;
                                        2 email;
                                        3 password""");
                                switch (Strscanner.nextLine()){
                                    case "0" ->{
                                        return;
                                    }
                                    case "1" ->{
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
        }
    }
}
