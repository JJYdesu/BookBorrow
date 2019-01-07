import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.Scanner;

public class BookSelect {
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
    //按书号查询
    public TableModel SelectNo(String selectbno){
        try {
            con = getConnection();
            sql = con.createStatement();
            model.setColumnIdentifiers(new Object[]{"书号","书名","数量","出版社","出版日期","书架编号","入库时间"});
            String select = "select * from book,publish,preserve where book.bno = publish.bno and preserve.bno = book.bno and book.bno = '"+selectbno+"'";
            ResultSet result =sql.executeQuery(select);
            while(result.next()){
                String bno = result.getString("bno");
                String bname = result.getString("bname");
                int quantity = result.getInt("quantity");
                String  com_name = result.getString("com_name");
                String publishdate = result.getString("publishdate");
                String she_no = result.getString("she_no");
                String savedate = result.getString("savedate");
                model.addRow(new Object[]{bno,bname,quantity,com_name,publishdate,she_no,savedate});
            }
            /*table = new JTable(model){
                public boolean isCellEditable(int row, int column)
                {
                    return false;
                }
            };
            jsp = new JScrollPane(table);
            jf = new JFrame("按书号查询");
            jf.add(jsp);
            jf.setBounds(800, 600, 800, 600);
            jf.setVisible(true);*/

        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());

            }
        return model;
    }
    //按书名查询
    public TableModel SelectName(String selectbname){
        try {
            con = getConnection();
            sql = con.createStatement();
            model.setColumnIdentifiers(new Object[]{"书号","书名","数量","出版社","出版日期","书架编号","入库时间"});
            String select = "select * from book,publish,preserve where book.bno = publish.bno and preserve.bno = book.bno and book.bname like '%"+selectbname+"%'";
            ResultSet result =sql.executeQuery(select);
            while(result.next()){
                String bno = result.getString("bno");
                String bname = result.getString("bname");
                int quantity = result.getInt("quantity");
                String  com_name = result.getString("com_name");
                String publishdate = result.getString("publishdate");
                String she_no = result.getString("she_no");
                String savedate = result.getString("savedate");
                model.addRow(new Object[]{bno,bname,quantity,com_name,publishdate,she_no,savedate});
            }
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
        return model;
    }
    //查询全部
    public TableModel SelectAll(){
        try {
            con = getConnection();
            sql = con.createStatement();
            model.setColumnIdentifiers(new Object[]{"书号","书名","数量","出版社","出版日期","书架编号","入库时间"});
            String select = "select * from book,publish,preserve where book.bno = publish.bno and book.bno = preserve.bno";
            ResultSet result =sql.executeQuery(select);
            while(result.next()){
                String bno = result.getString("bno");
                String bname = result.getString("bname");
                int quantity = result.getInt("quantity");
                String  com_name = result.getString("com_name");
                String publishdate = result.getString("publishdate");
                String she_no = result.getString("she_no");
                String savedate = result.getString("savedate");
                model.addRow(new Object[]{bno,bname,quantity,com_name,publishdate,she_no,savedate});
            }
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
        return model;
    }
}
