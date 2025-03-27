//Donna-Lee Jordaan 230613152

package za.ac.cput.factory;

import za.ac.cput.domain.Course;
import za.ac.cput.domain.Lecturer;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Student;

import java.util.List;

public class CourseFactory {

    public static Course createCourse(String courseId, String courseName, int credits, Lecturer lecturer, Department department,
                                      List<Student> enrolledStudents) {
        // Validate required fields
        if (courseId == null || courseId.isEmpty() || courseName == null || courseName.isEmpty() ||
                credits <= 0 || lecturer == null || department == null || enrolledStudents == null || enrolledStudents.isEmpty()) {
            return null; // Return null if any required field is invalid
        }

        // Build and return the Course object
        return new Course.Builder()
                .setCourseId(courseId)
                .setCourseName(courseName)
                .setCredits(credits)
                .setLecturer(lecturer)
                .setDepartment(department)
                .setEnrolledStudents(enrolledStudents)
                .build();
    }
}