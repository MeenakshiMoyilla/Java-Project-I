package comm.coursereg.ui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import comm.coursereg.db.DBConnection;

public class LoginFrame extends JFrame {

    JTextField username;
    JPasswordField password;
    JComboBox<String> role;
    JButton loginBtn;

    public LoginFrame() {

        setTitle("Course Registration Login");
        setSize(400,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,2,10,10));

        add(new JLabel("Username:"));
        username = new JTextField();
        add(username);

        add(new JLabel("Password:"));
        password = new JPasswordField();
        add(password);

        add(new JLabel("Login As:"));
        role = new JComboBox<>(new String[]{"Admin","Student"});
        add(role);

        loginBtn = new JButton("Login");
        add(new JLabel());
        add(loginBtn);

        loginBtn.addActionListener(e -> login());

        setVisible(true);
        
    }

    private void login() {

        String user = username.getText();
        String pass = new String(password.getPassword());
        String selectedRole = role.getSelectedItem().toString();

        try {
            Connection con = DBConnection.getConnection();

            if(selectedRole.equals("Admin")) {

                String sql = "SELECT * FROM admin WHERE admin_name=? AND password=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, user);
                ps.setString(2, pass);

                ResultSet rs = ps.executeQuery();

                if(rs.next()) {
                    JOptionPane.showMessageDialog(this,"Admin Login Successful");
                    dispose();
                    new AdminDashboard();
                } else {
                    JOptionPane.showMessageDialog(this,"Invalid Admin Login");
                }

            } else {

                String sql = "SELECT * FROM student WHERE student_name=? AND password=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, user);
                ps.setString(2, pass);

                ResultSet rs = ps.executeQuery();

                if(rs.next()) {
                    int studentId = rs.getInt("student_id");
                    JOptionPane.showMessageDialog(this,"Student Login Successful");
                    dispose();
                    new StudentDashboard(studentId);
                } else {
                    JOptionPane.showMessageDialog(this,"Invalid Student Login");
                }
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
