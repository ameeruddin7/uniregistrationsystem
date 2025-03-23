//name: Gabriel Martin 
// surname: Kiewietz
// Student no. : 230990703

package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Registration {
    private String registrationID;
    private Student student;
    private Course course;
    private LocalDate registrationDate;

    private Registration() {}

    private Registration(Builder builder) {
        this.registrationID = builder.registrationID;
        this.student = builder.student;
        this.course = builder.course;
        this.registrationDate = builder.registrationDate;
    }

    public String getRegistrationID() { return registrationID; }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public LocalDate getRegistrationDate() { return registrationDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return Objects.equals(registrationID, that.registrationID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationID);
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registrationID='" + registrationID + '\'' +
                ", student=" + student +
                ", course=" + course +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public static class Builder {
        private String registrationID;
        private Student student;
        private Course course;
        private LocalDate registrationDate;

        public Builder setRegistrationID(String registrationID) {
            this.registrationID = registrationID;
            return this;
        }

        public Builder setStudent(Student student) {
            this.student = student;
            return this;
        }

        public Builder setCourse(Course course) {
            this.course = course;
            return this;
        }

        public Builder setRegistrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder copy(Registration registration) {
            this.registrationID = registration.registrationID;
            this.student = registration.student;
            this.course = registration.course;
            this.registrationDate = registration.registrationDate;
            return this;
        }

        public Registration build() {
            return new Registration(this);
        }
    }
}
