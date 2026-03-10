package comm.coursereg.dao;

import java.sql.*;
import java.util.*;
import comm.coursereg.db.DBConnection;
import comm.coursereg.model.Student;

public class StudentDAO {

    public boolean addStudent(Student s) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO student(student_name,department,email,password) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getStudentName());
            ps.setString(2, s.getDepartment());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getPassword());

            ps.executeUpdate();
            return true;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Student> getAllStudents() {

        List<Student> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM student";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Student s = new Student(
                        rs.getInt("student_id"),
                        rs.getString("student_name"),
                        rs.getString("department"),
                        rs.getString("email"),
                        rs.getString("password")
                );

                list.add(s);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public int login(String username, String password) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM student WHERE student_name=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return rs.getInt("student_id");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}
