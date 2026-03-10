package comm.coursereg.ui;

import javax.swing.*;
import java.awt.*;

public class StudentDashboard extends JFrame {

    int studentId;

    public StudentDashboard(int studentId) {

        this.studentId = studentId;

        setTitle("Student Dashboard");
        setSize(300,150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,1));

        JButton registerBtn = new JButton("Register Course");
        add(registerBtn);

        registerBtn.addActionListener(e -> new RegisterCourseFrame(studentId));

        setVisible(true);
        JButton viewBtn = new JButton("View My Registrations");

        JButton viewCourses = new JButton("View Courses");
        add(viewCourses);
         viewCourses.addActionListener(e -> new ViewCoursesFrame());

add(registerBtn);
add(viewBtn);

viewBtn.addActionListener(e ->
        new ViewRegistrationsFrame(studentId)
);
setLayout(new GridLayout(3,1,10,10));
// JButton logoutBtn = new JButton("Logout");
// add(logoutBtn);

// logoutBtn.addActionListener(e -> {
//     dispose();
//     new LoginFrame();
// });


    }
    

}
