package service;

import static tools.Util.*;

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
                case "8"->{}
            }
        }
    }

    private void editTeacher() {

    }
}
