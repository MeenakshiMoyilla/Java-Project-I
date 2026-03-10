package comm.coursereg.dao;

import java.sql.*;
import comm.coursereg.db.DBConnection;

public class RegistrationDAO {

    public boolean registerCourse(int studentId, int courseId) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO registration(student_id,course_id) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ps.executeUpdate();
            return true;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public java.util.List<Object[]> getCourseRegistrationSummary() {

    java.util.List<Object[]> list = new java.util.ArrayList<>();

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(
            """
            SELECT c.course_id, c.course_name,
                   COUNT(r.student_id) AS total_students
            FROM course c
            LEFT JOIN registration r
            ON c.course_id = r.course_id
            GROUP BY c.course_id, c.course_name
            """
         );
         ResultSet rs = ps.executeQuery()) {

        while(rs.next()) {
            list.add(new Object[]{
                    rs.getInt("course_id"),
                    rs.getString("course_name"),
                    rs.getInt("total_students")
            });
        }

    } catch(Exception e) {
        e.printStackTrace();
    }

    return list;
}
    public ResultSet getRegisteredCourses(int studentId) {

    try {
        Connection con = DBConnection.getConnection();

        String sql = """
                SELECT c.course_id, c.course_name,
                       c.course_duration, c.course_fees
                FROM registration r
                JOIN course c ON r.course_id = c.course_id
                WHERE r.student_id = ?
                """;

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, studentId);

        return ps.executeQuery();

    } catch(Exception e) {
        e.printStackTrace();
    }

    return null;
}

}
