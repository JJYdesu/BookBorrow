import java.sql.*;
import java.util.Scanner;

public class test {
    public static Connection getConnection ()throws SQLException,java.lang.ClassNotFoundException{
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=bookborrow",
                "sa","123456789");
        return con;
    }

    public static void main(String[] args) {
        try{
            int m;
            String update_bno,update_bname,update_quantity;
            Scanner sc = new Scanner(System.in);
            Connection con = getConnection();
            Statement sql = con.createStatement();

            while (true) {
                System.out.println("输入要实现的操作(1查询，2插入,3删除,4借出,5,还入,0退出):");
                m = sc.nextInt();
                switch (m) {
                    case 1:
                        String select = "select * from book where bno = '00001'";
                        ResultSet result =sql.executeQuery(select);
                        System.out.println("图书编号 " + "    图书名 " + "           数量");
                        System.out.println("---------------------------------");
                        while (result.next()) {
                            String bno = result.getString("bno");
                            String bname = result.getString("bname");
                            int quantity = result.getInt("quantity");
                            System.out.println(" " + bno + "  " + bname + " " + quantity);
                        }
                        break;

                    case 2:
                        System.out.println("-----输入书本信息-----");
                        System.out.print("书号:");
                        update_bno = sc.next();
                        System.out.print("书名:");
                        update_bname = sc.next();
                        System.out.print("数量:");
                        update_quantity = sc.next();
                        String insert = "insert into book(bno,bname,quantity) values('"+update_bno+"','"+update_bname+"','"+update_quantity+"')";
                        sql.execute(insert);
                        System.out.println("插入成功!");
                        break;

                    case 3:
                        String delete_bno;
                        System.out.print("输入要删除的书号:");
                        delete_bno = sc.next();
                        String delete = "delete from book where bno = '"+delete_bno+"'";
                        sql.execute(delete);
                        System.out.println("删除成功!");
                        break;

                    case 4:
                        System.out.print("输入所借书号:");
                        String borrow_bno = sc.next();
                        String update_sub = "update book set quantity = quantity-1 where bno = '"+borrow_bno+"'";
                        sql.execute(update_sub);
                        System.out.println("借书成功!");
                        break;

                    case 5:
                        System.out.print("输入归还书号:");
                        String return_bno = sc.next();
                        String update_add = "update book set quantity = quantity+1 where bno = '"+return_bno+"'";
                        sql.execute(update_add);
                        System.out.println("还书成功!");
                        break;
                }
                if(m==0) {
                    sql.close();
                    con.close();
                    System.out.println("连接关闭，退出程序!");
                    break;
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

