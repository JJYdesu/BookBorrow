import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

//管理员权限——查询出版社信息
public class CompanySelect {
    Connection con;
    Statement sql;
    DefaultTableModel model=new DefaultTableModel();

    public Connection getConnection()throws SQLException,java.lang.ClassNotFoundException {
        String url ="jdbc:sqlserver://localhost;database=bookborrow";
        String user = "sa";
        String password = "123456789";
        con = DriverManager.getConnection(url,user,password);
        return con;
    }

    public void CompanySelect(){
        try{
            con = getConnection();
            sql = con.createStatement();
            model.setColumnIdentifiers(new Object[]{"出版社名","电话","地址","邮编"});
            ResultSet rs;
            String s = "Select * from company";
            rs = sql.executeQuery(s);
            while(rs.next()){
                String com_name = rs.getString("com_name");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String zipcode = rs.getString("zipcode");
                model.addRow(new Object[]{com_name,phone,address,zipcode});
            }
            JTable table = new JTable(model){
                public boolean isCellEditable(int row, int column)
                {
                    return false;
                }
            };
            JScrollPane jsp = new JScrollPane(table);
            JFrame jf = new JFrame("查询出版社");
            jf.add(jsp);
            jf.setBounds(800, 600, 800, 600);
            jf.setVisible(true);
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }
}
