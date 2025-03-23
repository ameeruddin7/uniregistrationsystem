// Saadiqah Hendricks 221095136

package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Course;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentFactoryTest {

    private static Department department;
    private static List<Course> registeredCourses;

    private static Student s1;
    private static Student s2;
    private static Student s3;

    static {
        s1 = StudentFactory.createStudent("2023001", "Devi", "Shakur", "devi@cput.ac.za", department, registeredCourses);
        s2 = StudentFactory.createStudent("2023002", "Paxton", "Andrews", "paxton@cput.ac.za", department, registeredCourses);
        s3 = StudentFactory.createStudent("2023003", "Aria", "Montgomery", "aria@cput.ac.za", department, registeredCourses);
    }

    @Test
    @Order(1)
    public void testCreateStudent() {
        assertNotNull(s1);
        System.out.println(s1.toString());
    }

    @Test
    @Order(2)
    public void testCreateStudentWithAllAttributes() {
        assertNotNull(s2);
        System.out.println(s2.toString());
    }

    @Test
    @Order(3)
    public void testCreateStudentThatFails() {
        // Fail case: Invalid email format
        Student s4 = StudentFactory.createStudent("2023004", "Caleb", "Peters", "caleb-at-cput-ac-za", department, registeredCourses);
        assertNull(s4);
    }

    @Test
    @Order(4)
    @Disabled
    public void testNotImplementedYet() {
        // Todo: Add future test cases
    }
}
