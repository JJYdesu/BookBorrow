import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFrame {
    private JButton b1;
    private JTextField t1;
    private JTextArea a1;
    private JPanel JP1;
    private JCheckBox c1;
    private JCheckBox c2;


    public SelectFrame() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookSelect bs = new BookSelect();
                if(c1.isSelected())
                    bs.SelectNo(t1.getText());
                if(c2.isSelected())
                    bs.SelectName(t1.getText());
                else bs.SelectAll();
            }
        });
    }

    public void Visible(boolean b) {
        JFrame frame = new JFrame("SelectFrame");
        frame.setContentPane(new SelectFrame().JP1);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(b);
    }
}
