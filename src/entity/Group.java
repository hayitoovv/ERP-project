package entity;

import java.util.List;
import java.util.Set;

public class Group {
    private String id;
    private String name;
    private Integer maxLessonInMonth;
    private User teacher;
    private Set<User> students;

    public Group(){}
    public Group(String id, String name, Integer maxLessonInMonth, User teacher, Set<User> students) {
        this.id = id;
        this.name = name;
        this.maxLessonInMonth = maxLessonInMonth;
        this.teacher = teacher;
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxLessonInMonth() {
        return maxLessonInMonth;
    }

    public void setMaxLessonInMonth(Integer maxLessonInMonth) {
        this.maxLessonInMonth = maxLessonInMonth;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Set<User> getStudents() {
        return students;
    }

    public void setStudents(Set<User> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", maxLessonInMonth=" + maxLessonInMonth +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}
