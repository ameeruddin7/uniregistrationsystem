//Name: Moegamat Tauriq
//  Surname: Osman
//  Student#: 230599125


package za.ac.cput.domain;

import java.util.List;



public class Lecturer {
    private String lecturerId;
    private String firstName;
    private String lastName;
    private String email;
    private Department department;
    private List<Course> assignedCourses;

    private Lecturer() {
    }

    private Lecturer(Builder builder) {
        this.lecturerId = builder.lecturerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.department = builder.department;
        this.assignedCourses = builder.assignedCourses;

    }
    public String getLecturerId() {
        return lecturerId;
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
    public List<Course> getAssignedCourses() {
        return assignedCourses;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturerId='" + lecturerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                ", assignedCourses=" + assignedCourses +
                '}';
    }

    public static class Builder {
        private String lecturerId;
        private String firstName;
        private String lastName;
        private String email;
        private Department department;
        private List<Course> assignedCourses;

        public Builder setLecturerId(String lecturerId) {
            this.lecturerId = lecturerId;
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
        public Builder setAssignedCourses(List<Course> assignedCourses) {
            this.assignedCourses = assignedCourses;
            return this;
        }

        public Builder copy(Lecturer lecturer) {
            this.lecturerId = lecturer.lecturerId;
            this.firstName = lecturer.firstName;
            this.lastName = lecturer.lastName;
            this.email = lecturer.email;
            this.department = lecturer.department;
            this.assignedCourses = lecturer.assignedCourses;
            return this;
        }

        public Lecturer build() {
            return new Lecturer(this);
        }
    }


}
