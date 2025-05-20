import entity.Group;
import entity.User;
import entity.enums.Role;
import service.AuthService;
import service.TeacherService;

import static db.Datacourse.*;

public class Main {
    public static void main(String[] args) {
        new AuthService().service();
    }
}
