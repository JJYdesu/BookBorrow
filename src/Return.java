import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Return {
    Connection con;
    Statement sql;
    public Connection getConnection() throws SQLException, java.lang.ClassNotFoundException {
        String url = "jdbc:sqlserver://localhost;database=bookborrow";
        String user = "sa";
        String password = "123456789";
        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    public void Return(String bno,String card_no,String enddate){
        try {
            con = getConnection();
            sql = con.createStatement();
            String update = "update borrow set enddate = '"+enddate+"' where bno = '"+bno+"' and card_no = '"+card_no+"'";
            sql.execute(update);
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        } catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }
}
