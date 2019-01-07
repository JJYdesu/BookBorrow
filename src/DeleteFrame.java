import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//删除书本信息窗口
public class DeleteFrame {
    private JTextField t1;
    private JButton b1;
    private JPanel JP;

    public DeleteFrame() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookDelete bd =new BookDelete();
                String s = t1.getText();
                bd.DeleteNo(s);
            }
        });
    }

    public  void Visible(Boolean b) {
        JFrame frame = new JFrame("DeleteFrame");
        frame.setContentPane(new DeleteFrame().JP);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(b);
    }

}
