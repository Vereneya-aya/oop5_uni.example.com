package view;

import java.util.List;
import java.util.Scanner;

import controller.StudentController;
import controller.TeacherController;
import model.Student;
import model.Teacher;
import model.DB.DataBase;

public class StudentView {
    private StudentController controller = new StudentController();
    private TeacherController teacherController = new TeacherController();

    public void start(){
        DataBase.fillDB();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - создать студента");
            System.out.println("2 - найти студента по id");
            System.out.println("3 - распечатать информацию о всех студентах");
            System.out.println("4 - найти учителя по id");
            System.out.println("5 - создать учебную группу");
            System.out.println("6 - выход");
            
            switch (scanner.nextInt()) {
                case 1 -> createStudent();
                case 2 -> getStudentById();
                case 3 -> getAllStudents();
                case 4 -> getTeacherById();
                case 5 -> createStudentGroup(getTeacherById(), getAllStudents());
                case 6 -> System.exit(0);// выход из приложения
            
                default -> System.out.println("Операция не поддерживается");
            }
        }

    }
    private Student createStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String lastName = scanner.nextLine();
        System.out.println("Введите номер группы:");
        int groupId = scanner.nextInt();
        Student student = controller.createStudent(name, lastName, groupId);
        System.out.println(student);
        return student;
        
    };
    private Student getStudentById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id пользователя: ");
        int id = scanner.nextInt();
        Student student = controller.getStudentById(id);
        System.out.println(student);
        return student;
    };
    private Teacher getTeacherById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id пользователя: ");
        int id = scanner.nextInt();
        Teacher teacher = teacherController.getTeacherById(id);
        System.out.println(teacher);
        return teacher;
    };
    private List<Student> getAllStudents(){
        List<Student> students = controller.getAllStudents();
        System.out.println(students);
        return students;
    };

    private void createStudentGroup(Teacher teacher, List<Student> students){
        controller.createStudentGroup(teacher, students);
    }
}