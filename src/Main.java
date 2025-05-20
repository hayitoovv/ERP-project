import entity.Group;
import entity.User;
import entity.enums.Role;
import service.TeacherService;

import static db.Datacourse.*;

public class Main {
    public static void main(String[] args) {
        // 1. Dummy teacher yaratamiz
        User teacher = new User();
        teacher.setId("T1");
        teacher.setFullName("Mr. John");
        teacher.setRole(Role.TEACHER);
        users.add(teacher);

        // 2. Dummy studentlar yaratamiz
        User student1 = new User();
        student1.setId("S1");
        student1.setFullName("Alice");
        student1.setRole(Role.STUDENT);
        users.add(student1);

        User student2 = new User();
        student2.setId("S2");
        student2.setFullName("Bob");
        student2.setRole(Role.STUDENT);
        users.add(student2);

        // 3. Guruh yaratamiz va studentlarni qo‘shamiz
        Group group = new Group();
        group.setId("G1");
        group.setName("Java Group");
        group.getStudents().add(student1);
        group.getStudents().add(student2);
        groups.add(group);

        // 4. markAttendance() metodini chaqiramiz
        TeacherService teacherService = new TeacherService();
        teacherService.markAttendance("G1", teacher);

        // 5. Natijani tekshirish
        System.out.println("\nRecorded attendance:");
        attendances.forEach(att -> {
            System.out.println("Date: " + att.getDate());
            System.out.println("Teacher: " + att.getTeacher().getFullName());
            att.getAttendedStudents().forEach(s -> {
                System.out.println("Student: " + s.getStudentName() + ", Status: " + s.getStatus());
            });
        });
    }
}
