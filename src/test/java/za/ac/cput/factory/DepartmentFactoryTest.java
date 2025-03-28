//230190839
//ameeruddin arai

package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Lecturer;
import za.ac.cput.domain.Student;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentFactoryTest {

    private Department department;
    private List<Course> addCourses;
    private List<Lecturer> assignLecturer;
    private List<Student> students;


    Department d1 = DepartmentFactory.createDepartment("D001", "Computer Science", addCourses, assignLecturer, students);
    Department d2 = DepartmentFactory.createDepartment("D002", "Information Technology", addCourses, assignLecturer, students);


    @Test
    @Order(1)
    public void testCreateDepartment() {
        assertNotNull(d1);
        System.out.println(d1.toString());
    }

    @Test
    @Order(2)
    public void testCreateDepartmentWithAllAttributes() {
        assertNotNull(d2);
        System.out.println(d2.toString());
    }

    @Test
    @Order(3)
    public void testCreateDepartmentThatFails() {
        Department d3 = DepartmentFactory.createDepartment(null, null, null, null, null);
        assertNull(d3);
    }

    @Test
    @Order(4)
    @Disabled
    public void testNotImplementedYet() {
        // todo
    }
}