//Name: Moegamat Tauriq
//  Surname: Osman
//  Student#: 230599125


package za.ac.cput.repository;

import za.ac.cput.domain.Lecturer;
import java.util.List;

public interface ILecturerRepository extends IRepository<Lecturer, String> {

    List<Lecturer> getAll();
}