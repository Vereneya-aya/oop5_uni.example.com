package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Student;
import model.StudentGroup;
import model.Teacher;

public class StudentGroupService {
    private StudentGroup studentGroup;

    public void createStudentGroup(Teacher teacher, List<Student> students) {
        this.studentGroup = new StudentGroup(teacher, students);
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }
    
}
