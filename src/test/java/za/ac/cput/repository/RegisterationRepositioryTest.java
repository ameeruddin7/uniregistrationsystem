package za.ac.cput.repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Registration;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Course;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

    class RegisterationRespositoryTest {
        private RegistrationRepository repository;
        private Registration registration;

        @BeforeEach
        void setUp() {
            repository = (RegistrationRepository) RegistrationRepository.getRepository();

            Student student = new Student("5555", "Dave", "Bakes");
            Course course = new Course("ITC", "Introduction to Course");
            registration = new Registration.Builder()
                    .setRegistrationID("007reg")
                    .setStudent(student)
                    .setCourse(course)
                    .setRegistrationDate(LocalDate.now())
                    .build();
            repository.create(registration);
        }

        @Test
        void create_success() {
            assertNotNull(repository.read("007reg"));
        }

        @Test
        void read_success() {
            Registration readRegistration = repository.read("007reg");
            assertEquals(registration, readRegistration);
        }

        @Test
        void update_success() {
            Student newStudent = new Student("44444", "Jake", "Claps");
            Registration updatedRegistration = new Registration.Builder()
                    .copy(registration)
                    .setStudent(newStudent)
                    .build();
            repository.update(updatedRegistration);

            Registration readUpdated = repository.read("007reg");
            assertEquals(newStudent, readUpdated.getStudent());
        }

        @Test
        void delete_success() {
            assertTrue(repository.delete("007reg"));
            assertNull(repository.read("007reg"));
        }

        @Test
        void getAll_success() {
            assertFalse(repository.getAll().isEmpty());
        }
    }


