//230190839
//ameeruddin arai

package za.ac.cput.factory;

import za.ac.cput.domain.Department;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Lecturer;
import za.ac.cput.domain.Student;
import java.util.List;

public class DepartmentFactory {

    public static Department createDepartment(String departmentId, String departmentName,
                                              List<Course> addCourses,
                                              List<Lecturer> assignLecturer,
                                              List<Student> student) {
        if (departmentId == null || departmentId.isEmpty() ||
                departmentName == null || departmentName.isEmpty()) {
            return null;
        }

        return new Department.Builder()
                .setDepartmentId(departmentId)
                .setDepartmentName(departmentName)
                .setAddCourses(addCourses)
                .setAssignLecturer(assignLecturer)
                .setStudent(student)
                .build();
    }
}