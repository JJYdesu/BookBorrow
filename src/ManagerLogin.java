import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ManagerLogin {
    Connection con;
    Statement sql0;
    Statement sql1;
    private JTextField t1;
    private JPanel JP;
    private JPasswordField pf;
    private JButton b1;
    private JButton b2;
    Boolean b = true;


    public Connection getConnection() throws SQLException, java.lang.ClassNotFoundException {
        String url = "jdbc:sqlserver://localhost;database=bookborrow";
        String user = "sa";
        String password = "123456789";
        con = DriverManager.getConnection(url, user, password);
        return con;
    }


    public ManagerLogin() {
        JFrame frame = new JFrame("ManagerLogin");
        frame.add(JP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                ManagerMainFrame mf = new ManagerMainFrame();
                Check ch = new Check();
                String s1, s2;
                s1 = t1.getText();
                s2 = new String(pf.getPassword());
                if (ch.CheckUsername(s1) != 0) {
                    if (ch.CheckPassword(s2) != 0) {
                        mf.Visible(b);
                        frame.dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "密码错误",
                                "消息标题",
                                JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(
                            null,
                            "用户名不存在",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Entry();
                frame.dispose();
            }
        });
    }
}


