//Donna-Lee Jordaan_230613152

package za.ac.cput.repository;

import za.ac.cput.domain.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements ICourseRepository {
    private static ICourseRepository repository = null;
    private List<Course> courseList;

    private CourseRepository() { courseList = new ArrayList<>();}

    public static ICourseRepository getRepository() {
        if (repository == null) {
            repository = new za.ac.cput.repository.CourseRepository();
        }
        return repository;
    }
    @Override
    public Course create(Course course) {
        boolean success = courseList.add(course);
        if (success) {
            return course;
        }
        return null;
    }

    @Override
    public Course read(String id) {
        for (Course course : courseList) {
            if (course.getCourseId().equals(id)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public Course update(Course course) {
        String id = course.getCourseId();
        Course oldCourse = read(id);
        if (oldCourse == null) {
            return null;
        }

        boolean success = delete(id);
        if (success) {
            courseList.add(course);
            return course;
        }
        return null;
    }
    @Override
    public boolean delete(String id) {
        Course courseToDelete = read(id);
        if (courseToDelete == null) {
            return false;
        }
        return courseList.remove(courseToDelete);
    }

    @Override
    public List<Course> getAll() {
        return this.courseList;
    }
}
