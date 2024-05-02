
package dao;

import com.toedter.calendar.JDateChooser;
import connectdb.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

public class HoaDon_DAO {
    public boolean themHoaDon(HoaDon hoaDon) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        int n = 0;

        try {
            ConnectDB.getInstance();
            con = ConnectDB.getInstance().getConnection();

            Timestamp ngayLapHD = new Timestamp(System.currentTimeMillis());
            String maHoaDon = generateMaHoaDon(ngayLapHD);

            String sql = "INSERT INTO HoaDon (MaHoaDon, NgayLapHD, MaNV, TenKhachHang, MaP, GioNhanPhong, GioTraPhong, MaKM, TongTien) "
                    + "VALUES (?, ?, ?, ?, ?, ?, null, null, null)";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, maHoaDon);
            stmt.setTimestamp(2, ngayLapHD);
            stmt.setString(3, hoaDon.getNhanVien().getMaNhanVien());
            stmt.setString(4, hoaDon.getTenKhachHang());
            stmt.setString(5, hoaDon.getPhong().getMaPhong());
            stmt.setTimestamp(6, ngayLapHD);

            n = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n > 0;
    }

    private String generateMaHoaDon(Timestamp ngayLapHD) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmss");
        String ngayThangNamGio = dateFormat.format(ngayLapHD);

        String maHoaDon = "HD" + ngayThangNamGio;
        return maHoaDon;
    }
    
    public String timMaHoaDonTheoMaPhong(String maPhong) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String maHoaDon = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT HoaDon.MaHoaDon FROM HoaDon JOIN Phong ON HoaDon.MaP = Phong.MaPhong WHERE Phong.MaPhong = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maPhong);

            rs = stmt.executeQuery();

            while (rs.next()) {
                maHoaDon = rs.getString("MaHoaDon");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return maHoaDon;
    }

    public HoaDon timHoaDonTheoMa(String maHoaDon) {
        HoaDon hoaDon = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maHoaDon);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Date ngayLapHD = rs.getDate("NgayLapHD");
                NhanVien maNV = new NhanVien(rs.getString("MaNV"));
                String tenKhachHang = rs.getString("TenKhachHang");
                Phong maP = new Phong(rs.getString("MaP"));
                Timestamp gioNhanPhong = rs.getTimestamp("GioNhanPhong");

                hoaDon = new HoaDon(maHoaDon, ngayLapHD, maNV, tenKhachHang, maP, gioNhanPhong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return hoaDon;
    }
    
    public boolean capNhatHoaDon(HoaDon hoaDon) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        int n =0;
        try {
            // Xây dựng truy vấn UPDATE
            String sql = "UPDATE HoaDon SET MaKM = ?, TongTien= ?, ChietKhau= ?, TienKhachTra= ? WHERE MaHoaDon= ?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, hoaDon.getKhuyenMai().getMaKhuyenMai());
            stmt.setDouble(2, hoaDon.getTongTien());
            stmt.setFloat(3, hoaDon.getChietKhau());
            stmt.setDouble(4, hoaDon.getTienKhachTra());
            stmt.setString(5, hoaDon.getMaHD());
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    
    public boolean capNhatGioTraPhong(String maHoaDon, Timestamp gioTraPhong) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        int n = 0;

        try {
            String sql = "UPDATE HoaDon SET GioTraPhong = ? WHERE MaHoaDon = ?";
            stmt = con.prepareStatement(sql);

            stmt.setTimestamp(1, gioTraPhong);
            stmt.setString(2, maHoaDon);

            // Thực hiện truy vấn UPDATE
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    
    public ArrayList<HoaDon> timChiTietHoaDonTheoMa(String maHoaDon) {
        ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();
        HoaDon hoaDon = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select hd.MaHoaDon, hd.NgayLapHD, hd.MaNV, nv.TenNV, hd.TenKhachHang, hd.MaP, hd.GioNhanPhong, hd.GioTraPhong, hd.ChietKhau, hd.TienKhachTra, hd.TongTien\n" +
                         "from HoaDon hd join NhanVien nv \n" +
                         "			on hd.MaNV=nv.MaNhanVien\n" +
                         "where MaHoaDon = ? AND TongTien IS NOT NULL";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maHoaDon);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Date ngayLapHD = rs.getDate("NgayLapHD");
                String maNV = rs.getString("MaNV");
                String tenNV = rs.getString("TenNV");
                String tenKhachHang = rs.getString("TenKhachHang");
                Phong maP = new Phong(rs.getString("MaP"));
                Timestamp gioNhanPhong = rs.getTimestamp("GioNhanPhong");
                Timestamp gioTraPhong = rs.getTimestamp("GioTraPhong");
                float tongTien = rs.getFloat("TongTien");
                float chietKhau = rs.getFloat("ChietKhau");
                float tienKhachTra = rs.getFloat("TienKhachTra");

                NhanVien nhanVien = new NhanVien(maNV, tenNV);
                hoaDon = new HoaDon(maHoaDon, ngayLapHD, nhanVien, tenKhachHang, maP, gioNhanPhong, gioTraPhong, tongTien, chietKhau, tienKhachTra);
                danhSachHoaDon.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachHoaDon;
    }
    
    public ArrayList<HoaDon> timChiTietHoaDonTheoNgay(Date ngayLapHoaDon) {
        ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select hd.MaHoaDon, hd.NgayLapHD, hd.MaNV, nv.TenNV, hd.TenKhachHang, hd.MaP, hd.GioNhanPhong, hd.GioTraPhong, hd.ChietKhau, hd.TienKhachTra, hd.TongTien\n" +
                         "from HoaDon hd join NhanVien nv \n" +
                         "			on hd.MaNV=nv.MaNhanVien\n" +
                         "where NgayLapHD = ? AND TongTien IS NOT NULL";
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String ngayLap = df.format(ngayLapHoaDon);
            stmt = con.prepareStatement(sql);
            stmt.setString(1, ngayLap);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String maHoaDon = rs.getString("MaHoaDon");
                Date ngayLapHD = rs.getDate("NgayLapHD");
                String maNV = rs.getString("MaNV");
                String tenNV = rs.getString("TenNV");
                String tenKhachHang = rs.getString("TenKhachHang");
                Phong maP = new Phong(rs.getString("MaP"));
                Timestamp gioNhanPhong = rs.getTimestamp("GioNhanPhong");
                Timestamp gioTraPhong = rs.getTimestamp("GioTraPhong");
                float tongTien = rs.getFloat("TongTien");
                float chietKhau = rs.getFloat("ChietKhau");
                float tienKhachTra = rs.getFloat("TienKhachTra");

                NhanVien nhanVien = new NhanVien(maNV, tenNV);
                HoaDon hoaDon = new HoaDon(maHoaDon, ngayLapHD, nhanVien, tenKhachHang, maP, gioNhanPhong, gioTraPhong, tongTien, chietKhau, tienKhachTra);
                danhSachHoaDon.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachHoaDon;
    }
    
    public boolean kiemTraHoaDonTonTai(String maHoaDon) {
        boolean kiemTra = false;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.getConnection();
            String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maHoaDon);
            rs = stmt.executeQuery();

            kiemTra = rs.next(); // Nếu có kết quả, kiemTra = true; ngược lại, kiemTra = false
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kiemTra;
    }
}
