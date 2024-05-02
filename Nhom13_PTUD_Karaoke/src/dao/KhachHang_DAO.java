package dao;

import connectdb.ConnectDB;
import entity.KhachHang;
import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class KhachHang_DAO {
    private ArrayList<KhachHang> DSKH = new ArrayList<>();
    private ArrayList<KhachHang> DSKHGioiTinh = new ArrayList<>();
    
    public ArrayList<KhachHang> getDSKH() {
        return DSKH;
    }

    public ArrayList<KhachHang> getDSKHGioiTinh() {
        return DSKHGioiTinh;
    }
    
    // Lấy danh sách các khách hàng từ database
    public ArrayList<KhachHang> layDanhSachKhachHang() throws SQLException{
        ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM KhachHang";
		Statement stmt = con.createStatement();
		// Thực thi câu lệnh SQL trả về đối tượng ResultSet
		ResultSet rs = stmt.executeQuery(sql);
		// Duyệt trên từng kết quả trả về
		while (rs.next()) {
                    String maKH = rs.getString(1);
                    String tenKH = rs.getString(2);
                    String gioiTinh = rs.getString(3);
                    Date ngaySinh = rs.getDate(4);
                    String soDT = rs.getString(5);
                    String soCCCD = rs.getString(6);
                    String diaChi = rs.getString(7);                 
                    KhachHang kh = new KhachHang(maKH,tenKH,gioiTinh,ngaySinh,soDT,soCCCD,diaChi);
                    DSKH.add(kh);
                }
           return DSKH;
    }
    
    // Thêm khách hàng vào database
    public boolean themKhachHang(KhachHang kh){
        int n =0;
		//Kết nối Database
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;		
		String sql ="INSERT INTO KhachHang (MaKhachHang, TenKhachHang, GioiTinh, NgaySinh, SoDT, SoCCCD, DiaChi) VALUES(?,?,?,?,?,?,?)";             
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1,kh.getMaKhachHang());
			stmt.setString(2, kh.getTenKhachHang());
			stmt.setString(3, kh.getGioiTinh());
			stmt.setDate(4, (Date) kh.getNgaySinh());
			stmt.setString(5, kh.getSoDT());
			stmt.setString(6, kh.getSoCCCD());
			stmt.setString(7, kh.getDiaChi());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
    // Tìm theo mã khách hàng
    public KhachHang timKhachHangTheoMaKH(String maKH){
		//ket noi 
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		KhachHang kh = null;
		try {
			String sql = "SELECT * FROM KhachHang WHERE MaKhachHang=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maKH);
			//thuc thi cau lenh sql tra ve doi tuong ResultSet
			ResultSet rs = stmt.executeQuery();
			//Duyet tren ket qua tra ve
			while(rs.next())
			{
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gioiTinh = rs.getString(3);
				Date ngaySinh = rs.getDate(4);
				String soDT = rs.getString(5);
				String soCCCD = rs.getString(6);
				String diaChi = rs.getString(7);
				
				kh = new KhachHang(ma, ten, gioiTinh, ngaySinh, soDT, soCCCD, diaChi);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}
    // Tìm theo tên
    public KhachHang timKhachHangTheoTenKH(String tenKH) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        KhachHang kh = null;
        try {
            String sql = "SELECT * FROM KhachHang WHERE TenKhachHang LIKE ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + tenKH + "%"); // Đặt giá trị tham số với %tenKH%

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                String gioiTinh = rs.getString(3);
                Date ngaySinh = rs.getDate(4);
                String soDT = rs.getString(5);
                String soCCCD = rs.getString(6);
                String diaChi = rs.getString(7);

                kh = new KhachHang(ma, ten, gioiTinh, ngaySinh, soDT, soCCCD, diaChi);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
        return kh;
    }
    // Tìm theo số điện thoại
    public KhachHang timKhachHangTheoSoDT(String soDT){
		//ket noi 
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		KhachHang kh = null;
		try {
			String sql = "SELECT * FROM KhachHang WHERE SoDT=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, soDT);
			//thuc thi cau lenh sql tra ve doi tuong ResultSet
			ResultSet rs = stmt.executeQuery();
			//Duyet tren ket qua tra ve
			while(rs.next())
			{
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gioiTinh = rs.getString(3);
				Date ngaySinh = rs.getDate(4);
				String soDienThoai = rs.getString(5);
				String soCCCD = rs.getString(6);
				String diaChi = rs.getString(7);
				
				kh = new KhachHang(ma, ten, gioiTinh, ngaySinh, soDienThoai, soCCCD, diaChi);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}
        // Tìm khách hàng theo số căn cước công dân
       public KhachHang timKhachHangTheoSoCCCD(String soCCCD){
		//ket noi 
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		KhachHang kh = null;
		try {
			String sql = "SELECT * FROM KhachHang WHERE SoCCCD=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, soCCCD);
			//thuc thi cau lenh sql tra ve doi tuong ResultSet
			ResultSet rs = stmt.executeQuery();
			//Duyet tren ket qua tra ve
			while(rs.next())
			{
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gioiTinh = rs.getString(3);
				Date ngaySinh = rs.getDate(4);
				String soDienThoai = rs.getString(5);
				String soCCCDan = rs.getString(6);
				String diaChi = rs.getString(7);
				
				kh = new KhachHang(ma, ten, gioiTinh, ngaySinh, soDienThoai, soCCCDan, diaChi);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}
    // Lọc giới theo giới tính
    public ArrayList<KhachHang> timKhachHangTheoGioiTinh(String gt) throws SQLException{
            ConnectDB.getInstance();
                    Connection con = ConnectDB.getConnection();
                    PreparedStatement stmt = null;
                    String sql = "SELECT * FROM KhachHang WHERE GioiTinh = ?";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, gt);
                    ResultSet rs = stmt.executeQuery();
                    //Duyet tren tung ket qua tra ve
                    while (rs.next()) {
                        String maKH = rs.getString(1);
                        String tenKH = rs.getString(2);
                        String gioiTinh = rs.getString(3);
                        Date ngaySinh = rs.getDate(4);
                        String soDT = rs.getString(5);
                        String soCCCD = rs.getString(6);
                        String diaChi = rs.getString(7);                 
                        KhachHang kh = new KhachHang(maKH,tenKH,gioiTinh,ngaySinh,soDT,soCCCD,diaChi);
                        DSKHGioiTinh.add(kh);
                    }
               return DSKHGioiTinh;
        }
    public boolean suaThongTinKhachHang(KhachHang kh){
		//Kết nối Database
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n =0;
		String sql = "UPDATE KhachHang SET TenKhachHang=?, GioiTinh=?, NgaySinh=?, soDT=?, soCCCD=?, DiaChi=? WHERE MaKhachHang=?";            
		try {
			stmt = con.prepareStatement(sql);
                        stmt.setString(1, kh.getTenKhachHang());
                        stmt.setString(2, kh.getGioiTinh());
                        stmt.setDate(3, new java.sql.Date(kh.getNgaySinh().getTime()));
                        stmt.setString(4, kh.getSoDT());
                        stmt.setString(5, kh.getSoCCCD());
                        stmt.setString(6, kh.getDiaChi());
                        stmt.setString(7, kh.getMaKhachHang());
                        n = stmt.executeUpdate();
		} catch (Exception e) {
                    e.printStackTrace();
                } 
                return n > 0;
            }
    private int getNextIDFromDatabase() {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int maxID = -1;
        try {
            String sql = "SELECT MAX(CONVERT(INT, SUBSTRING(MaKhachHang, 4, LEN(MaKhachHang) - 3))) AS MaxID FROM KhachHang";
            stmt = con.prepareStatement(sql);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    maxID = rs.getInt("MaxID");
                    maxID++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxID;
    }

    public String generateMaKhachHang() {
        int nextID = getNextIDFromDatabase();
        if (nextID != -1) {
            return String.format("KHA%03d", nextID);
        }
        return null;
    }
    
    public String timMaKhachHangTheoTenKH(String tenKH) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String maKhachHang = null;

        try {
            String sql = "SELECT MaKhachHang FROM KhachHang WHERE TenKhachHang LIKE ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + tenKH + "%"); // Set parameter value with %tenKH%

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                maKhachHang = rs.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return maKhachHang;
    }
}
