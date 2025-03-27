// Name: Moegamat Tauriq
// Surname: Osman
// Student#: 230599125

package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Lecturer;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LecturerFactoryTest {
    private static Department department;
    private static List<Course> assignedCourses;
    private static Lecturer  l1 = LecturerFactory.createLecturer("1001", "Tauriq", "Osman",
                                                                 "osmant@cput.ac.za", department, assignedCourses);
    private static Lecturer l2 = LecturerFactory.createLecturer("1004", "Saadiqah", "Hendricks","Hendrickss@cput.ac.za", department, assignedCourses);

    @Test
    @Order(1)
    public void testCreateLecturer() {
        assertNotNull(l1);
        System.out.println(l1.toString());
    }

    @Test
    @Order(2)
    public void testCreateLecturerWithAllAttributes() {
        assertNotNull(l2);
        System.out.println(l2.toString());
    }

    @Test
    @Order(3)
    public void testCreateLecturerThatFails() {
        Lecturer l3 = LecturerFactory.createLecturer(null, null, null, null, null, null);
        assertNull(l3);
    }

    @Test
    @Order(4)
    @Disabled
    public void testNotImplementedYet() {
        // to do
    }
}
