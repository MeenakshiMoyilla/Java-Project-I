package comm.coursereg.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import comm.coursereg.dao.RegistrationDAO;

public class ViewRegistrationsFrame extends JFrame {

    JTable table;
    int studentId;

    public ViewRegistrationsFrame(int studentId) {

        this.studentId = studentId;

        setTitle("My Registered Courses");
        setSize(600,400);
        setLocationRelativeTo(null);

        table = new JTable();
        add(new JScrollPane(table));

        loadData();

        setVisible(true);
    }

    private void loadData() {

        try {

            RegistrationDAO dao = new RegistrationDAO();
            ResultSet rs = dao.getRegisteredCourses(studentId);

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(
                    new String[]{"Course ID","Course Name","Duration","Fees"}
            );

            while(rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getString("course_duration"),
                        rs.getDouble("course_fees")
                });
            }

            table.setModel(model);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
