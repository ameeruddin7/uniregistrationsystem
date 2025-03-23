//230190839
//ameeruddin arai


package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Department;
import za.ac.cput.factory.DepartmentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentRepositoryTest {
    private static DepartmentRepository repository;
    private static Department d1;
    private static Department d2;

    @BeforeAll
    public static void setUp() {
        repository = (DepartmentRepository) DepartmentRepository.getRepository();
        d1 = DepartmentFactory.createDepartment("D001", "Computer Science", "Building A");
        d2 = DepartmentFactory.createDepartment("D002", "Mathematics", "Building B");
    }

    @Test
    @Order(1)
    public void testCreateDepartment() {
        Department created = repository.create(d1);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    public void testReadDepartment() {
        repository.create(d1);
        Department read = repository.read(d1.getDepartmentId());
        assertNotNull(read);
        assertEquals(d1.getDepartmentId(), read.getDepartmentId());
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    public void testUpdateDepartment() {
        repository.create(d1);
        Department updated = new Department.Builder()
                .copy(d1)
                .setDepartmentName("Software Engineering")
                .build();
        Department result = repository.update(updated);
        assertNotNull(result);
        assertEquals("Software Engineering", result.getDepartmentName());
        System.out.println("Updated: " + result);
    }

    @Test
    @Order(4)
    public void testDeleteDepartment() {
        repository.create(d2);
        boolean deleted = repository.delete(d2.getDepartmentId());
        assertTrue(deleted);
        assertNull(repository.read(d2.getDepartmentId()));
        System.out.println("Deleted: " + d2.getDepartmentId());
    }

    @Test
    @Order(5)
    public void testGetAllDepartments() {
        repository.create(d1);
        assertFalse(repository.getAll().isEmpty());
        System.out.println("All Departments: " + repository.getAll());
    }

    @Test
    @Order(6)
    @Disabled
    public void testNotImplementedYet() {
        // To be implemented in future
    }
}