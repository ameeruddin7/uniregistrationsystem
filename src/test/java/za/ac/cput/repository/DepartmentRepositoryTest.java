//Ameeruddin Arai 230190839

package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Department;
import za.ac.cput.factory.DepartmentFactory;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DepartmentRepositoryTest {

    private static IDepartmentRepository repository = DepartmentRepository.getRepository();
    private static Department d1;
    private static Department d2;

    @BeforeAll
    public static void setUp() {
        // Initialize the Department objects
        d1 = DepartmentFactory.createDepartment("D001", "Computer Science", "Engineering", "Dr. Smith", new ArrayList<>());
        d2 = DepartmentFactory.createDepartment("D002", "Information Technology", "Engineering", "Dr. Adams", new ArrayList<>());
    }

    @Test
    void a_create() {
        // Test create method
        Department created = repository.create(d1);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        // Test read method
        repository.create(d1); // Ensure the department is created before reading
        Department read = repository.read(d1.getDepartmentId());
        assertNotNull(read);
        assertEquals(d1.getDepartmentId(), read.getDepartmentId());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        // Test update method
        Department updatedDepartment = new Department.Builder()
                .copy(d1)
                .setDepartmentName("Software Engineering")
                .build();
        Department updated = repository.update(updatedDepartment);
        assertNotNull(updated);
        assertEquals("Software Engineering", updated.getDepartmentName());
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void d_delete() {
        // Test delete method (currently disabled)
        boolean success = repository.delete(d1.getDepartmentId());
        assertTrue(success);
        System.out.println("Successfully deleted department");
    }

    @Test
    void e_getAll() {
        // Test getAll method
        repository.create(d1);
        assertFalse(repository.getAll().isEmpty());
        System.out.println("All Departments: " + repository.getAll());
    }
}
