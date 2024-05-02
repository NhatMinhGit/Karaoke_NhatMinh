package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.query.NativeQuery;

import dao.ChucVu_DAO;
import entity.ChucVu;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityTransaction;

public class ChucVuImpl extends UnicastRemoteObject implements ChucVu_DAO{
	
	private static final long serialVersionUID = 4743369504059474419L;
	private EntityManager em;
	private ChucVu cv;
	

	public ChucVuImpl() throws RemoteException{
		em = Persistence.createEntityManagerFactory("KaraokeMMM").createEntityManager();
	}
	
	//Lay danh sach chuc vu
	@Override
	public List<ChucVu> layDanhSachChucVu() throws RemoteException{
		return em.createQuery("select cv from ChucVu cv", ChucVu.class)
				.getResultList();
	}
	
	//Them chuc vu
//	@Override
//	public boolean themChucVu(ChucVu cv) throws RemoteException {
//		EntityTransaction tx = em.getTransaction();
//		try {
//			tx.begin();
//			em.persist(cv);
//			tx.commit();
//			return true;
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		}
//		return false;
//	}
	@Override
	public boolean themChucVu(ChucVu cv) throws RemoteException {
	    EntityTransaction tx = em.getTransaction();
	    try {
	        // Kiểm tra xem ChucVu với MaChucVu tương ứng đã tồn tại chưa
	        ChucVu existingChucVu = em.find(ChucVu.class, cv.getMaChucVu());
	        if (existingChucVu != null) {
	            // Nếu đã tồn tại, không thực hiện thao tác thêm và trả về false
	            return false;
	        }

	        tx.begin();
	        em.persist(cv);
	        tx.commit();
	        return true;
	    } catch (Exception e) {
	        tx.rollback();
	        e.printStackTrace();
	    }
	    return false;
	}

	@Override
	public boolean capNhatChucVu(ChucVu x) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			String query = "update ChucVu set TenChucVu = :ten where MaChucVu = :ma";
			NativeQuery<ChucVu> cv = (NativeQuery<ChucVu>) em.createNativeQuery(query, ChucVu.class);
			cv.setParameter("ten", x.getTenChucVu());
			cv.setParameter("ma", x.getMaChucVu());
			cv.executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ChucVu timChucVuTheoMa(String maChucVu) throws RemoteException {
	    String query = "select cv from ChucVu cv where cv.maChucVu = :maChucVu";
	    List<ChucVu> results = em.createQuery(query, ChucVu.class)
	            .setParameter("maChucVu", maChucVu)
	            .getResultList();
	    return results.isEmpty() ? null : results.get(0);
	}
	
}
