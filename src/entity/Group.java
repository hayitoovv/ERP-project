package entity;

import java.util.List;
import java.util.Set;

public class Group {
    private String id;
    private String name;
    private Integer maxLessonInMonth;
    private User teacher;
    private Set<User> students;

}
