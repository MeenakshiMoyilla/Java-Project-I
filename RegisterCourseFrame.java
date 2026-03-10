package comm.coursereg.ui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import comm.coursereg.db.DBConnection;

public class RegisterCourseFrame extends JFrame {

    int studentId;
    JTextField courseId;

    public RegisterCourseFrame(int studentId) {

        this.studentId = studentId;

        setTitle("Register Course");
        setSize(300,150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,2,10,10));

        add(new JLabel("Enter Course ID:"));
        courseId = new JTextField();
        add(courseId);

        JButton registerBtn = new JButton("Register");
        add(new JLabel());
        add(registerBtn);

        registerBtn.addActionListener(e -> registerCourse());

        setVisible(true);
//         JButton closeBtn = new JButton("Close");
// add(closeBtn);

// closeBtn.addActionListener(e -> dispose());

    }

    private void registerCourse() {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO registration(student_id,course_id) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, Integer.parseInt(courseId.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,"Course Registered Successfully");

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
