import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentMainFrame {
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JPanel JP;
    private JButton b4;
    Boolean c = true ;

    //学生用户主界面
    public StudentMainFrame() {
        JFrame frame = new JFrame("StudentMainFrame");
        frame.add(JP);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentBorrow sb = new StudentBorrow();
                sb.Visible(c);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentReturn sr = new StudentReturn();
                sr.Visible(c);
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectFrame sf = new SelectFrame();
                sf.Visible(c);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Entry();
                frame.dispose();
            }
        });
    }
}
