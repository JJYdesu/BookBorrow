import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddShelvesFrame {
    private JLabel jl;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JButton b1;
    private JLabel jl1;
    private JLabel jl2;
    private JLabel jl3;
    private JPanel JP;
    private JButton b2;

    //添加书架信息窗口
    public AddShelvesFrame() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddShelvesInfo asi = new AddShelvesInfo();
                String s1,s2,s3;
                s1 = t1.getText();
                s2 = t2.getText();
                s3 = t3.getText();
                Check ch = new Check();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    JOptionPane.showMessageDialog(
                            null,
                            "信息不能为空",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if (ch.CheckShelves(s1)==0) {
                    asi.ADDShelvesinfo(s1, s2, s3);
                    JOptionPane.showMessageDialog(
                            null,
                            "添加成功",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(
                            null,
                            "该书架信息已存在，请重新输入",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShelvesSelect ss = new ShelvesSelect();
                ss.ShelvesSelect();
            }
        });
    }

    public void Visible(Boolean b) {
        JFrame frame = new JFrame("AddShelvesFrame");
        frame.setContentPane(new AddShelvesFrame().JP);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(b);
    }
}
