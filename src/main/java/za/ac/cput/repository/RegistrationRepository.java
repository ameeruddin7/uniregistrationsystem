//name: Gabriel Martin
// surname: Kiewietz
// student no. : 230990703

package za.ac.cput.repository;

import za.ac.cput.domain.Registration;
import java.util.ArrayList;
import java.util.List;

public class RegistrationRepository implements IRegistrationRepository {

    private static IRegistrationRepository repository = null;
    private List<Registration> registrationList;

    private RegistrationRepository() {
        registrationList = new ArrayList<>();
    }

    public static IRegistrationRepository getRepository() {
        if (repository == null) {
            repository = new RegistrationRepository();
        }
        return repository;
    }

    @Override
    public Registration create(Registration registration) {
        boolean success = registrationList.add(registration);
        return success ? registration : null;
    }

    @Override
    public Registration read(String id) {
        for (Registration r : registrationList) {
            if (r.getRegistrationID().equals(id)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public Registration update(Registration registration) {
        Registration oldRegistration = read(registration.getRegistrationID());
        if (oldRegistration == null)
            return null;

        boolean success = delete(oldRegistration.getRegistrationID());
        if (success) {
            registrationList.add(registration);
            return registration;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Registration registrationToDelete = read(id);
        return registrationToDelete != null && registrationList.remove(registrationToDelete);
    }

    @Override
    public List<Registration> getAll() {
        return registrationList;
    }
}

