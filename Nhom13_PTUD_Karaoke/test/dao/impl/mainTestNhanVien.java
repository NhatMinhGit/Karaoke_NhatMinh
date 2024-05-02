package dao.impl;

import dao.NhanVien_DAO;
import dao.Impl.NhanVienImpl;
import dao.Impl.ChucVuImpl;
import dao.ChucVu_DAO;


import entity.NhanVien;
import entity.ChucVu;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.rmi.RemoteException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
@TestInstance(Lifecycle.PER_CLASS)
public class mainTestNhanVien {
	
	/*
	 * Huỳnh Công Vương _ 21004195
     */
	
	
	private ChucVu_DAO chucVuDao;
	private NhanVien_DAO nhanVienDao;
	private NhanVien x;
	private ChucVu cv;
	
	@BeforeAll
	void setUp() throws Exception {
		nhanVienDao = new NhanVienImpl();
		chucVuDao = new ChucVuImpl();
	}
	
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		nhanVienDao = new NhanVienImpl();
		chucVuDao = new ChucVuImpl();
	}

	@AfterAll
	void tearDownAfterClass() throws Exception {
		nhanVienDao = null;
		chucVuDao = null;
	}
	
//	@Test
//	void testThemNhanVien() throws RemoteException {
//	    NhanVien x = new NhanVien();
//	    ChucVu cv = new ChucVu();
//	    cv.setMaChucVu("QL");
//	    cv.setTenChucVu("Quản lý Karaoke");
//
//	    // Kiểm tra xem ChucVu với MaChucVu tương ứng đã tồn tại chưa
//	    ChucVu existingChucVu = chucVuDao.timChucVuTheoMa("VC20");
//	    if (existingChucVu == null) {
//	        // Nếu chưa tồn tại, thực hiện thao tác thêm
//	        chucVuDao.themChucVu(cv);
//	    } else {
//	        // Nếu đã tồn tại, sử dụng ChucVu hiện có
//	        cv = existingChucVu;
//	    }
//
//	    x.setMaNhanVien("NV100");
//	    x.setTenNhanVien("Nguyen Van A");
//	    x.setGioiTinh("Nam");
//	    x.setNgaySinh("01/01/1990");
//	    x.setSoDienThoai("0123456789");
//	    x.setDiaChi("Hanoi");
//	    x.setMatKhau("123556");
//	    x.setChucVu(cv);
//	    
//
//	    boolean themThanhCong = nhanVienDao.themNhanVien(x);
//
//	    if (!themThanhCong) {
//	        System.out.println("Failed to add NhanVien. Please check the implementation of themNhanVien.");
//	    }
//
//	    Assertions.assertTrue(themThanhCong);
//	
//
//	     //Kiểm tra xem nhân viên đã được thêm thành công hay không
//	    NhanVien nhanVienMoi = nhanVienDao.timNhanVienTheoMa("NV100");
//	    Assertions.assertNotNull(nhanVienMoi);
//	    Assertions.assertEquals("Nguyen Van A", nhanVienMoi.getTenNhanVien());
//	}
//	
//	@Test
//	void LayDanhSachNhanVien() throws RemoteException {
//		assertTrue(nhanVienDao.layDanhSachNhanVien().size() > 0);
//		int size = nhanVienDao.layDanhSachNhanVien().size();
//		System.out.println("Lay danh sach nhan vien thanh cong" +  size);
//		
//	}
////	
//	@Test
//	void suaNhanVien() throws RemoteException {
//		NhanVien x = nhanVienDao.timNhanVienTheoMa("NV100");
//		ChucVu cv = new ChucVu();
//		cv.setMaChucVu("QL");
//		cv.setTenChucVu("Quản lý Karaoke");
//		
//        x.setTenNhanVien("Nguyen Van C");
//        x.setGioiTinh("Nam");
//        x.setNgaySinh("01/01/1990");
//        x.setSoDienThoai("0123456789");
//        x.setDiaChi("Hanoi");
//        x.setMatKhau("123556");
//        x.setChucVu(cv);
//        assertTrue(nhanVienDao.capNhatNhanVien(x));
//        System.out.println("Cap nhat nhan vien thanh cong");
//    }
//	@Test
//	void timNhanVienTheoMa() throws RemoteException {
//		NhanVien x = nhanVienDao.timNhanVienTheoMa("NV100");
//		assertEquals("Nguyen Van C", x.getTenNhanVien());
//		System.out.println("Tim nhan vien theo ma thanh cong");
//	}
	
	@Test
	void timNhanVienTheoChucVu() throws RemoteException {
		assertTrue(nhanVienDao.timNhanVienTheoChucVu("QL").size() > 0);
		int size = nhanVienDao.timNhanVienTheoChucVu("QL").size();
		System.out.println("Tim nhan vien theo chuc vu thanh cong" + size);
	}
//	
}
