import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class test3 {
    public static Connection getConnection ()throws SQLException,java.lang.ClassNotFoundException {
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=bookborrow",
                "sa", "123456789");
        return con;
    }


    public void test() {
        try{
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"书号","书名","数量"});
            Connection con = getConnection();
            Statement sql = con.createStatement();
            String select = "select * from book where bno = '00001' ";
            ResultSet result =sql.executeQuery(select);
            while (result.next()) {
                String bno = result.getString("bno");
                String bname = result.getString("bname");
                int quantity = result.getInt("quantity");
                model.addRow(new Object[]{bno,bname,quantity});
            }
            JTable table = new JTable(model){
                public boolean isCellEditable(int row, int column)
                {
                    return false;
                }
            };
            JScrollPane jsp = new JScrollPane(table);
            JFrame jf = new JFrame();
            jf.add(jsp);
            jf.setBounds(0, 0, 500, 500);
            //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setVisible(true);
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }


    }

    public static void main(String[] args) {
        test3 t = new test3();
        t.test();
    }
}
