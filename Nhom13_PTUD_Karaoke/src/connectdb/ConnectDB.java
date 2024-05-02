
package connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ad
 */
public class ConnectDB {

    public static Connection con = null;
    public static ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
        return instance;
    }
    //ket noi

    public void connect() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databasename=QlKara;encrypt=false";
        String user = "sa";
        String pass = "123456789";
        con = DriverManager.getConnection(url, user, pass);
        System.out.println("Ket noi thanh cong");

    }
    //dong ket noi

    public void disconnect() throws SQLException {
        if (con != null) {
            try {
                con.close();
                System.out.println("Ket noi bi dong");
            } catch (SQLException e) {
                System.out.println("Loi khi ket noi" + e.getMessage());
            }
        }
    }
    //tra ve doi tuong ket noi

    public static Connection getConnection() {
        return con;
    }

    public static void main(String[] args) {
        ConnectDB db = ConnectDB.getInstance();
        try {
            
            db.connect();
            // Các hoạt động khác với cơ sở dữ liệu có thể được thực hiện ở đây
            Connection connection = ConnectDB.getConnection();
            // Ví dụ: Thực hiện truy vấn, cập nhật cơ sở dữ liệu, v.v.
            // Sau khi hoàn thành, đóng kết nối
            //db.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
