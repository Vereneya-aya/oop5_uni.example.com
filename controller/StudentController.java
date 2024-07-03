package controller;

import java.util.List;

import model.Student;
import model.Teacher;
import model.DB.DataBase;
import service.StudentGroupService;
import service.StudentService;
import service.TeacherService;
import view.StudentView;

public class StudentController {
    private final StudentGroupService studentGroupService = new StudentGroupService();
    private final StudentView studentView = new StudentView();


    private StudentService service = new StudentService();
    

    public Student createStudent(String name, String lastName, int idgroup) {
        return service.createStudent(name, lastName, idgroup);

    }
    public void createStudentGroup(Teacher teacher, List<Student> students){
        studentGroupService.createStudentGroup(teacher, students);
        }

    public Student getStudentById(int id) {

        Student student = null;
        try {
            student = service.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    

    
}