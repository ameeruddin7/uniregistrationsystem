package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Registration;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Course;
import za.ac.cput.factory.RegistrationFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

        public class RegistrationFactoryTest {

        @Test
        void createRegistration_success() {
            Student student = new Student("5555", "Dave", "Bakes");
            Course course = new Course("ITC", "Introduction to Course");
            LocalDate registrationDate = LocalDate.now();

            Registration registration = RegistrationFactory.createRegistration("007reg", student, course, registrationDate);

            assertNotNull(registration);
            assertEquals("007reg", registration.getRegistrationID());
            assertEquals(student, registration.getStudent());
            assertEquals(course, registration.getCourse());
            assertEquals(registrationDate, registration.getRegistrationDate());
        }

        @Test
        void createRegistration_fail_nullValues() {
            Registration registration = RegistrationFactory.createRegistration(null, null, null, null);
            assertNull(registration);
        }
    }

}
