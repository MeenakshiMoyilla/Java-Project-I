package comm.coursereg.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import comm.coursereg.db.DBConnection;

public class ViewStudentsFrame extends JFrame {

    public ViewStudentsFrame() {

        setTitle("View Students");
        setSize(600,400);
        setLocationRelativeTo(null);

        JTable table = new JTable();
        add(new JScrollPane(table));

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM student";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"ID","Name","Dept","Email","Password"});

            while(rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("student_id"),
                        rs.getString("student_name"),
                        rs.getString("department"),
                        rs.getString("email"),
                        rs.getString("password")
                });
            }

            table.setModel(model);

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        setVisible(true);
    }
}
