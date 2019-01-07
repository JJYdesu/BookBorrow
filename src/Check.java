import java.sql.*;

public class Check {
    Connection con;
    Statement sql;
    String s;
    ResultSet rs;
    int n;
    public Connection getConnection()throws SQLException,java.lang.ClassNotFoundException {
        String url ="jdbc:sqlserver://localhost;database=bookborrow";
        String user = "sa";
        String password = "123456789";
        con = DriverManager.getConnection(url,user,password);
        return con;
    }

    //检查用户名是否存在
    public int CheckUsername(String user){
        try {
            con = getConnection();
            sql = con.createStatement();
            s = "Select count(*) from Manager where username = '"+user+"'";
            rs = sql.executeQuery(s);
            if(rs.next()){
                n = rs.getInt(1);
                return n;
            }
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        } catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
        return n;
    }

    //检查密码是否正确
    public int CheckPassword(String password){
        try {
            con = getConnection();
            sql = con.createStatement();
            s = "Select count(*) from Manager where password = '"+password+"'";
            rs = sql.executeQuery(s);
            if(rs.next()){
                n = rs.getInt(1);
                return n;
            }
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        } catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
        return n;
    }

    //检查借阅证号
    public int CheckCard (String card_no){
        try {
            con = getConnection();
            sql = con.createStatement();
            s = "Select count(*) from student where card_no = '"+card_no+"'";
            rs = sql.executeQuery(s);
            if(rs.next()){
                n = rs.getInt(1);
                return n;
            }
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        } catch (SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
        return n;
    }

    //检查书架
    public int CheckShelves (String she_no) {
        try {
            con = getConnection();
            sql = con.createStatement();
            s = "Select count(*) from shelves where she_no = '" + she_no + "'";
            rs = sql.executeQuery(s);
            if (rs.next()) {
                n = rs.getInt(1);
                return n;
            }
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return n;
    }

    //检查出版社
    public int CheckCompany (String com_name) {
        try {
            con = getConnection();
            sql = con.createStatement();
            s = "Select count(*) from company where com_name like '%"+com_name+"%'";
            rs = sql.executeQuery(s);
            if (rs.next()) {
                n = rs.getInt(1);
                return n;
            }
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return n;
    }
}


