package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;

import connectdb.ConnectDB;
import dao.PhieuDatPhong_DAO;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.hibernate.query.NativeQuery;


public class PhieuDatPhongImpl extends UnicastRemoteObject implements PhieuDatPhong_DAO {
    
    private static final long serialVersionUID = 4753369504059474419L;
    private EntityManager em;

    public PhieuDatPhongImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("KaraokeMMM").createEntityManager();
    }
    
    
        @Override
	public List<PhieuDatPhong> layDanhSachNhanVien() {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			List<PhieuDatPhong> list = em.createNativeQuery("select * from PhieuDatPhong pdp", PhieuDatPhong.class).getResultList();
			tx.commit();
			return list;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return null;
		
	}
        
        @Override
        public boolean themPhieuDatPhong(PhieuDatPhong phieuDatPhong)
	{
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
                        em.persist(phieuDatPhong);
                        String query = "Update Phong set TrangThaiPhong=N'Đầy' where MaPhong=?";
                        NativeQuery<PhieuDatPhong> pdp = (NativeQuery<PhieuDatPhong>) em.createNativeQuery(query, PhieuDatPhong.class);
			pdp.setParameter("maPDP", phieuDatPhong.getMaPhieuDatPhong());	
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
        }
        
        @Override
        public boolean capNhatPhieuDatPhong(PhieuDatPhong x) throws RemoteException{
            EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			String query = "UPDATE PhieuDatPhong pdp SET pdp.trangThaiPhieu = :trangThaiMoi WHERE pdp.maPhieuDatPhong = :maPhieuDatPhong";
			NativeQuery<PhieuDatPhong> pdp = (NativeQuery<PhieuDatPhong>) em.createNativeQuery(query, PhieuDatPhong.class);
			pdp.setParameter("maPDP", x.getMaPhieuDatPhong());
			pdp.setParameter("trangThaiPhieu", "Đã thanh toán");
			pdp.executeUpdate();
			
                        String query1 = "UPDATE Phong p SET p.trangThaiPhong = :trangThaiMoi WHERE p.maPhong = :maPhong";
			NativeQuery<PhieuDatPhong> pdp1 = (NativeQuery<PhieuDatPhong>) em.createNativeQuery(query1, PhieuDatPhong.class);
			pdp1.setParameter("maP", x.getMaPhieuDatPhong());
			pdp1.setParameter("trangThaiPhong", "Trống");
			
			pdp1.executeUpdate();
                        tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
        }
        
        @Override
        public PhieuDatPhong layPhieuDatPhongChuaThanhToan(String trangThaiPhieu) throws RemoteException {
            try{
                TypedQuery<PhieuDatPhong> query = em.createQuery("SELECT pdp.maPhieuDatPhong, pdp.phong.maPhong, p.tenPhong, lp.maLoaiPhong, lp.tenLoaiPhong, p.giaPhong, pdp.gioNhanPhong, pdp.khachHang.maKhachHang, kh.tenKhachHang, pdp.nhanVien.maNhanVien, nv.tenNV " +
                                                    "FROM PhieuDatPhong pdp " +
                                                    "JOIN pdp.phong p " +
                                                    "JOIN p.loaiPhong lp " +
                                                    "JOIN pdp.khachHang kh " +
                                                    "JOIN pdp.nhanVien nv " +
                                                    "WHERE pdp.trangThaiPhieu = :trangThaiPhieu",PhieuDatPhong.class);
;
               query.setParameter("trangThaiPhieu", "Chưa thanh toán");
                return query.getSingleResult();
            } catch (NoResultException e){
                return null;
            }  
}
        
        public PhieuDatPhong layPhieuDatPhongDatTruoc(String trangThaiPhieu) throws RemoteException {
            try{
                TypedQuery<PhieuDatPhong> query = em.createQuery("SELECT pdp.maPhieuDatPhong, pdp.phong.maPhong, p.tenPhong, lp.maLoaiPhong, lp.tenLoaiPhong, p.giaPhong, pdp.khachHang.maKhachHang, kh.tenKhachHang, pdp.nhanVien.maNhanVien, nv.tenNV, pdp.ngayDatPhong, pdp.trangThaiPhieu \" +\n" +
                        "              \"FROM PhieuDatPhong pdp \" +\n" +
                        "              \"JOIN pdp.khachHang kh \" +\n" +
                        "              \"JOIN pdp.phong p \" +\n" +
                        "              \"JOIN p.loaiPhong lp \" +\n" +
                        "              \"JOIN pdp.nhanVien nv \" +\n" +
                        "              \"WHERE pdp.trangThaiPhieu = :trangThaiPhieu",PhieuDatPhong.class);
               query.setParameter("trangThaiPhieu", "Đặt trước");
                return query.getSingleResult();
            } catch (NoResultException e){
                return null;
            }          
        }
        
        
        public boolean themPhieuDatPhongTruoc(PhieuDatPhong x)
	{
                EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			String query = "INSERT INTO PhieuDatPhong(pdp.maPhieuDatPhong, pdp.maP, pdp.maKH, pdp.maNV, pdp.ngayDatPhong, pdp.trangThaiPhieu) VALUES (:maPhieuDatPhong, :maP, :maKH, :maNV, :ngayDatPhong, :trangThaiPhieu)";
			NativeQuery<PhieuDatPhong> pdp = (NativeQuery<PhieuDatPhong>) em.createNativeQuery(query, PhieuDatPhong.class);
			pdp.setParameter("maPDP", x.getMaPhieuDatPhong());
			pdp.setParameter("maP", x.getPhong().getMaPhong());
			pdp.setParameter("maKH", x.getKhachHang().getMaKhachHang());
			pdp.setParameter("maNV", x.getNhanVien().getMaNhanVien());
			pdp.setParameter("ngayDatPhong", x.getNgayDatPhong());
			pdp.setParameter("trangThaiPhieu", x.getTrangThaiPhieu());
			pdp.executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
        }
        
        public boolean huyPhieuDatPhong(PhieuDatPhong x)
        {
            EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			String query = "DELETE FROM PhieuDatPhong pdp WHERE pdp.maPhieuDatPhong = :maPhieuDatPhong";
			NativeQuery<PhieuDatPhong> pdp = (NativeQuery<PhieuDatPhong>) em.createNativeQuery(query, PhieuDatPhong.class);
			pdp.setParameter("maPDP", x.getMaPhieuDatPhong());
			pdp.setParameter("maP", x.getPhong().getMaPhong());
			pdp.setParameter("maKH", x.getKhachHang().getMaKhachHang());
			pdp.setParameter("maNV", x.getNhanVien().getMaNhanVien());
			pdp.setParameter("ngayDatPhong", x.getNgayDatPhong());
			pdp.setParameter("trangThaiPhieu", x.getTrangThaiPhieu());
			pdp.executeUpdate();
			
                        String query1 = "UPDATE Phong p SET p.trangThaiPhong = :trangThaiPhong WHERE p.maPhong = :maPhong";
			NativeQuery<PhieuDatPhong> pdp1 = (NativeQuery<PhieuDatPhong>) em.createNativeQuery(query1, PhieuDatPhong.class);
			pdp1.setParameter("maPDP", x.getMaPhieuDatPhong());
			pdp1.setParameter("maP", x.getPhong().getMaPhong());
			pdp1.setParameter("maKH", x.getKhachHang().getMaKhachHang());
			pdp1.setParameter("maNV", x.getNhanVien().getMaNhanVien());
			pdp1.setParameter("ngayDatPhong", x.getNgayDatPhong());
			pdp1.setParameter("trangThaiPhieu", "Trống");
			pdp1.executeUpdate();
                        tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
        }
         
        
        public Phong timMaPhieuDatPhongTheoMaPhong(String maPhieuDatPhong,String maPhong) {           
            try {
	        TypedQuery<Phong> query = em.createQuery("select pdp from PhieuDatPhong pdp where nv.maPhong = :maPhong", Phong.class);
	        query.setParameter("maPhong", maPhong);
                query.setParameter("maPhieuDatPhong", maPhieuDatPhong);
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
        }
        
//        public String khoiTaoMaPhieuDatPhong() {
//            ConnectDB.getInstance();
//            Connection con = ConnectDB.getConnection();
//            PreparedStatement stmt = null;
//            String nextMaPhieuDatPhong = null;
//
//            try {
//                String sql = "SELECT MAX(FUNCTION('TRY_CAST', FUNCTION('SUBSTRING', pdp.maPhieuDatPhong, 4, (LENGTH(pdp.maPhieuDatPhong) - 3)), 'INT')) AS MaxID FROM PhieuDatPhong pdp";
//                stmt = con.prepareStatement(sql);
//
//                try (ResultSet rs = stmt.executeQuery()) {
//                    if (rs.next()) {
//                        int maxID = rs.getInt("MaxID");
//                        maxID++;
//                        nextMaPhieuDatPhong = "PDP" + String.format("%04d", maxID); // Use "PDP" as the prefix
//                    } else {
//                        // If the table is empty, start with the first ID
//                        nextMaPhieuDatPhong = "PDP0001";
//                    }
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            return nextMaPhieuDatPhong;
//        }
//
//        public String khoiTaoTrangThaiPhieu() {
//            String trangThaiPhieu = "Chưa thanh Toán";
//            return trangThaiPhieu;
//        }
//        
//        public String khoiTaoTrangThaiPhieuDatTruoc() {
//            String trangThaiPhieu = "Đặt trước";
//            return trangThaiPhieu;
//        }

    
}