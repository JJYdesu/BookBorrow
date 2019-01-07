import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//管理员权限——删除书本信息
public class BookDelete {
    Connection con;
    Statement sql;

    public Connection getConnection()throws SQLException,java.lang.ClassNotFoundException {
        String url ="jdbc:sqlserver://localhost;database=bookborrow";
        String user = "sa";
        String password = "123456789";
        con = DriverManager.getConnection(url,user,password);
        return con;
    }
    //按书号删除
    public void DeleteNo(String deletebno){
        try {
            con = getConnection();
            sql = con.createStatement();
            String deletebook = "delete from book where bno = '"+deletebno+"'";
            String deletepublish = "delete from publish where bno = '"+deletebno+"'";
            String deletepreserve = "delete from preserve where bno = '"+deletebno+"'";
            sql.execute(deletebook);
            sql.execute(deletepublish);
            sql.execute(deletepreserve);
            JOptionPane.showMessageDialog(
                    null,
                    "删除成功",
                    "消息标题",
                    JOptionPane.INFORMATION_MESSAGE);
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }
}
