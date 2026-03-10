package comm.coursereg.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import comm.coursereg.dao.RegistrationDAO;

public class ViewAllRegistrationsFrame extends JFrame {

    public ViewAllRegistrationsFrame() {

        setTitle("Course Registration Summary");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTable table = new JTable();
        add(new JScrollPane(table));

        loadData(table);

        setVisible(true);
    }

    private void loadData(JTable table) {

        RegistrationDAO dao = new RegistrationDAO();
        List<Object[]> list = dao.getCourseRegistrationSummary();

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(
                new String[]{"Course ID", "Course Name", "Total Students"}
        );

        for(Object[] row : list) {
            model.addRow(row);
        }

        table.setModel(model);
    }
}
