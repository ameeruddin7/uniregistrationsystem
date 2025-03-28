//Donna-Lee Jordaan_230613152

package za.ac.cput.repository;

import za.ac.cput.domain.Course;
import java.util.List;

public interface ICourseRepository extends IRepository<Course, String> {
    List<Course> getAll();
}