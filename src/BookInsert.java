import javax.swing.*;
import java.sql.*;

public class BookInsert {
    Connection con;
    Statement sql;
    public Connection getConnection()throws SQLException,java.lang.ClassNotFoundException {
        String url ="jdbc:sqlserver://localhost;database=bookborrow";
        String user = "sa";
        String password = "123456789";
        con = DriverManager.getConnection(url,user,password);
        return con;
    }

    public void BookInsert(String s1,String s2,String s3,String s4,String s5,String s6,String s7){
        try {
            con = getConnection();
            sql = con.createStatement();
            ResultSet rs0,rs1,rs2 ;
            String insert_book = "insert into book (bno,bname,quantity) values ('"+s1+"','"+s2+"','"+s3+"')";
            String insert_publish = "insert into publish (bno,com_name,publishdate) values ('"+s1+"','"+s4+"','"+s5+"')";
            String insert_preserve = "insert into preserve (bno,she_no,savedate) values ('"+s1+"','"+s6+"','"+s7+"')";
            String sql0 ="select count(*) from book where bno = '"+s1+"'";
            int n;
            rs0 = sql.executeQuery(sql0);
            if (rs0.next()) {
                n = rs0.getInt(1);
                if (n != 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            "该书已入库，请重新添加",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    sql.execute(insert_book);
                    sql.execute(insert_preserve);
                    sql.execute(insert_publish);
                    JOptionPane.showMessageDialog(
                            null,
                            "成功入库",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }
}
