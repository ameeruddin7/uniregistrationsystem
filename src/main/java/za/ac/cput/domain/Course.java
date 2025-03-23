//Donna-Lee Jordaan_230613152

package za.ac.cput.domain;

import java.util.List;

public class Course {

    private String courseId;
    private String courseName;
    private int credits;
    private Lecturer lecturer;
    private Department department;
    private List<Student> enrolledStudents;


    public Course() {
    }

    private Course(Builder builder) {
        this.courseId = builder.courseId;
        this.courseName = builder.courseName;
        this.credits = builder.credits;
        this.lecturer = builder.lecturer;
        this.department = builder.department;
        this.enrolledStudents = builder.enrolledStudents;
    }


    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", lecturer=" + lecturer +
                ", department=" + department +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }

    public static class Builder {
        private String courseId;
        private String courseName;
        private int credits;
        private Lecturer lecturer;
        private Department department;
        private List<Student> enrolledStudents;

        public Builder setCourseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder setCourseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public Builder setCredits(int credits) {
            this.credits = credits;
            return this;
        }

        public Builder setLecturer(Lecturer lecturer) {
            this.lecturer = lecturer;
            return this;
        }

        public Builder setDepartment(Department department) {
            this.department = department;
            return this;
        }

        public Builder setEnrolledStudents(List<Student> enrolledStudents) {
            this.enrolledStudents = enrolledStudents;
            return this;
        }

        public Builder copy(Course course) {
            this.courseId = course.courseId;
            this.courseName = course.courseName;
            this.credits = course.credits;
            this.lecturer = course.lecturer;
            this.department = course.department;
            this.enrolledStudents = course.enrolledStudents;
            return this;
        }

        public Course build() {
            return new Course(this);
        }

    }
}
