//Saadiqah Hendricks 221095136

package za.ac.cput.repository;

import za.ac.cput.domain.Student;
import za.ac.cput.repository.IStudentRepository;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private static IStudentRepository repository = null;
    private List<Student> studentList;

    private StudentRepository() {
        studentList = new ArrayList<Student>();
    }

    public static IStudentRepository getRepository() {
        if (repository == null) {
            repository = new StudentRepository();
        }
        return repository;
    }

    @Override
    public Student create(Student student) {
        boolean success = studentList.add(student);
        if (success) {
            return student;
        }
        return null;
    }

    @Override
    public Student read(String id) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Student update(Student student) {
        String id = student.getStudentId();
        Student oldStudent = read(id);
        if (oldStudent == null)
            return null;

        boolean success = delete(id);
        if (success) {
            studentList.add(student);
            return student;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Student studentToDelete = read(id);
        if (studentToDelete == null)
            return false;
        return studentList.remove(studentToDelete);
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }
}

