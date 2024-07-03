package controller;

import model.Teacher;
import service.TeacherService;

public class TeacherController {
    private TeacherService teacherService = new TeacherService();
    public Teacher getTeacherById(int id) {
        Teacher teacher = null;
        try {
            teacher = teacherService.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return teacher;
    }
}
