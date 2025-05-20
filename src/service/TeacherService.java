package service;
import entity.Attendance;
import entity.Group;
import entity.StudentAttendanceDaily;
import entity.enums.AttendanceStatus;
import entity.enums.Role;
import tools.Util;
import static db.Datacourse.*;


import db.Datacourse;
import entity.User;
import entity.enums.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


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

    public void markAttendance(String groupId, User teacher) {
        Group group = null;
        for (Group g : groups) {
            if (g.getId().equals(groupId)) {
                group = g;
                break;
            }
        }

        if (group == null) {
            System.out.println("Guruh topilmadi!");
            return;
        }

        List<StudentAttendanceDaily> attendanceList = new ArrayList<>();

        for (User student : group.getStudents()) {
            System.out.println("Talaba: " + student.getFullName());
            System.out.println("1 -> ATTENDED");
            System.out.println("2 -> NOT ATTENDED");
            System.out.print("Tanlang: ");
            String choice = Util.scanner.nextLine();

            AttendanceStatus status = AttendanceStatus.NOT_ATTENDED;
            if (choice.equals("1")) {
                status = AttendanceStatus.ATTENDED;
            }

            StudentAttendanceDaily sad = new StudentAttendanceDaily();
            sad.setStudentId(student.getId());
            sad.setStudentName(student.getFullName());
            sad.setStatus(status);

            attendanceList.add(sad);
        }

        Attendance attendance = new Attendance();
        attendance.setId(UUID.randomUUID().toString());
        attendance.setDate(LocalDate.now());
        attendance.setGroupId(groupId);
        attendance.setTeacher(teacher);
        attendance.setAttendedStudents(attendanceList);

        attendances.add(attendance);
        System.out.println("Xurmatli ustoz davomat boldi !");
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
