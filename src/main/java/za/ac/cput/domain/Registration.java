//name: Gabriel Martin 
// surname: Kiewietz
// Student no. : 230990703

package za.ac.cput.domain;

public class Registration {
  private String registrationId;
    private String studentId;
    private String courseId;
    private String registrationDate;

   
    private Registration(za.ac.cput.Registration.Builder builder) {
        this.registrationId = builder.registrationId;
        this.studentId = builder.studentId;
        this.courseId = builder.courseId;
        this.registrationDate = builder.registrationDate;
    }

    
    public String getRegistrationId() { return registrationId; }
    public String getStudentId() { return studentId; }
    public String getCourseId() { return courseId; }
    public String getRegistrationDate() { return registrationDate; }

    
    public static class Builder {
        private String registrationId;
        private String studentId;
        private String courseId;
        private String registrationDate;

        public za.ac.cput.Registration.Builder setRegistrationId(String registrationId) {
            this.registrationId = registrationId;
            return this;
        }

        public za.ac.cput.Registration.Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public za.ac.cput.Registration.Builder setCourseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public za.ac.cput.Registration.Builder setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public za.ac.cput.Registration build() {
            return new za.ac.cput.Registration(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        za.ac.cput.Registration that = (za.ac.cput.Registration) o;
        return Objects.equals(registrationId, that.registrationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationId);
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registrationId='" + registrationId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
