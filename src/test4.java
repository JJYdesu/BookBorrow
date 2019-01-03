import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class test4 {
    public static Connection getConnection ()throws SQLException,java.lang.ClassNotFoundException {
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=bookborrow",
                "sa", "123456789");
        return con;
    }



    public static void main(String[] args) {
        try{
            JFrame jf = new JFrame();

            JButton b1;
            JButton b2;
            JButton b3;
            JButton b4;
            JButton b5;

            JPanel jp1;

            JTextField txt;
            JTable tb1;

            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"书号","书名","数量"});
            Connection con = getConnection();
            Statement sql = con.createStatement();
            String select = "select * from book";
            ResultSet result =sql.executeQuery(select);
            while (result.next()) {
                String bno = result.getString("bno");
                String bname = result.getString("bname");
                int quantity = result.getInt("quantity");
                model.addRow(new Object[]{bno,bname,quantity});



                jf = new JFrame();
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.pack();
                jf.setSize(800,600);
                jf.setLocationRelativeTo(null);
                jf.setVisible(true);
            }
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }



    }
}
