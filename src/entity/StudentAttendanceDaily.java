package entity;

import entity.enums.AttendanceStatus;

public class StudentAttendanceDaily {
    private String studentId;
    private String studentName;
    private AttendanceStatus status;
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public AttendanceStatus getStatus() {
        return status;
    }
}
