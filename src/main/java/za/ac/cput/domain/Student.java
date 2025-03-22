  //Saadiqah Hendricks 221095136

package za.ac.cput.domain;

import java.util.List;

public class Student {

    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private Department department;
    private List<Course> registeredCourses;

    private Student() {
    }

    private Student(Builder builder) {
        this.studentId = builder.studentId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.department = builder.department;
        this.registeredCourses = builder.registeredCourses;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                ", registeredCourses=" + registeredCourses +
                '}';
    }

    public static class Builder {
        private String studentId;
        private String firstName;
        private String lastName;
        private String email;
        private Department department;
        private List<Course> registeredCourses;

        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDepartment(Department department) {
            this.department = department;
            return this;
        }

        public Builder setRegisteredCourses(List<Course> registeredCourses) {
            this.registeredCourses = registeredCourses;
            return this;
        }

        public Builder copy(Student student) {
            this.studentId = student.studentId;
            this.firstName = student.firstName;
            this.lastName = student.lastName;
            this.email = student.email;
            this.department = student.department;
            this.registeredCourses = student.registeredCourses;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
