package dao.impl;

import dao.NhanVien_DAO;
import dao.Impl.NhanVienImpl;
import dao.Impl.ChucVuImpl;
import dao.Impl.DangNhapImpl;
import dao.ChucVu_DAO;
import dao.DangNhap_DAO;
import entity.NhanVien;
import entity.ThongTinDangNhap;
import entity.ChucVu;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.rmi.RemoteException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class mainTestDangNhap {
	
	/*
	 * Huỳnh Công Vương _ 21004195
     */
	
	private DangNhap_DAO dangNhapDao;
	private ChucVu_DAO chucVuDao;
	private NhanVien_DAO nhanVienDao;
	private NhanVien x;
	private ChucVu cv;
	
	@BeforeAll
	void setUp() throws Exception {
		nhanVienDao = new NhanVienImpl();
		chucVuDao = new ChucVuImpl();
		dangNhapDao = new DangNhapImpl();
	}
	
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		nhanVienDao = new NhanVienImpl();
		chucVuDao = new ChucVuImpl();
		dangNhapDao = new DangNhapImpl();
	}

	@AfterAll
	void tearDownAfterClass() throws Exception {
		nhanVienDao = null;
		chucVuDao = null;
		dangNhapDao = null;
	}
	
//	@Test
//	void testKiemTraDangNhap() throws RemoteException {
//		assertTrue(dangNhapDao.kiemTraDangNhap("0941424359", "123456"));
//		System.out.println("Test kiemTraDangNhap() thanh cong");
//		
//	}
	
//	@Test
//	void testLayChucVu() throws RemoteException {
//	    // Giả sử số điện thoại và mật khẩu dưới đây tương ứng với một nhân viên có chức vụ là "Quản lý"
//	    String soDienThoai = "0941424359";
//	    String matKhau = "123456";
//
//	    // Gọi phương thức layChucVu
//	    String chucVu = dangNhapDao.layChucVu(soDienThoai, matKhau);
//
//	    // Kiểm tra xem chức vụ trả về có đúng là "Quản lý" không
//	    assertEquals("Quản lý Karaoke", chucVu);
//	    System.out.println("Test layChucVu() thanh cong") ;
//	}
	
	@Test
	void layTenNhanVien() throws RemoteException {
        // Giả sử số điện thoại và mật khẩu dưới đây tương ứng với một nhân viên có tên là "Vương"
        String soDienThoai = "0941424359";
        String matKhau = "123456";
        dangNhapDao.layTenNhanVien(soDienThoai, matKhau);
        assertEquals("Duong Ngo Manh", ThongTinDangNhap.getTenNhanVien());
        System.out.println("Test layTenNhanVien() thanh cong" + ThongTinDangNhap.getTenNhanVien()) ;
	}
	
	@Test 
	void layMaNhanVien() throws RemoteException {
		String soDienThoai = "0941424359";
        String matKhau = "123456";
        dangNhapDao.layMaNhanVien(soDienThoai, matKhau);
        assertEquals("NV001", ThongTinDangNhap.getMaNhanVien());
        System.out.println("Test layMaNhanVien() thanh cong" + ThongTinDangNhap.getMaNhanVien()) ;
	}
}
