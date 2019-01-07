import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//程序进入窗口
public class Entry {
    private JButton b1;
    private JButton b2;
    private JPanel JP;
    Boolean b = true;

    public Entry() {
        JFrame frame = new JFrame("Entry");
        frame.add(JP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManagerLogin();
                frame.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentMainFrame();
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new Entry();
    }
}
