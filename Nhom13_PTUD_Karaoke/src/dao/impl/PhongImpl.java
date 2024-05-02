/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package dao.impl;

import connectdb.ConnectDB;
import dao.Phong_DAO;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author Admin
 */
public class PhongImpl extends UnicastRemoteObject implements Phong_DAO{
    
    private static final long serialVersionUID = 4743369504059474419L;
    private EntityManager em;
    
    public PhongImpl() throws RemoteException{
        em = Persistence.createEntityManagerFactory("KaraokeMMM").createEntityManager();
    }
    
        @Override
        public List<Phong> getAllPhong()
	{
           EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			List<Phong> list = em.createNativeQuery("select * from Phong p", Phong.class).getResultList();
			tx.commit();
			return list;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return null;
	}
        
        @Override
        public boolean themPhong(Phong phong) 
	{
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(phong);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
        }
        
        @Override
        public Phong getAllPhongTrong(String trangThaiPhong) throws RemoteException
	{
            try{
            TypedQuery<Phong> query = em.createQuery("SELECT p.maPhong, p.tenPhong, p.loaiPhong.maLoaiPhong, p.loaiPhong.tenLoaiPhong, p.giaPhong, p.soNguoiToiDa, p.trangThaiPhong " +
              "FROM Phong p JOIN p.loaiPhong lp " +
              "WHERE p.trangThaiPhong = :trangThaiPhong",Phong.class);
               query.setParameter("trangThaiPhieu", "Trống");
               return query.getSingleResult();
            } catch (NoResultException e){
                return null;
            }
	}
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
        
        
        @Override
        public Phong locPhongTheoLPvsTTP(String maLP,String trangThaiP) 
		{
                    try {
                        TypedQuery<Phong> query = em.createQuery("SELECT p FROM Phong p WHERE p.loaiPhong.maLoaiPhong = :maLoaiPhong OR p.trangThaiPhong = :trangThaiPhong", Phong.class);
                        query.setParameter("maLoaiPhong", maLP);
                        query.setParameter("trangThaiPhong", trangThaiP);
                        return query.getSingleResult();
                    } catch (NoResultException e) {
                        return null;
                    }
                }
        @Override
        public Phong locPhongTheoLPvsSNTD(String maLP,String soNguoiToiDa)
		{
			try {
                        TypedQuery<Phong> query = em.createQuery("SELECT p FROM Phong p WHERE p.loaiPhong.maLoaiPhong = :maLoaiPhong OR p.soNguoiToiDa = :soNguoiToiDa ", Phong.class);
                        query.setParameter("maLoaiPhong", maLP);
                        query.setParameter("soNguoiToiDa", soNguoiToiDa);
                        return query.getSingleResult();
                        } catch (NoResultException e) {
                            return null;
                        }
		}
        @Override
        public boolean capNhatPhong(Phong x) throws RemoteException{
                EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			String query = "UPDATE Phong p SET p.loaiPhong.maLoaiPhong = :maLoaiPhong, p.tenPhong = :tenPhong, p.giaPhong = :giaPhong, p.soNguoiToiDa = :soNguoiToiDa, p.trangThaiPhong = :trangThaiMoi WHERE p.maPhong = :maPhong";
			NativeQuery<PhieuDatPhong> pdp = (NativeQuery<PhieuDatPhong>) em.createNativeQuery(query, PhieuDatPhong.class);
                        pdp.setParameter("maLoaiPhong", x.getLoaiPhong().getMaLoaiPhong());
                        pdp.setParameter("tenPhong", x.getTenPhong());
                        pdp.setParameter("giaPhong", x.getGiaPhong());
                        pdp.setParameter("soNguoiToiDa", x.getSoNguoiToiDa());
                        pdp.setParameter("trangThaiPhong", x.getTrangThaiPhong());
			pdp.setParameter("maPhong", x.getMaPhong());
			pdp.executeUpdate();
                        tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
        }
        @Override
        public boolean chuyenTrangThaiCho(Phong x) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			String query = ("UPDATE Phong p SET p.trangThaiPhong = :trangThaiPhong WHERE p.maPhong = :maPhong");
                        NativeQuery<Phong> pdp = (NativeQuery<Phong>) em.createNativeQuery(query, Phong.class);
                        pdp.setParameter("trangThaiPhong", "Chờ");
                        pdp.setParameter("maPhong", x.getMaPhong());
                        
                        tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
                     
        }
        @Override
        public Phong timPhongTheoMaPhong(String maPhong){
            try {
	        TypedQuery<Phong> query = em.createQuery("SELECT p FROM Phong p WHERE p.maPhong = :maPhong", Phong.class);
	        query.setParameter("maPhong", maPhong);
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
        }

    
}
