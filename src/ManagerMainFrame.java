import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerMainFrame {
    private JPanel JP;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;

    Boolean b=true;

    //管理员主界面
    public ManagerMainFrame() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectFrame Sf = new SelectFrame();
                Sf.Visible(b);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertFrame If = new InsertFrame();
                If.Visible(b);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteFrame Df = new DeleteFrame();
                Df.Visible(b);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudentinfoFrame ADF = new AddStudentinfoFrame();
                ADF.Visible(b);
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCompanyFrame adf = new AddCompanyFrame();
                adf.Visible(b);
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddShelvesFrame asf = new AddShelvesFrame();
                asf.Visible(b);
            }
        });
    }

    public void Visible(boolean c){
        JFrame frame = new JFrame("主界面");
        frame.setContentPane(new ManagerMainFrame().JP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(c);
    }
}
