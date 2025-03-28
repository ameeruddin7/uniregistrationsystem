//230190839
//ameeruddin arai

package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Lecturer;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.DepartmentFactory;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DepartmentRepositoryTest {

    private static IDepartmentRepository repository = DepartmentRepository.getRepository();
    private static Department department;

    private static List<Course> addCourses;
    private static List<Lecturer> assignLecturer;
    private static List<Student> students;

    Department d1 = DepartmentFactory.createDepartment("D001", "Computer Science", addCourses, assignLecturer, students);
    Department d2 = DepartmentFactory.createDepartment("D002", "Information Technology", addCourses, assignLecturer, students);


    @Test
    void a_create() {
        // Test create method
        Department created = repository.create(d1);
        assertNotNull(created);
        System.out.println(created.toString());
    }

    @Test
    void b_read() {
        repository.create(d1);
        Department read = repository.read(d1.getDepartmentId());
        assertNotNull(read);
        assertEquals(d1.getDepartmentId(), read.getDepartmentId());
        System.out.println(read.toString());
    }

    @Test
    void c_update() {
        Department updatedDepartment = new Department.Builder().copy(d1).setDepartmentName("Software Engineering").setAddCourses(new ArrayList<>()).build();
        Department updated = repository.update(updatedDepartment);
        assertNotNull(updated);
        assertEquals("Software Engineering", updated.getDepartmentName());
        System.out.println("Successfully updated department");
    }

    @Test
    @Disabled
    void d_delete() {
        boolean success = repository.delete(d1.getDepartmentId());
        assertTrue(success);
        System.out.println("Successfully deleted department");
    }

    @Test
    void e_getAll() {
        repository.create(d1);
        repository.create(d2);
        assertFalse(repository.getAll().isEmpty());
        System.out.println(repository.getAll());
    }
}
