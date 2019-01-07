import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//管理员权限——添加书架信息（包含书架编号，所在楼层号，存放的书记类型）
public class AddShelvesInfo {
    Connection con;
    Statement sql;
    public Connection getConnection()throws SQLException,java.lang.ClassNotFoundException {
        String url ="jdbc:sqlserver://localhost;database=bookborrow";
        String user = "sa";
        String password = "123456789";
        con = DriverManager.getConnection(url,user,password);
        return con;
    }

    public void ADDShelvesinfo(String she_no,String floor,String type){
        try {
            con = getConnection();
            sql = con.createStatement();
            String insert = "insert into shelves (she_no,floor,type) values ('"+she_no+"','"+floor+"','"+type+"')";
            sql.execute(insert);
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }
}
