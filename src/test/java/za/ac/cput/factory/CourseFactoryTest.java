//Donna-Lee Jordaan 230613152

package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Course;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CourseFactoryTest {

    private static Course c1 = CourseFactory.createCourse("ADP", "Application Development", 50, null, null, null);
    private static Course c2 = CourseFactory.createCourse("PRM", "Project Management", 40, null, null, null);
    private static Course c3 = CourseFactory.createCourse("PFC", "Professional Communication", 30, null, null, null);


    @Test
    @Order(1)
    public void testCreateCourse() {
        assertNotNull(c1);
        System.out.println(c1.toString());
    }


    @Test
    @Order(2)
    public void testCreateCourseWithAllAttributes() {
        assertNotNull(c2);
        System.out.println(c2.toString());
    }


    @Test
    @Order(3)
    public void testCreateCourseThatFails() {
        // This test is expected to fail if the factory validation fails
        Course c3 = CourseFactory.createCourse("2085489", "Information Technology", 30, null, null, null);
        assertNotNull(c3); // This will fail intentionally
        System.out.println(c3.toString());
    }


    @Test
    @Order(4)
    @Disabled
    public void testNotImplementedYet() {
        //Todo
    }
}