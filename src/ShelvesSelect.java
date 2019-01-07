import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

//管理员权限——查询书架信息
public class ShelvesSelect {
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

    public void ShelvesSelect(){
        try{
            con = getConnection();
            sql = con.createStatement();
            model.setColumnIdentifiers(new Object[]{"书架编号","所在楼层","存放类型"});
            ResultSet rs;
            String s = "Select * from shelves order by she_no ASC ";
            rs = sql.executeQuery(s);
            while(rs.next()){
                String she_no = rs.getString("she_no");
                String floor = rs.getString("floor");
                String type = rs.getString("type");
                model.addRow(new Object[]{she_no,floor,type});
            }
            JTable table = new JTable(model){
                public boolean isCellEditable(int row, int column)
                {
                    return false;
                }
            };
            JScrollPane jsp = new JScrollPane(table);
            JFrame jf = new JFrame("查询书架");
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
