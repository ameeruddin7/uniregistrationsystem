//230190839
//ameeruddin arai

package za.ac.cput.repository;

import za.ac.cput.domain.Department;

import java.util.List;

public interface IDepartmentRepository  extends IRepository<Department,String>{

    List<Department> getAll();

    List<Department> getall(); }