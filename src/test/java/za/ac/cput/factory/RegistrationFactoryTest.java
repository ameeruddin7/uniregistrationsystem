// Gabriel Kiewietz 230990703

package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Registration;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RegistrationFactoryTest {

    private static Student student1;
    private static Student student2;
    private static Course course1;
    private static Course course2;

    private static Registration reg1;
    private static Registration reg2;
    private static Registration reg3;

    @BeforeAll
    static void setUp() {
        student1 = StudentFactory.createStudent("2023001", "Aria", "Montgomary", "aria@cput.ac.za", null, null);
        student2 = StudentFactory.createStudent("2023002", "Hannah", "Marin", "hannah@cput.ac.za", null, null);
        course1 = CourseFactory.createCourse("ADP", "Application Development", 50, null, null, null);
        course2 = CourseFactory.createCourse("PRM", "Project Management", 40, null, null, null);

        reg1 = RegistrationFactory.createRegistration("REG001", student1, course1, LocalDate.of(2024, 3, 1));
        reg2 = RegistrationFactory.createRegistration("REG002", student2, course2, LocalDate.of(2024, 3, 5));
        reg3 = RegistrationFactory.createRegistration("REG003", student1, course2, LocalDate.of(2024, 3, 10));
    }

    @Test
    @Order(1)
    public void testCreateRegistration() {
        assertNotNull(reg1);
        System.out.println(reg1.toString());
    }

    @Test
    @Order(2)
    public void testCreateRegistrationWithAllAttributes() {
        assertNotNull(reg2);
        System.out.println(reg2.toString());
    }

    @Test
    @Order(3)
    public void testCreateRegistrationThatFails() {
        Registration reg4 = RegistrationFactory.createRegistration(null, null, null, null);
        assertNull(reg4);
    }

    @Test
    @Order(4)
    @Disabled
    public void testNotImplementedYet() {
        // Todo: Add future test cases
    }
}
