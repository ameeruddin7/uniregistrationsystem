//Name: Moegamat Tauriq
//  Surname: Osman
//  Student#: 230599125

package za.ac.cput.factory;

import za.ac.cput.domain.Lecturer;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Course;
import java.util.List;

public class  LecturerFactory {
    public static Lecturer createLecturer(String lecturerId, String firstName, String lastName, String email, Department department,
                                          List<Course> assignedCourses) {
        if (lecturerId == null || lecturerId.isEmpty() || firstName == null || firstName.isEmpty() ||
                lastName == null || lastName.isEmpty() || email == null || email.isEmpty() ||
                department == null || assignedCourses == null || assignedCourses.isEmpty()) {
            return null;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return null;
        }

        return new Lecturer.Builder()
                .setLecturerId(lecturerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setDepartment(department)
                .setAssignedCourses(assignedCourses)
                .build();
    }
}
