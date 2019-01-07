import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompanyFrame {
    private JLabel jl;
    private JTextField t1;
    private JTextField t2;
    private JLabel jl1;
    private JLabel jl2;
    private JLabel jl3;
    private JButton b1;
    private JPanel JP;
    private JTextField t3;
    private JTextField t4;
    private JLabel jl4;
    private JButton b2;

    public AddCompanyFrame() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCompanyInfo adi = new AddCompanyInfo();
                String s1,s2,s3,s4;
                s1 = t1.getText();
                s2 = t2.getText();
                s3 = t3.getText();
                s4 = t4.getText();
                Check ch = new Check();
                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")){
                    JOptionPane.showMessageDialog(
                            null,
                            "信息不能为空",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if(ch.CheckCompany(s1)==0) {
                    adi.AddCompanyinfo(s1, s2, s3, s4);
                    JOptionPane.showMessageDialog(
                            null,
                            "添加成功",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(
                            null,
                            "出版社信息已存在，请重新添加",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CompanySelect cs = new CompanySelect();
                cs.CompanySelect();
            }
        });
    }

    public void Visible(Boolean b) {
        JFrame frame = new JFrame("AddCompanyFrame");
        frame.setContentPane(new AddCompanyFrame().JP);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(b);
    }
}
