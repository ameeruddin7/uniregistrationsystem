package za.ac.cput.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Registration;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.RegistrationFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class RegistrationRepositoryTest {

    private static final IRegistrationRepository repository = RegistrationRepository.getRepository();

    private static final Student student = new Student("2023001", "Gabriel", "Kiewietz");
    private static final Course course = new Course("IT101", "Introduction to IT");
    private static final Registration registration = RegistrationFactory.createRegistration("REG001", student, course, LocalDate.of(2024, 3, 1));

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
        Student newStudent = new Student("2023002", "Ameer", "Arai");
        Registration updatedRegistration = new Registration.Builder()
                .copy(registration)
                .setStudent(newStudent)
                .build();

        Registration updated = repository.update(updatedRegistration);
        assertNotNull(updated);
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

