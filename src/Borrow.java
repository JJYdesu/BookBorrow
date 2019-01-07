import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Borrow {
    Connection con;
    Statement sql;
    public Connection getConnection() throws SQLException, java.lang.ClassNotFoundException {
        String url = "jdbc:sqlserver://localhost;database=bookborrow";
        String user = "sa";
        String password = "123456789";
        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    public void Borrow(String card_no,String bno,String begindate){
        try {
            con = getConnection();
            sql = con.createStatement();
            String s1 = "insert into borrow (bno,card_no,begindate) values('"+bno+"','"+card_no+"','"+begindate+"')";
            sql.execute(s1);
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        } catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }
}
