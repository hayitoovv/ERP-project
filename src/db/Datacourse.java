package db;

import entity.Attendance;
import entity.Group;
import entity.StudentAttendanceDaily;
import entity.User;
import entity.enums.Role;
import service.TeacherService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class Datacourse {
   public static ArrayList<User> users= new ArrayList<>();
   public static ArrayList<Attendance> attendances= new ArrayList<>();
   public static ArrayList<Group> groups= new ArrayList<>();
   public static ArrayList<StudentAttendanceDaily> studentAttendanceDailies= new ArrayList<>();

   public static ArrayList<User> teacher= new ArrayList<>();
   //public static List<Attendance> attendances = new ArrayList<>();



    static {
        User user = new User("Admin","Admin","Admin", Role.ADMIN);
        users.add(user);
        User user1 = new User("t","t","t", Role.TEACHER);
        users.add(user1);
        User user2 = new User("s","s","s", Role.STUDENT);
        users.add(user2);

        Group group= new Group(UUID.randomUUID().toString(),"G54",8,user1,new HashSet<>());
        groups.add(group);
    }
}
