//230190839
//ameeruddin arai

package za.ac.cput.domain;
import java.util.List;

public class Department {
    private String departmentId;
    private String departmentName;
    private List<Course> addCourses;
    private List<Lecturer> assignLecturer;
    private List<Student> student;

    public Department() {
    }

    private Department(Builder builder) {
        this.departmentId = builder.departmentId;
        this.departmentName = builder.departmentName;
        this.addCourses = builder.addCourses;
        this.assignLecturer = builder.assignLecturer;
        this.student = builder.student;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Course> getAddCourses() {
        return addCourses;
    }

    public List<Lecturer> getAssignLecturer() {
        return assignLecturer;
    }

    public List<Student> getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", addCourses=" + addCourses +
                ", assignLecturer=" + assignLecturer +
                ", student=" + student +
                '}';
    }

    public static class Builder {
        private String departmentId;
        private String departmentName;
        private List<Course> addCourses;
        private List<Lecturer> assignLecturer;
        private List<Student> student;

        public Builder setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Builder setAddCourses(List<Course> addCourses) {
            this.addCourses = addCourses;
            return this;
        }

        public Builder setAssignLecturer(List<Lecturer> assignLecturer) {
            this.assignLecturer = assignLecturer;
            return this;
        }

        public Builder setStudent(List<Student> student) {
            this.student = student;
            return this;
        }

        public Builder copy(Department department) {
            this.departmentId = department.departmentId;
            this.departmentName = department.departmentName;
            this.addCourses = department.addCourses;
            this.assignLecturer = department.assignLecturer;
            this.student = department.student;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}