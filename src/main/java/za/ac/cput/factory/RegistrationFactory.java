// name: Gabriel Martin
//surname: Kiewietz
// student no.: 230990703

package za.ac.cput.factory;

import za.ac.cput.domain.Registration;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Course;
import za.ac.cput.util.Helper;
import java.time.LocalDate;

public class RegistrationFactory {
    public static Registration createRegistration(String registrationID, Student student, Course course, LocalDate registrationDate) {
        if (Helper.isNullOrEmpty(registrationID) || student == null || course == null || registrationDate == null)
            return null;

        return new Registration.Builder()
                .setRegistrationID(registrationID)
                .setStudent(student)
                .setCourse(course)
                .setRegistrationDate(registrationDate)
                .build();
    }
}
