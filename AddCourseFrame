package comm.coursereg.ui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import comm.coursereg.db.DBConnection;

public class AddCourseFrame extends JFrame {

    JTextField cname, duration, fees;

    public AddCourseFrame() {

        setTitle("Add Course");
        setSize(400,250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4,2,10,10));

        add(new JLabel("Course Name:"));
        cname = new JTextField();
        add(cname);

        add(new JLabel("Duration:"));
        duration = new JTextField();
        add(duration);

        add(new JLabel("Fees:"));
        fees = new JTextField();
        add(fees);

        JButton addBtn = new JButton("Add");
        add(new JLabel());
        add(addBtn);

        addBtn.addActionListener(e -> addCourse());

        setVisible(true);
        // JButton closeBtn = new JButton("Close");
        // add(closeBtn);

        // closeBtn.addActionListener(e -> dispose());

    }

    private void addCourse() {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO course(course_name,course_duration,course_fees) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cname.getText());
            ps.setString(2, duration.getText());
            ps.setDouble(3, Double.parseDouble(fees.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,"Course Added Successfully");

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
