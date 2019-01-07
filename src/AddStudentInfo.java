import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//管理员权限——添加学生信息（包含借阅证号，姓名，学号，院系名，专业名，班级号）
public class AddStudentInfo {
    Connection con;
    Statement sql;
    public Connection getConnection()throws SQLException,java.lang.ClassNotFoundException {
        String url ="jdbc:sqlserver://localhost;database=bookborrow";
        String user = "sa";
        String password = "123456789";
        con = DriverManager.getConnection(url,user,password);
        return con;
    }

    public void AddStudentinfo(String s1,String s2,String s3,String s4,String s5,String s6){
        try {
            con = getConnection();
            sql = con.createStatement();
            String insert = "insert into student (card_no,sname,sno,dname,spname,cno) values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
            sql.execute(insert);
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }
}
