 
package dao;

import connectdb.ConnectDB;
import entity.KhuyenMai;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KhuyenMai_DAO {
    private ArrayList<KhuyenMai> DSKM = new ArrayList<>();

    public ArrayList<KhuyenMai> getDSKM() {
        return DSKM;
    }
    // Lấy dữ liệu từ database đưa vào bảng
    public ArrayList<KhuyenMai> layDanhSachKhuyenMai() throws SQLException{
        ConnectDB.getInstance();
		Connection con = ConnectDB.getInstance().getConnection();
		String sql = "SELECT * FROM KhuyenMai";
		Statement stmt = con.createStatement();
		//Thuc thi cau lenh SQL tra ve doi tuong ResultSet
		ResultSet rs = stmt.executeQuery(sql);
		//Duyet tren tung ket qua tra ve
		while (rs.next()) {
                    String maKM = rs.getString(1);
                    String maGG = rs.getString(2);
                    Double chietKhau = rs.getDouble(3);
                    int soLuong = rs.getInt(4);
                    Date ngayBD = rs.getDate(5);
                    Date ngayKT = rs.getDate(6);
                    String moTa = rs.getString(7);                 
                    KhuyenMai km = new KhuyenMai(maKM,maGG, chietKhau, soLuong, ngayBD, ngayKT, moTa);
                    DSKM.add(km);
                }
           return DSKM;
    } 
    // Thêm khuyến mãi vào database
    public boolean themKhuyenMai(KhuyenMai km) {
        int n = 0;
        // Kết nối Database
        ConnectDB.getInstance();
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;   
        String sql = "INSERT INTO KhuyenMai (MaKhuyenMai, MaGiamGia, ChietKhau, SoLuong, ngayBatDauKM, ngayKetThucKM, MoTa) VALUES(?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, km.getMaKhuyenMai());
            stmt.setString(2, km.getMaGiamGia());
            stmt.setDouble(3, km.getChietKhau());
            stmt.setInt(4, km.getSoLuong());
            stmt.setDate(5, new java.sql.Date(km.getNgayBatDau().getTime())); // Chuyển kiểu java.util.Date sang java.sql.Date
            stmt.setDate(6, new java.sql.Date(km.getNgayKetThuc().getTime())); // Chuyển kiểu java.util.Date sang java.sql.Date
            stmt.setString(7, km.getMoTa());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return n > 0;
    }
    // Sửa thông tin khuyến mãi
    public boolean suaThongTinKhuyenMai(KhuyenMai km) {
        int n = 0;
        // Kết nối Database
        ConnectDB.getInstance();
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "UPDATE KhuyenMai SET MaGiamGia=?, ChietKhau=?, SoLuong=?, ngayBatDauKM=?, ngayKetThucKM=?, MoTa=? WHERE MaKhuyenMai=?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, km.getMaGiamGia());
            stmt.setDouble(2, km.getChietKhau());
            stmt.setInt(3, km.getSoLuong());
            stmt.setDate(4, new java.sql.Date(km.getNgayBatDau().getTime()));
            stmt.setDate(5, new java.sql.Date(km.getNgayKetThuc().getTime()));
            stmt.setString(6, km.getMoTa());
            stmt.setString(7, km.getMaKhuyenMai());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return n > 0;
    }
    // Tìm mã khuyến mãi
    public KhuyenMai timKhuyenMaiTheoMaKM(String maKM) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        KhuyenMai km = null;

        try {
            String sql = "select * from KhuyenMai where MaKhuyenMai = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maKM);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String maKm = rs.getString("MaKhuyenMai");
                String maGg = rs.getString("MaGiamGia");
                Double chietKhau = rs.getDouble("ChietKhau");
                int soLuong = rs.getInt("SoLuong");
                Date ngayBD = rs.getDate("ngayBatDauKM");
                Date ngayKT = rs.getDate("ngayKetThucKM");
                String moTa = rs.getString("MoTa");

                km = new KhuyenMai(maKm, maGg, chietKhau, soLuong, ngayBD, ngayKT, moTa);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Print the stack trace for debugging
            }
        }

        return km;
    }
    // Tìm mã giảm giá
    public KhuyenMai timKhuyenMaiTheoMaGG(String maGG){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		KhuyenMai km = null;
		try {
			String sql = "SELECT * FROM KhuyenMai WHERE MaGiamGia=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maGG);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				String maKm = rs.getString(1);
				String maGg = rs.getString(2);
				Double chietKhau = rs.getDouble(3);
                                int soLuong = rs.getInt(4);
				Date ngayBD = rs.getDate(5);
				Date ngayKT = rs.getDate(6);
				String moTa = rs.getString(7);
				
				km = new KhuyenMai(maKm, maGg, chietKhau, soLuong, ngayBD, ngayKT, moTa);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return km;
	}
    
    public KhuyenMai timKhuyenMaiTheoChietKhau(String chietKhau){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		KhuyenMai km = null;
		try {
			String sql = "SELECT * FROM KhuyenMai WHERE ChietKhau =?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, chietKhau);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				String maKm = rs.getString(1);
				String maGg = rs.getString(2);
				Double cKhau = rs.getDouble(3);
                                int soLuong = rs.getInt(4);
				Date ngayBD = rs.getDate(5);
				Date ngayKT = rs.getDate(6);
				String moTa = rs.getString(7);
				
				km = new KhuyenMai(maKm, maGg, cKhau, soLuong, ngayBD, ngayKT, moTa);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return km;
	}
    
}
