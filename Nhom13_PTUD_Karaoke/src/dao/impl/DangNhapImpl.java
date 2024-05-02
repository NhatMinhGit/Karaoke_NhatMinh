package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import org.hibernate.query.NativeQuery;

import dao.DangNhap_DAO;
import entity.ChucVu;
import entity.NhanVien;
import entity.ThongTinDangNhap;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityTransaction;
public class DangNhapImpl extends UnicastRemoteObject implements DangNhap_DAO {
	private static final long serialVersionUID = 4743369504059474419L;
	private EntityManager em;

	public DangNhapImpl() throws RemoteException{
		em = Persistence.createEntityManagerFactory("KaraokeMMM").createEntityManager();
	}

	@Override
	public boolean kiemTraDangNhap(String soDienThoai, String matKhau) throws RemoteException{
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();
	        String query = "select * from NhanVien where SoDT = :soDienThoai and MatKhau = :matKhau";
	        NativeQuery<NhanVien> nvQuery = (NativeQuery<NhanVien>) em.createNativeQuery(query, NhanVien.class);
	        nvQuery.setParameter("soDienThoai", soDienThoai);
	        nvQuery.setParameter("matKhau", matKhau);
	        List<NhanVien> resultList = nvQuery.getResultList();
	        tx.commit();
	        return !resultList.isEmpty(); // Trả về true nếu danh sách kết quả không rỗng (đăng nhập thành công)
	    } catch (Exception e) {
	        tx.rollback();
	        e.printStackTrace();
	    }
	    
	    return false;
	}

	@Override
	public String layChucVu(String soDienThoai, String matKhau) throws RemoteException {
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();
	        String query = "select cv.TenChucVu,cv.MaChucVu from NhanVien nv join ChucVu cv on nv.MaCV = cv.MaChucVu where nv.SoDT = :soDienThoai and nv.MatKhau = :matKhau";
	        NativeQuery<ChucVu> cvQuery = (NativeQuery<ChucVu>) em.createNativeQuery(query, ChucVu.class);
	        cvQuery.setParameter("soDienThoai", soDienThoai);
	        cvQuery.setParameter("matKhau", matKhau);
	        List<ChucVu> resultList = cvQuery.getResultList();
	        tx.commit();
	        if (!resultList.isEmpty()) {
	            return resultList.get(0).getTenChucVu();
	        }
	    } catch (Exception e) {
	        tx.rollback();
	        e.printStackTrace();
	        throw e; // Ném lại ngoại lệ
	    }

	    return null;
	}
	/**
	 * Lấy tên nhân viên dựa vào số điện thoại và mật khẩu và thêm vào lớp thông tin đăng nhập
     *
	 */
	@Override
	public void layTenNhanVien(String soDienThoai, String matKhau) throws RemoteException {
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();
	        String query = "select nv.TenNV from NhanVien nv where nv.SoDT = :soDienThoai and nv.MatKhau = :matKhau";
	        NativeQuery<String> nvQuery = (NativeQuery<String>) em.createNativeQuery(query);
	        nvQuery.setParameter("soDienThoai", soDienThoai);
	        nvQuery.setParameter("matKhau", matKhau);
	        List<String> resultList = nvQuery.getResultList();
	        tx.commit();

	        if (!resultList.isEmpty()) {
	            String tenNhanVien = resultList.get(0);
	            ThongTinDangNhap.setTenNhanVien(tenNhanVien);//them vao lop thong tin dang nhap
	        }
	    } catch (Exception e) {
	        if (tx != null && tx.isActive()) tx.rollback();
	        throw new RemoteException("Error executing query", e);
	    } 
	}
	
	@Override
	public void layMaNhanVien(String soDienThoai, String matKhau) throws RemoteException {
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();
	        String query = "select nv.MaNhanVien from NhanVien nv where nv.SoDT = :soDienThoai and nv.MatKhau = :matKhau";
	        NativeQuery<String> nvQuery = (NativeQuery<String>) em.createNativeQuery(query);
	        nvQuery.setParameter("soDienThoai", soDienThoai);
	        nvQuery.setParameter("matKhau", matKhau);
	        List<String> resultList = nvQuery.getResultList();
	        tx.commit();

	        if (!resultList.isEmpty()) {
	            String maNhanVien = resultList.get(0);
	            ThongTinDangNhap.setMaNhanVien(maNhanVien);// them vao lop thong tin dang nhap
	        }
	    } catch (Exception e) {
	        if (tx != null && tx.isActive()) tx.rollback();
	        throw new RemoteException("Error executing query", e);
	    }
	}
}
