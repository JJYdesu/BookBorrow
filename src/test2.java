import javax.swing.*;
public class test2 {
    public static void main(String[] args)
    {
        ModelDemo myModel=  new ModelDemo();
        JTable table = new JTable(myModel);
        JScrollPane scrollpane = new JScrollPane(table);
        JFrame jf = new JFrame();
        //JScrollPane jsp = new JScrollPane(table);
        jf.add(table);
        jf.setBounds(0, 0, 500, 500);
        jf.setVisible(true);
    }
}
