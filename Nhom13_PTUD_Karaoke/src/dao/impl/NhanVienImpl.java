package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.NativeQuery;

import dao.NhanVien_DAO;
import entity.NhanVien;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

public class NhanVienImpl extends UnicastRemoteObject implements NhanVien_DAO{
	
	private static final long serialVersionUID = 4743369504059474419L;
	private EntityManager em;

	public NhanVienImpl() throws RemoteException{
		em = Persistence.createEntityManagerFactory("KaraokeMMM").createEntityManager();
	}
	
	//Them nhan vien
	@Override
	public boolean themNhanVien(NhanVien nhanVien)  {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(nhanVien);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	//Lay danh sach nhan vien
	@Override
	public List<NhanVien> layDanhSachNhanVien() {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			List<NhanVien> list = em.createNativeQuery("select * from NhanVien nv", NhanVien.class).getResultList();
			tx.commit();
			return list;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return null;	
	}

	//Sua nhan vien
	@Override
	public boolean capNhatNhanVien(NhanVien x) throws RemoteException{
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			String query = "update NhanVien set MaCV = :maCV, TenNV =:ten,GioiTinh =:gioiTinh, NgaySinh =:ngaySinh, SoDT =:sdt,DiaChi =:diaChi,MatKhau =:matKhau where MaNhanVien =:maNhanVien";
			NativeQuery<NhanVien> nv = (NativeQuery<NhanVien>) em.createNativeQuery(query, NhanVien.class);
			nv.setParameter("maCV", x.getChucVu().getMaChucVu());
			nv.setParameter("ten", x.getTenNhanVien());
			nv.setParameter("gioiTinh", x.getGioiTinh());
			nv.setParameter("ngaySinh", x.getNgaySinh());
			nv.setParameter("sdt", x.getSoDienThoai());
			nv.setParameter("diaChi", x.getDiaChi());
			nv.setParameter("matKhau", x.getMatKhau());
			nv.setParameter("maNhanVien", x.getMaNhanVien());
			nv.executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}
        @Override
	//tim nhan vien theo ma nhan vien
	public NhanVien timNhanVienTheoMa(String maNhanVien) {
	    try {
	        TypedQuery<NhanVien> query = em.createQuery("select nv from NhanVien nv where nv.maNhanVien = :maNhanVien", NhanVien.class);
	        query.setParameter("maNhanVien", maNhanVien);
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}
	//tim nhan vien theo Ten
	@Override
	public List<NhanVien> timNhanVienTheoTen(String tenNhanVien)throws RemoteException {
		String query = "select nv from NhanVien nv where nv.tenNhanVien like :tenNhanVien";
		return em.createQuery(query, NhanVien.class)
				.setParameter("tenNhanVien", "%" + tenNhanVien + "%")
				.getResultList();
	}
	
	//tim nhan vien theo chuc vu
	@Override
	public List<NhanVien> timNhanVienTheoChucVu(String maChucVu) throws RemoteException{
		String query = "select nv from NhanVien nv where nv.chucVu.maChucVu = :maChucVu";
		return em.createQuery(query, NhanVien.class)
				.setParameter("maChucVu", maChucVu)
				.getResultList();
	}

	

}
