import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertFrame {
    private JPanel JP;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;
    private JTextField t7;
    private JLabel jl1;
    private JLabel jl2;
    private JLabel jl3;
    private JLabel jl4;
    private JLabel jl5;
    private JLabel jl6;
    private JLabel jl7;
    private JLabel jl;
    private JButton b1;
    BookInsert bi = new BookInsert();

    //插入书本信息窗口
    public void Visible(Boolean b) {
        JFrame frame = new JFrame("InsertFrame");
        frame.setContentPane(new InsertFrame().JP);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(b);
    }

    public InsertFrame() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1,s2,s3,s4,s5,s6,s7;
                String message;
                s1 = t1.getText();
                s2 = t2.getText();
                s3 = t3.getText();
                s4 = t4.getText();
                s5 = t5.getText();
                s6 = t6.getText();
                s7 = t7.getText();
                JFrame jf = new JFrame();
                bi.BookInsert(s1, s2, s3, s4, s5, s6, s7);

            }
        });
    }
}
