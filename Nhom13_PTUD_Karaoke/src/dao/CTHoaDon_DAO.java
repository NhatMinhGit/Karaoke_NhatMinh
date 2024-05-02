
package dao;

import connectdb.ConnectDB;
import entity.CT_HoaDon;
import entity.HoaDon;
import entity.Phong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CTHoaDon_DAO {
    private HoaDon_DAO hoaDon_dao = new HoaDon_DAO();
    private Phong_DAO phong_dao = new Phong_DAO();
    
    public boolean themChiTietHoaDon(CT_HoaDon ctHD) {
        int n = 0;
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {
            // Sử dụng câu truy vấn INSERT INTO SELECT để lấy thời lượng từ HoaDon
            String sql = "INSERT INTO CT_HoaDon (MaHD, MaP, ThoiLuong) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(sql);

            ctHD.setHoaDon(hoaDon_dao.timHoaDonTheoMa(ctHD.getHoaDon().getMaHD()));

            stmt.setString(1, ctHD.getHoaDon().getMaHD());
            stmt.setString(2, ctHD.getPhong().getMaPhong());
            stmt.setInt(3, ctHD.getThoiLuong());

            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    
    public boolean kiemTraPhongDaCo(String maHoaDon, String maP) {
        boolean check = false;
        String sql = "SELECT COUNT(*) AS count FROM CT_HoaDon WHERE MaHD = ? AND MaP = ?";
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection con = connectDB.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maHoaDon);
            stmt.setString(2, maP);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                check = (count > 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public boolean capNhatThoiLuongPhong(String maHoaDon, String maPhong, int thoiLuong) {
        String sql = "UPDATE CT_HoaDon SET ThoiLuong= ? where MaHD = ? AND MaP = ?";
        int rs = 0;
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection con = connectDB.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, thoiLuong);
            stmt.setString(2, maHoaDon);
            stmt.setString(3, maPhong);

            rs = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return rs > 0;
    }
    
    public ArrayList<CT_HoaDon> layDanhSachCTHoaDon(String maHoaDon) {
        ArrayList<CT_HoaDon> dsCTHD = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ct.MaHD, ct.MaP, p.TenPhong, p.GiaPhong, ct.ThoiLuong \n" +
                         "from CT_HoaDon ct join Phong p on ct.MaP=p.MaPhong \n" +
                         "where MaHD = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maHoaDon);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String maPhong = rs.getString("MaP");
                String tenPhong = rs.getString("TenPhong");
                double giaBan = rs.getDouble("GiaPhong");
                int thoiLuong = rs.getInt("ThoiLuong");
                
                HoaDon hoaDon = new HoaDon(maHoaDon);
                Phong phong = new Phong(maPhong, tenPhong, (float) giaBan);
                CT_HoaDon cthd = new CT_HoaDon(hoaDon, phong, thoiLuong);
                dsCTHD.add(cthd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCTHD;
    }
}
