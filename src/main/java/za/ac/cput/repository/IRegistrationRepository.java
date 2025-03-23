//Gabriel Kiewietz
// 230990703

package za.ac.cput.repository;

import za.ac.cput.domain.Registration;
import java.util.List;

public interface IRegistrationRepository extends IRepository<Registration, String> {
    List<Registration> getAll();
}
