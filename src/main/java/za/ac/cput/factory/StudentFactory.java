// Saadiqah Hendricks 221095136

package za.ac.cput.factory;

import za.ac.cput.domain.Course;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Student;
import java.util.List;

public class StudentFactory {

    public static Student createStudent(String studentId, String firstName, String lastName, String email, Department department, List<Course> registeredCourses) {
        // Null or empty checks
        if (studentId == null || studentId.isEmpty() ||
                firstName == null || firstName.isEmpty() ||
                lastName == null || lastName.isEmpty() ||
                email == null || email.isEmpty()) {
            return null;
        }

        // Email validation
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return null;
        }

        return new Student.Builder()
                .setStudentId(studentId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setDepartment(department) // Can be null
                .setRegisteredCourses(registeredCourses) // Can be null
                .build();
    }
}
