import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddCompanyInfo {
    Connection con;
    Statement sql;
    public Connection getConnection()throws SQLException,java.lang.ClassNotFoundException {
        String url ="jdbc:sqlserver://localhost;database=bookborrow";
        String user = "sa";
        String password = "123456789";
        con = DriverManager.getConnection(url,user,password);
        return con;
    }

    public void AddCompanyinfo(String com_name,String phone,String address,String zipcode){
        try {
            con = getConnection();
            sql = con.createStatement();
            String insert ="insert into company(com_name,phone,address,zipcode) values ('"+com_name+"','"+phone+"','"+address+"','"+zipcode+"')";
            sql.execute(insert);
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }
}
