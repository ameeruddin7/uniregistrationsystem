//230190839
//ameeruddin arai

package za.ac.cput.repository;

import za.ac.cput.domain.Department;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository implements IDepartmentRepository {

    private static IDepartmentRepository repository = null;
    private List<Department> departmentList;

    private DepartmentRepository() {
        departmentList = new ArrayList<Department>();
    }

    public static IDepartmentRepository getRepository() {
        if (repository == null) {
            repository = new DepartmentRepository();
        }
        return repository;
    }

    @Override
    public Department create(Department department) {
        boolean success = departmentList.add(department);
        if (success) {
            return department;
        }
        return null;
    }

    @Override
    public Department read(String departmentId) {
        for (Department department : departmentList) {
            if (department.getDepartmentId().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }

    @Override
    public Department update(Department department) {
        String id = department.getDepartmentId();
        Department oldDepartment = read(id);
        if (oldDepartment == null)
            return null;

        boolean success = delete(id);
        if (success) {
            departmentList.add(department);
            return department;
        }
        return null;
    }

    @Override
    public boolean delete(String departmentId) {
        Department departmentToDelete = read(departmentId);
        if (departmentToDelete == null)
            return false;
        return departmentList.remove(departmentToDelete);
    }

    @Override
    public List<Department> getAll() {
        return departmentList;
    }

    @Override
    public List<Department> getall() {
        return List.of();
    }
}