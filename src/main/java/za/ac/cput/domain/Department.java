//Ameeruddin Arai 230190839

package za.ac.cput.domain;

import java.util.List;

public class Department {
   private String departmentId;
   private String departmentName;
   private String faculty;
   private String headOfDepartment;
   private List<Course> departmentCourses;

   public Department() {
   }

  private Department(Builder builder) {
      this.departmentId = builder.departmentId;
      this.departmentName = builder.departmentName;
      this.faculty = builder.faculty;
      this.headOfDepartment = builder.headOfDepartment;
      this.departmentCourses = builder.departmentCourses;
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

   public String getHeadOfDepartment() {
       return headOfDepartment;
  }

   public List<Course> getDepartmentCourses() {
       return departmentCourses;
   }

   @Override
   public String toString() {
       return "Department{" +
               "departmentId='" + departmentId + '\'' +
               ", departmentName='" + departmentName + '\'' +
               ", faculty='" + faculty + '\'' +
               ", headOfDepartment='" + headOfDepartment + '\'' +
               ", departmentCourses=" + departmentCourses +
                '}';
   }

   public static class Builder {
        private String departmentId;
        private String departmentName;
        private String faculty;
        private String headOfDepartment;
        private List<Course> departmentCourses;

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

       public Builder setHeadOfDepartment(String headOfDepartment) {
          this.headOfDepartment = headOfDepartment;
          return this;
      }

      public Builder setDepartmentCourses(List<Course> departmentCourses) {
          this.departmentCourses = departmentCourses;
         return this;
     }

        public Builder copy(Department department) {
           this.departmentId = department.departmentId;
           this.departmentName = department.departmentName;
           this.faculty = department.faculty;
           this.headOfDepartment = department.headOfDepartment;
           this.departmentCourses = department.departmentCourses;
          return this;
      }

       public Department build() {
           return new Department(this);
      }
   }
}