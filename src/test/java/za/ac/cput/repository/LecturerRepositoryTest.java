//Name: Moegamat Tauriq
//  Surname: Osman
//  Student#: 230599125

package za.ac.cput.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Lecturer;
import za.ac.cput.factory.LecturerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class LecturerRepositoryTest {
    private static  Department department;
    private static List<Course> assignedCourses;

    private static ILecturerRepository repository = LecturerRepository.getRepository();
    private Lecturer lecturer = LecturerFactory.createLecturer("L001", "Tauriq", "Osman", "Osmant@cput.ac.za", department, assignedCourses);

    @Test
    void a_create() {
        Lecturer created = repository.create(lecturer);
        assertNotNull(created);
        System.out.println(created.toString());
    }

    @Test
    void b_read() {
        Lecturer read = repository.read(lecturer.getLecturerId());
        assertNotNull(read);
        System.out.println(read.toString());
    }

    @Test
    void c_update() {
        Lecturer updatedLecturer = new Lecturer.Builder().copy(lecturer).setFirstName("M.Tauriq").build();
        Lecturer updated = repository.update(updatedLecturer);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    @Disabled
    void d_delete() {
        boolean success = repository.delete(lecturer.getLecturerId());
        assertTrue(success);
        System.out.println("Successfully deleted lecturer");
    }

    @Test
    void e_getAll() {
        System.out.println(repository.getAll());
    }
}


