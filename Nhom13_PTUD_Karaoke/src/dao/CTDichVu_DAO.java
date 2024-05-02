
package dao;

import connectdb.ConnectDB;
import entity.CT_DichVu;
import entity.DichVu;
import entity.HoaDon;
import entity.Phong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class CTDichVu_DAO {
    private DichVu_DAO dichVu_dao = new DichVu_DAO();
    private HoaDon_DAO hoaDon_dao = new HoaDon_DAO();
    private Phong_DAO phong_dao = new Phong_DAO();
    
    public boolean themChiTietDichVu(CT_DichVu ctDV) {
        int n = 0;
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO CT_DichVu (MaHD, MaDV, SoLuong) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(sql);

            ctDV.setHoaDon(hoaDon_dao.timHoaDonTheoMa(ctDV.getHoaDon().getMaHD()));

            stmt.setString(1, ctDV.getHoaDon().getMaHD());
            stmt.setString(2, ctDV.getDichVu().getMaDV());
            stmt.setInt(3, ctDV.getSoLuong());

            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    
    public ArrayList<CT_DichVu> layDanhSachDichVu(String maHoaDon) {
        ArrayList<CT_DichVu> dsCTDV = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT ct.MaHD, dv.MaDichVu, dv.TenDichVu, dv.GiaBan, ct.SoLuong, dv.DonViTinh \n" +
                        "FROM CT_DichVu ct JOIN DichVu dv \n" +
                        "ON ct.MaDV = dv.MaDichVu WHERE MaHD = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maHoaDon);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String maDichVu = rs.getString("MaDichVu");
                String tenDichVu = rs.getString("TenDichVu");
                double giaBan = rs.getDouble("GiaBan");
                int soLuong = rs.getInt("SoLuong");
                String donViTinh = rs.getString("DonViTinh");
                
                HoaDon hoaDon = new HoaDon(maHoaDon);
                DichVu dichVu = new DichVu(maDichVu, tenDichVu, giaBan, donViTinh);
                CT_DichVu cthd = new CT_DichVu(hoaDon, dichVu, soLuong);
                dsCTDV.add(cthd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCTDV;
    }
    
    public boolean xoaChiTietDichVu(String maHoaDon, String tenDichVu) {
		String sql = "Delete from CT_DichVu where MaHD = ? AND MaDV = ?";
		int rs = 0;
		ConnectDB connectDB = ConnectDB.getInstance();
                Connection con = connectDB.getConnection();
                PreparedStatement stmt = null;
                DichVu dichVu = null;
		try {
			stmt = con.prepareStatement(sql);
                        dichVu = dichVu_dao.timDichVuTheoTen(tenDichVu);
                        stmt.setString(1, maHoaDon);
                        stmt.setString(2, dichVu.getMaDV());

			rs = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs > 0;
	}
    
    public boolean kiemTraDichVuDaCo(String maHoaDon, String tenDichVu) {
        boolean check = false;
        String sql = "SELECT COUNT(*) AS count FROM CT_DichVu WHERE MaHD = ? AND MaDV = ?";
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection con = connectDB.getConnection();
        PreparedStatement stmt = null;
        DichVu dichVu = null;
        try {
            stmt = con.prepareStatement(sql);
            dichVu = dichVu_dao.timDichVuTheoTen(tenDichVu);

            stmt.setString(1, maHoaDon);
            stmt.setString(2, dichVu.getMaDV());

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
    
    public boolean capNhatSoLuongDichVu(String maHoaDon, String tenDichVu, int soLuongMoi) {
        String sql = "UPDATE CT_DichVu SET SoLuong = ? WHERE MaHD = ? AND MaDV = ?";
        int rs = 0;
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection con = connectDB.getConnection();
        PreparedStatement stmt = null;
        DichVu dichVu = null;

        try {
            stmt = con.prepareStatement(sql);
            dichVu = dichVu_dao.timDichVuTheoTen(tenDichVu);

            stmt.setInt(1, soLuongMoi);
            stmt.setString(2, maHoaDon);
            stmt.setString(3, dichVu.getMaDV());

            rs = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return rs > 0;
    }
}
