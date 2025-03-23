//230190839
//ameeruddin arai
package za.ac.cput.factory;

import za.ac.cput.domain.Department;
import za.ac.cput.domain.Course;
import java.util.List;

public class DepartmentFactory {

    public static Department createDepartment(String departmentId, String departmentName, String faculty, String headOfDepartment, List<Course> departmentCourses) {
        if (departmentId == null || departmentId.isEmpty() ||
                departmentName == null || departmentName.isEmpty() ||
                faculty == null || faculty.isEmpty() ||
                headOfDepartment == null || headOfDepartment.isEmpty()) {
            return null; // Prevent creating invalid objects
        }

        return new Department.Builder()
                .setDepartmentId(departmentId)
                .setDepartmentName(departmentName)
                .setFaculty(faculty)
                .setHeadOfDepartment(headOfDepartment)
                .setDepartmentCourses(departmentCourses)
                .build();
    }
}