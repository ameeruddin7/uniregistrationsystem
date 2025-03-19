//Name: Moegamat Tauriq
//  Surname: Osman
//  Student#: 230599125


package za.ac.cput.repository;

import za.ac.cput.domain.Lecturer;
import java.util.ArrayList;
import java.util.List;

public class LecturerRepository implements ILecturerRepository {
    private static ILecturerRepository repository = null;
    private List<Lecturer> lecturerList;

    private LecturerRepository() { lecturerList = new ArrayList<>();}

    public static ILecturerRepository getRepository() {
        if (repository == null) {
            repository = new LecturerRepository();
        }
        return repository;
    }

    @Override
    public Lecturer create(Lecturer lecturer) {
        boolean success = lecturerList.add(lecturer);
        if (success) {
            return lecturer;
        }
        return null;
    }

    @Override
    public Lecturer read(String id) {
        for (Lecturer lecturer : lecturerList) {
            if (lecturer.getLecturerId().equals(id)) {
                return lecturer;
            }
        }
        return null;
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        String id = lecturer.getLecturerId();
        Lecturer oldLecturer = read(id);
        if (oldLecturer == null) {
            return null;
        }

        boolean success = delete(id);
        if (success) {
            lecturerList.add(lecturer);
            return lecturer;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Lecturer lecturerToDelete = read(id);
        if (lecturerToDelete == null) {
            return false;
        }
        return lecturerList.remove(lecturerToDelete);
    }

    @Override
    public List<Lecturer> getAll() {
        return lecturerList;
    }

}
