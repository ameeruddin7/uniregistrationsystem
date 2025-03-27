package za.ac.cput.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Registration;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.RegistrationFactory;
import za.ac.cput.factory.StudentFactory;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class RegistrationRepositoryTest {
    private static List<Course> Courses;

    private static Department department;
    private static List<Course> registeredcoursesCourses;


    private static final IRegistrationRepository repository = RegistrationRepository.getRepository();


    private Student student = StudentFactory.createStudent("2023001", "arai", "montgomery", "arai@cput.ac.za", department, registeredcoursesCourses);
    private Registration registration = RegistrationFactory.createRegistration("REG001", student, new Course("it101","Introductiontoit") , LocalDate.of(2024, 3, 1));

    @Test
    void a_create() {
        Registration created = repository.create(registration);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Registration read = repository.read(registration.getRegistrationID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        repository.create(registration); // Ensure registration exists first

        Student student = StudentFactory.createStudent("2023001", "Aria", "Montgomary", "aria@cput.ac.za", department, registeredcoursesCourses);
        Registration updatedRegistration = new Registration.Builder().copy(registration).setStudent(student).build();

        Registration updated = repository.update(updatedRegistration);
        assertNotNull(updated);
        assertEquals(student.getStudentId(), updated.getStudent().getStudentId());
        System.out.println("Updated: " + updated);
    }


    @Test
    @Disabled
    void d_delete() {
        assertTrue(repository.delete(registration.getRegistrationID()));
        System.out.println("Successfully deleted registration");
    }

    @Test
    void e_getAll() {
        System.out.println("All registrations: " + repository.getAll());
    }
}