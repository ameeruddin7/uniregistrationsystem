package za.ac.cput.repository;
import za.ac.cput.domain.registration;
import java.util.HashSet;
import java.util.Set;

public class RegistrationRepositoryimpl implements IRegistrationRepository <Registration, String> {
    private static RegistrationRepositoryimpl repository = null;
    private Set<Registration> registrationDB = null;

    private RegistrationRepositoryimpl() {
        this.registrationDB = new HashSet<>();
    }

    public static RegistrationRepositoryimpl getRepository() {
        if (repository == null) repository = new RegistrationRepositoryimpl();
        return repository;
    }

    @Override
    public Registration create(Registration registration) {
        boolean success = this.registrationDB.add(registration);
        if (!success)
            return null;
        return registration;
    }

    @Override
    public Registration read(String studentId) {
        // replaced with better approach
        for (Registration r: registrationDB) {
            if (r.getStudentId().equals(studentId)) return r;
        }
        return null;
    }

    @Override
    public Registration update(Registration registration) {
        Registration oldRegistration = read(registration.getStudentId());
        if (oldRegistration != null) {
            this.registrationDB.remove(oldRegistration);
            this.registrationDB.add(registration);
            return registration;
        }
        return null;
    }

    @Override
    public boolean delete(String studentId) {
        Registration registrationToDelete = read(studentId);
        if (registrationToDelete == null)
            return false;
        this.registrationDB.remove(registrationToDelete);
        return true;
    }

    @Override
    public Set<Registration> getAll() {
        return this.registrationDB;
    }
}
