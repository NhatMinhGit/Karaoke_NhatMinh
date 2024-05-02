/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectdb.ConnectDB;
import entity.DichVu;
import entity.LoaiPhong;
import entity.Phong;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ad
 */
public interface Phong_DAO extends Remote{

        public List<Phong> getAllPhong() throws RemoteException;
        public Phong getAllPhongTrong(String trangThaiPhong) throws RemoteException;
        public Phong locPhongTheoLPvsTTP(String maLP,String trangThaiP) throws RemoteException;
        public Phong locPhongTheoLPvsSNTD(String maLP,String soNguoiToiDa) throws RemoteException;
        public Phong timPhongTheoMaPhong(String maPhong) throws RemoteException;
        public boolean capNhatPhong(Phong x) throws RemoteException;
        public boolean chuyenTrangThaiCho(Phong x) throws RemoteException;
        
//        public ArrayList<Phong> getDanhSachPhongTheoNgayDatTruoc(Date ngayDatTruoc) throws SQLException {
//            ArrayList<Phong> listPhongDatTruoc = new ArrayList<>();
//            ConnectDB.getInstance();
//            Connection con = ConnectDB.getConnection();
//            String sql = "SELECT Phong.MaPhong, Phong.TenPhong, Phong.MaLoaiPhong, Phong.TinhTrang "
//                    + "FROM Don_Dat_Phong "
//                    + "INNER JOIN Phong ON Don_Dat_Phong.MaPhong = Phong.MaPhong "
//                    + "WHERE DAY(ThoiGianVao) = ? AND MONTH(ThoiGianVao) = ? AND YEAR(ThoiGianVao) = ? AND TrangThaiDon = N'Đặt Trước'";
//
//            PreparedStatement prepareStatement = con.prepareStatement(sql);
//
//            try {
//                prepareStatement.setInt(1, ngayDatTruoc.getDate());
//                prepareStatement.setInt(2, 1 + ngayDatTruoc.getMonth());
//                prepareStatement.setInt(3, 1900 + ngayDatTruoc.getYear());
//                ResultSet rs = prepareStatement.executeQuery();
//
//                while (rs.next()) {
//                    Phong phong = new Phong();
//                    LoaiPhong loaiPhong = new LoaiPhong();
//
//                    int maP = rs.getInt(1);
//                    String maPhong = "MP" + maP;
//                    phong.setMaPhong(maPhong);
//
//                    phong.setTenPhong(rs.getString(2));
//
//                    loaiPhong = loaiPhongDAO.getLoaiPhongTheoMa(rs.getString(3));
//                    phong.setLoaiPhong(loaiPhong);
//                    phong.setTrangThai(rs.getString(4));
//
//                    listPhongDatTruoc.add(phong);
//                }
//            }
//            return listPhongDatTruoc;
//        }
        
        
        
}
