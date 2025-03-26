// Saadiqah Hendricks 221095136
package za.ac.cput.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class StudentRepositoryTest {

    private static Department department;
    private static List<Course> registeredcoursesCourses;

    private static IStudentRepository repository = StudentRepository.getRepository();

    private Student student = StudentFactory.createStudent("2023001", "Aria", "Montgomary", "aria@cput.ac.za", department, registeredcoursesCourses);

    @Test
    void a_create() {
        Student created = repository.create(student);
        assertNotNull(created);
        System.out.println(created.toString());
    }

    @Test
    void b_read() {
        Student read = repository.read(student.getStudentId());
        assertNotNull(read);
        System.out.println(read.toString());
    }

    @Test
    void c_update() {
        Student newStudent = new Student.Builder().copy(student).setFirstName("A.Montgomary").build();
        Student updated = repository.update(newStudent);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    @Disabled
    void d_delete() {
        assertTrue(repository.delete(student.getStudentId()));
        System.out.println("Successfully deleted student");
    }

    @Test
    void getAll() {
        System.out.println(repository.getAll());
    }
}
