package comm.coursereg.ui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import comm.coursereg.db.DBConnection;

public class AddStudentFrame extends JFrame {

    JTextField name, dept, email, pass;

    public AddStudentFrame() {

        setTitle("Add Student");
        setSize(400,300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,2,10,10));

        add(new JLabel("Name:"));
        name = new JTextField();
        add(name);

        add(new JLabel("Department:"));
        dept = new JTextField();
        add(dept);

        add(new JLabel("Email:"));
        email = new JTextField();
        add(email);

        add(new JLabel("Password:"));
        pass = new JTextField();
        add(pass);

        JButton addBtn = new JButton("Add");
        add(new JLabel());
        add(addBtn);

        addBtn.addActionListener(e -> addStudent());

        setVisible(true);
        // JButton closeBtn = new JButton("Close");
        // add(closeBtn);

        // closeBtn.addActionListener(e -> dispose());

    }

    private void addStudent() {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO student(student_name,department,email,password) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name.getText());
            ps.setString(2, dept.getText());
            ps.setString(3, email.getText());
            ps.setString(4, pass.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,"Student Added Successfully");

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
