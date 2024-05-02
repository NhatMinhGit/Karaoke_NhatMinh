/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectdb.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Duong Ngo Manh
 */
public class ThongKeDT_DAO {
    private KhachHang_DAO kh_dao = new KhachHang_DAO();
    public ArrayList<HoaDon> layDoanhThuNgay() throws SQLException {
        ArrayList<HoaDon> dsTKHD = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String sql = "SELECT NgayLapHD, SUM(TongTien) AS TongTien FROM HoaDon GROUP BY NgayLapHD";
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setNgayLapHD(rs.getDate("NgayLapHD"));
                hd.setTongTien(rs.getFloat("TongTien"));
                dsTKHD.add(hd);
            }
            return dsTKHD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDon> layDoanhThuThang() throws SQLException {
        ArrayList<HoaDon> dsTKHD = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String sql = "SELECT YEAR(NgayLapHD) AS Nam, MONTH(NgayLapHD) AS Thang, SUM(TongTien) AS TongTien FROM HoaDon GROUP BY YEAR(NgayLapHD), MONTH(NgayLapHD);";
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                int thang = rs.getInt("Thang");
                int nam = rs.getInt("Nam");
                LocalDate localDate = LocalDate.of(nam, thang, 1);
                Date ngayLapHD = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                hd.setNgayLapHD(ngayLapHD);
                hd.setTongTien(rs.getFloat("TongTien"));
                dsTKHD.add(hd);
            }
            return dsTKHD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDon> layDoanhThuNam() throws SQLException {
        ArrayList<HoaDon> dsTKHD = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String sql = "SELECT YEAR(NgayLapHD) AS Nam, SUM(TongTien) AS TongTien FROM HoaDon GROUP BY YEAR(NgayLapHD);";
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                int nam = rs.getInt("Nam");
                Date ngayLapHD = new Date(nam - 1900, 0, 1); // Tạo đối tượng Date với tháng và năm
                hd.setNgayLapHD(ngayLapHD);
                hd.setTongTien(rs.getFloat("TongTien"));
                dsTKHD.add(hd);
            }
            return dsTKHD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public ArrayList<HoaDon> layChiTieuKhachHang() throws SQLException {
//        ArrayList<HoaDon> dsTKHD = new ArrayList<>();
//        ConnectDB.getInstance();
//        Connection con = ConnectDB.getConnection();
//        String sql = "SELECT TenKhachHang, SUM(TienKhachTra) AS TongTien FROM HoaDon GROUP BY TenKhachHang;";
//        try {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                HoaDon hd = new HoaDon();
//                hd.setTenKhachHang(rs.getString("TenKhachHang"));
//                hd.setTongTien(rs.getFloat("TongTien"));
//                dsTKHD.add(hd);
//            }
//
//            return dsTKHD;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public ArrayList<KhachHang> layTopKhachHangChiTieu() throws SQLException {
        ArrayList<KhachHang> dsTopKhachHang = new ArrayList<>();
        
        Connection con = ConnectDB.getConnection();
        String sql = "SELECT TenKhachHang, COUNT(MaHoaDon) AS SoHoaDon, SUM(TongTien) AS TongChiTieu  FROM HoaDon GROUP BY TenKhachHang ORDER BY TongChiTieu DESC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                String tenKH = rs.getString("TenKhachHang");
                KhachHang kh = new KhachHang();
                String maKH = kh_dao.timMaKhachHangTheoTenKH(tenKH);
                int soHD = rs.getInt("SoHoaDon");
                float tongCT = rs.getFloat("TongChiTieu");
                
                kh = new KhachHang(maKH, tenKH, soHD, tongCT);
                dsTopKhachHang.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsTopKhachHang;
    }

    public ArrayList<HoaDon> layDoanhThuNgayHienTai() throws SQLException {
    ArrayList<HoaDon> dsTKHD = new ArrayList<>();
    ConnectDB.getInstance();
    Connection con = ConnectDB.getConnection();

    LocalDate currentDate = LocalDate.now();

    String sql = "SELECT SUM(TongTien) AS TongTien FROM HoaDon WHERE YEAR(NgayLapHD) = DATEPART(YEAR, ?) AND MONTH(NgayLapHD) = DATEPART(MONTH, ?) AND DAY(NgayLapHD) = DATEPART(DAY, ?);";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, java.sql.Date.valueOf(currentDate));
        ps.setDate(2, java.sql.Date.valueOf(currentDate));
        ps.setDate(3, java.sql.Date.valueOf(currentDate));

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            HoaDon hd = new HoaDon();
            hd.setTongTien(rs.getFloat("TongTien"));
            dsTKHD.add(hd);
        }
        return dsTKHD;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

    public ArrayList<HoaDon> layDoanhThuThangHienTai() throws SQLException {
        ArrayList<HoaDon> dsTKHD = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        LocalDate currentDate = LocalDate.now();

        String sql = "SELECT SUM(TongTien) AS TongTien FROM HoaDon WHERE YEAR(NgayLapHD) = ? AND MONTH(NgayLapHD) = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, currentDate.getYear());
            ps.setInt(2, currentDate.getMonthValue());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setTongTien(rs.getFloat("TongTien"));
                dsTKHD.add(hd);
            }
            return dsTKHD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDon> layDoanhThuNamHienTai() throws SQLException {
        ArrayList<HoaDon> dsTKHD = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        LocalDate currentDate = LocalDate.now();

        String sql = "SELECT SUM(TongTien) AS TongTien FROM HoaDon WHERE YEAR(NgayLapHD) = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, currentDate.getYear());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setTongTien(rs.getFloat("TongTien"));
                dsTKHD.add(hd);
            }
            return dsTKHD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
