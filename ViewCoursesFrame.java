package comm.coursereg.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import comm.coursereg.db.DBConnection;

public class ViewCoursesFrame extends JFrame {

    public ViewCoursesFrame() {

        setTitle("View Courses");
        setSize(600,400);
        setLocationRelativeTo(null);

        JTable table = new JTable();
        add(new JScrollPane(table));

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM course";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"ID","Name","Duration","Fees"});

            while(rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getString("course_duration"),
                        rs.getDouble("course_fees")
                });
            }

            table.setModel(model);

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        setVisible(true);
    }
}
