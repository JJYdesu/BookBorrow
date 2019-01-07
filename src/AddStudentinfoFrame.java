import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentinfoFrame {
    private JPanel JP;
    private JLabel jl;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;
    private JLabel jl1;
    private JLabel jl2;
    private JLabel jl3;
    private JLabel jl4;
    private JLabel jl5;
    private JLabel jl6;
    private JButton b1;

    //添加学生信息窗口
    public AddStudentinfoFrame() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1,s2,s3,s4,s5,s6;
                AddStudentInfo ad = new AddStudentInfo();
                Check ch = new Check();
                s1 = t1.getText();
                s2 = t2.getText();
                s3 = t3.getText();
                s4 = t4.getText();
                s5 = t5.getText();
                s6 = t6.getText();
                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")){
                    JOptionPane.showMessageDialog(
                            null,
                            "信息不能为空",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (ch.CheckCard(s1)==0){
                    ad.AddStudentinfo(s1,s2,s3,s4,s5,s6);
                    JOptionPane.showMessageDialog(
                            null,
                            "添加成功",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(
                            null,
                            "改学生已添加",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public void Visible(Boolean b){
        JFrame frame = new JFrame("AddStudentinfoFrame");
        frame.setContentPane(new AddStudentinfoFrame().JP);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(b);
    }

}
