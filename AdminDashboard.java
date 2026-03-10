package comm.coursereg.ui;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    public AdminDashboard() {

        setTitle("Admin Dashboard");
        setSize(400,300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,1,10,10));

        JButton addStudent = new JButton("Add Student");
        JButton addCourse = new JButton("Add Course");
        JButton viewStudents = new JButton("View Students");
        JButton viewCourses = new JButton("View Courses");
        JButton viewRegistrations = new JButton("View Registrations");

        add(addStudent);
        add(addCourse);
        add(viewStudents);
        add(viewCourses);
        add(viewRegistrations);

        addStudent.addActionListener(e -> new AddStudentFrame());
        addCourse.addActionListener(e -> new AddCourseFrame());
        viewStudents.addActionListener(e -> new ViewStudentsFrame());
        viewCourses.addActionListener(e -> new ViewCoursesFrame());
        viewRegistrations.addActionListener(e ->  new ViewAllRegistrationsFrame());

        setVisible(true);
        // JButton logoutBtn = new JButton("Logout");
        // add(logoutBtn);
        // logoutBtn.addActionListener(e -> {
        // dispose();          // closes dashboard
        // new LoginFrame();   // opens login again
        // });

    }
}
