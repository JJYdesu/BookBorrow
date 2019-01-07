import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentBorrow {
    private JLabel jl;
    private JPanel JP;
    private JTextField t3;
    private JTextField t1;
    private JTextField t2;
    private JButton b1;

    //学生借书窗口
    public StudentBorrow() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1,s2,s3;
                Borrow br = new Borrow();
                s1 = t1.getText();
                s2 = t2.getText();
                s3 = t3.getText();
                br.Borrow(s1,s2,s3);
                JOptionPane.showMessageDialog(
                        null,
                        "借书成功",
                        "消息标题",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public void Visible(Boolean b){
        JFrame frame = new JFrame("StudentBorrow");
        frame.setContentPane(new StudentBorrow().JP);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(b);
    }
}
