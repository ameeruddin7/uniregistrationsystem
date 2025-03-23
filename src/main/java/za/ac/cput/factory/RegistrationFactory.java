// name: Gabriel Martin
//surname: Kiewietz
// student no.: 230990703
package za.ac.cput.factory;

public class RegistrationFactory {
  public static Registration createRegistration(String studentId, String courseId) {
        if (studentId == null || studentId.isEmpty() || courseId == null || courseId.isEmpty()) {
            return null; // Basic validation to prevent empty values
        }

        return new Registration.Builder()
                .setRegistrationId(UUID.randomUUID().toString()) 
                .setStudentId(studentId)
                .setCourseId(courseId)
                .setRegistrationDate(LocalDate.now().toString()) 
                .build();
    }
}
