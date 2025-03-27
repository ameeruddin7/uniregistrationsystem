//Donna-Lee Jordaan_230613152

package za.ac.cput.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Course;
import za.ac.cput.factory.CourseFactory;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
class CourseRepositoryTest {

    private static ICourseRepository repository = CourseRepository.getRepository();

    private Course course = CourseFactory.createCourse("ADP", "Application Development", 50 ,null , null, null);


    @Test
    void a_create() {
        Course created = repository.create(course);
        assertNotNull(created);
        System.out.println(created.toString());
    }

    @Test
    void b_read() {
        Course read = repository.read(course.getCourseId());
        assertNotNull(read);
        System.out.println(read.toString());
    }

    @Test
    void c_update() {
        Course newCourse = new Course.Builder().copy(course).setCourseName("Updated Application Development").build();
        Course updated = repository.update(newCourse);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    @Disabled
    void d_delete() {
        assertTrue(repository.delete(course.getCourseId()));
        System.out.println("Successfully deleted course");
    }

    @Test
    void getAll() {
        System.out.println(repository.getAll());
    }
}

