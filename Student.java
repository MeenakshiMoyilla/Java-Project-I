package comm.coursereg.model;

public class Student {

    private int studentId;
    private String studentName;
    private String department;
    private String email;
    private String password;

    public Student() {}

    public Student(int studentId, String studentName,
                   String department, String email,
                   String password) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.email = email;
        this.password = password;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
