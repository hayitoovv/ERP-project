package entity;

import java.time.LocalDate;
import java.util.List;

public class Attendance {
    private String id;
    private LocalDate date;
    private String groupId;
    private User teacher;
    private List<StudentAttendanceDaily> attendedStudents;
    public void setId(String id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public void setAttendedStudents(List<StudentAttendanceDaily> attendedStudents) {
        this.attendedStudents = attendedStudents;
    }


}
