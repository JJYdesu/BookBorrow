import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JButton button1;
    private JTable table1;
    private JPanel JP;
    private JScrollPane jsp;
    DefaultTableModel model=new DefaultTableModel();


    public GUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookSelect md = new BookSelect();
                table1.setModel(model);
                table1.setModel(md.SelectAll());
                System.out.println("2333333");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().JP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
