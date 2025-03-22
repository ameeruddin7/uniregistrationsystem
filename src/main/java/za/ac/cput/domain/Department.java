package za.ac.cput.domain;

public class Department {

  private String departmentId;
    private String departmentName;
    private String faculty;
    private List<Student> students;
    
    private Department3() {}
    
    private Department3(Builder builder) {
        this.departmentId = builder.departmentId;
        this.departmentName = builder.departmentName;
        this.faculty = builder.faculty;
        this.students = builder.students;
    }
    
    public String getDepartmentId() {
        return departmentId;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
    
    public String getFaculty() {
        return faculty;
    }
    
    public List<Student> getStudents() {
        return students;
    }
    
    @Override
    public String toString() {
        return "Department3{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", students=" + students +
                '}';
    }
    
    public static class Builder {
        private String departmentId;
        private String departmentName;
        private String faculty;
        private List<Student> students;
        
        public Builder setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }
        
        public Builder setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }
        
        public Builder setFaculty(String faculty) {
            this.faculty = faculty;
            return this;
        }
        
        public Builder setStudents(List<Student> students) {
            this.students = students;
            return this;
        }
        
        public Builder copy(Department3 department) {
            this.departmentId = department.departmentId;
            this.departmentName = department.departmentName;
            this.faculty = department.faculty;
            this.students = department.students;
            return this;
        }
        
        public Department3 build() {
            return new Department3(this);
        }
    }
}


}
