package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.Teacher;
import model.DB.DataBase;

public class TeacherService {
  
      public Teacher getById(int id) throws Exception {
        Teacher teacher = DataBase.teachersDB//список студентов
                .stream()//запускаем поток для вычислений
                // пример лямда-выражения (s -> s.getId() == id)
                .filter(s -> s.getId() == id)//вызываем метод filter фильтруя по условию (s = student(переменная))
                .findFirst()//вернуть первого найденого студента
                .orElse(null);// если не нашли вернуть null (orElse закрывет поток stream)
        if (teacher == null) {
            throw new Exception("Студент не найден");//выбрасываем проверяемое исключение, которое компилятор требует отработать
        }
        return teacher;
    }

}
