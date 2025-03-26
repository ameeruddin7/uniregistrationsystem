//Saadiqah Hendricks 221095136
package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentFactoryTest {

    private static Department department;
    private static List<Course> registeredCourses;

    private static Student s1 = StudentFactory.createStudent("2023001", "Aria", "Montgomary", "aria@cput.ac.za", department, registeredCourses);
    private static Student s2 = StudentFactory.createStudent("2023002", "Hannah", "Marin", "hannah@cput.ac.za", department, registeredCourses);
    private static Student s3 = StudentFactory.createStudent("2023003", "Caleb", "Peters", "caleb@cput.ac.za", department, registeredCourses);

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
        Student s4 = StudentFactory.createStudent("2023004", "Toby", "Van Reenen", "toby-at-cput-ac-za", department, registeredCourses);
        assertNull(s4);
    }

    @Test
    @Order(4)
    @Disabled
    public void testNotImplementedYet() {
        // Todo: Add future test cases
    }
}
