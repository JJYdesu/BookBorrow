import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentReturn {
    private JTextField t1;
    private JTextField t2;
    private JPanel JP;
    private JLabel jl;
    private JLabel jl1;
    private JLabel jl2;
    private JButton b1;
    private JTextField t3;
    private JLabel jl3;

    //学生还书窗口
    public StudentReturn() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Return re = new Return();
                String s1,s2,s3;
                s1 = t1.getText();
                s2 = t2.getText();
                s3 = t3.getText();
                re.Return(s1,s2,s3);
                JOptionPane.showMessageDialog(
                        null,
                        "还书成功",
                        "消息标题",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public void Visible(Boolean b) {
        JFrame frame = new JFrame("StudentReturn");
        frame.setContentPane(new StudentReturn().JP);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(b);
    }
}
