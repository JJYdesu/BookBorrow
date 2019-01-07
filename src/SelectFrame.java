import javax.swing.*;
import java.awt.event.*;

public class SelectFrame {
    private JButton b1;
    private JTextField t1;
    private JTextArea a1;
    private JPanel JP1;
    private JCheckBox c1;
    private JCheckBox c2;
    private JTable tb;
    private JScrollPane jsp;

    //查询书本信息窗口
    public SelectFrame() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookSelect bs = new BookSelect();
                if(c1.isSelected())
                    tb.setModel(bs.SelectNo(t1.getText()));
                if(c2.isSelected())
                    tb.setModel(bs.SelectName(t1.getText()));
                if (c1.isSelected()==false&&c2.isSelected()==false)
                    tb.setModel(bs.SelectAll());
            }
        });
    }
    public void Visible(boolean b) {
        JFrame frame = new JFrame("SelectFrame");
        frame.setContentPane(new SelectFrame().JP1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(b);
    }
}
