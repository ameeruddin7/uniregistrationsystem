package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Registration;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Course;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationFactoryTest {

    private static Student student1;
    private static Student student2;
    private static Course course1;
    private static Course course2;

    private static Registration reg1;
    private static Registration reg2;
    private static Registration reg3;

    @BeforeAll
    static void setUp() {
        student1 = new Student("2023001", "Gabriel", "Kiewietz");
        student2 = new Student("2023002", "Ameer", "Arai");
        course1 = new Course("IT101", "Introduction to IT");
        course2 = new Course("CS202", "Data Structures");

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
