package comm.coursereg.model;

public class Course {

    private int courseId;
    private String courseName;
    private String courseDuration;
    private double courseFees;

    public Course() {}

    public Course(int courseId, String courseName,
                  String courseDuration, double courseFees) {

        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseFees = courseFees;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public double getCourseFees() {
        return courseFees;
    }

    public void setCourseFees(double courseFees) {
        this.courseFees = courseFees;
    }
}
