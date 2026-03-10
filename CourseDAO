package comm.coursereg.dao;

import java.sql.*;
import java.util.*;
import comm.coursereg.db.DBConnection;
import comm.coursereg.model.Course;

public class CourseDAO {

    public boolean addCourse(Course c) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO course(course_name,course_duration,course_fees) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, c.getCourseName());
            ps.setString(2, c.getCourseDuration());
            ps.setDouble(3, c.getCourseFees());

            ps.executeUpdate();
            return true;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Course> getAllCourses() {

        List<Course> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM course";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Course c = new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getString("course_duration"),
                        rs.getDouble("course_fees")
                );

                list.add(c);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
